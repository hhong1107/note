<!-- toc -->

- [安装](#安装)
- [spring Redis](#spring-redis)
  - [参考网站](#参考网站)
- [redis参考网站](#redis参考网站)

<!-- tocstop -->



### 安装

- 初次安装好后是 要修改下 protected-mode 否则 telnet 192.168.3.198 6379 会报以下错误

```
$ wget http://download.redis.io/releases/redis-3.2.6.tar.gz
$ tar xzf redis-3.2.6.tar.gz
$ cd redis-3.2.6
$ make
```



```
-DENIED Redis is running in protected mode because protected mode is enabled, no bind address was specified, no authentication password is requested to clients. In this mode connections are only accepted from the loopback interface. If you want to connect from external computers to Redis you may adopt one of the following solutions: 1) Just disable protected mode sending the command 'CONFIG SET protected-mode no' from the loopback interface by connecting to Redis from the same host the server is running, however MAKE SURE Redis is not publicly accessible from internet if you do so. Use CONFIG REWRITE to make this change permanent. 2) Alternatively you can just disable the protected mode by editing the Redis configuration file, and setting the protected mode option to 'no', and then restarting the server. 3) If you started the server manually just for testing, restart it with the '--protected-mode no' option. 4) Setup a bind address or an authentication password. NOTE: You only need to do one of the above things in order for the server to start accepting connections from the outside.
Connection closed by foreign host.

CONFIG SET protected-mode no

- 解决办法：
  1. 通过redis-cli 设置
  [root@localhost src]# ./redis-cli
  127.0.0.1:6379> config set protected-mode no
  OK

  2. 配置redis.conf文件
  redis-3.2.3文件夹下有一个 redis.conf 在里面吧
  bind 127.0.0.1   注销掉 #
  protected-mode no  设置成no
  nohup ./redis-server redis.conf & 这样去启动
  [参考网站](http://blog.csdn.net/Agly_Clarlie/article/details/52251746)
```
启动： nohup ./redis-server redis.conf &
  采用redis.conf 作为配置文件 否则的话不用写 redis.conf


停止

使用客户端
redis-cli shutdown
因为Redis可以妥善处理SIGTERM信号，所以直接kill -9也是可以的
kill -9 PID

获取所有key：keys *

- [官网下载及安装](http://redis.io/download)
- [安装时报找不到gcc](http://blog.csdn.net/xie0812/article/details/22064167)
- [nohup启动](http://www.cnblogs.com/allenblogs/archive/2011/05/19/2051136.html)
- [Redis 命令参考](http://doc.redisfans.com/)
- [Redis操作命令总结](http://www.jb51.net/article/61793.htm)
- [Redis学习手册(Key操作命令)](http://www.cnblogs.com/stephen-liu74/archive/2012/03/26/2356951.html)
- [Redis的基本安装及使用](http://www.cnblogs.com/nick-huang/p/5762565.html)
- [Redis的三种启动方式](http://www.tuicool.com/articles/aQbQ3u)

### spring Redis

- @Cacheable:用来定义缓存的。常用到是value,key;分别用来指明缓存的名称和方法中参数，对于value你也可以使用cacheName，在查看源代码是我们可以看到：两者是指的同一个东西。
- @CacheEvict:用来清理缓存。常用有cacheNames，allEntries（默认值false）；分别代表了要清除的缓存名称和是否全部清除(true代表全部清除)。
- @CachePut:用来更新缓存，用它来注解的方法都会被执行，执行完后结果被添加到缓存中。该方法不能和@Cacheable同时在同一个方法上使用。
- 对于@Caching注解来讲，如果有两种不同的需求，都是放在同一个方法上，这种需求如果只是使用@CacheEvict或者@CachePut是无法实现，因为他们不能多样化的作用在同一个方法上。可以使用@Caching(evict={@CacheEvict(“a1”),@CacheEvict(“a2”,allEntries=true)})；
----
配置类中启动缓存
```java
@Configuration
@EnableCaching
public class CachingConfigurer extends CachingConfigurerSupport {
    /**
     * 生成key的策略
     *
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return CacheKeyGeneratorUtile.generate(target, method, params);
            }
        };
    }

    /**
     * 管理缓存
     *
     * @param redisTemplate
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        //设置缓存过期时间
        // rcm.setDefaultExpiration(60);//秒
        //设置value的过期时间
        Map<String, Long> map = new HashMap();
        map.put("test", 600L);
        rcm.setExpires(map);
        return rcm;
    }

    /**
     * RedisTemplate配置
     *
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
```
使用:
```
@Cacheable(value = "fincar-Account")
@Cachelabel(aggregateName = "fincar-Account",entityName = "account")

```
  #### 参考网站
- [Spring Cache抽象详解](http://jinnianshilongnian.iteye.com/blog/2001040)
- [Spring Cache](http://www.cnblogs.com/rollenholt/p/4202631.html)
- [使用AOP 实现Redis缓存注解](http://www.tuicool.com/articles/beUVjyB)
- [ spring整合redis缓存，以注解(@Cacheable、@CachePut、@CacheEvict)形式使用](http://blog.csdn.net/aqsunkai/article/details/51758900)
- [Spring缓存注解@Cache使用](http://tom-seed.iteye.com/blog/2104430)
- [@Cacheable注解在spring3中的使用-实现缓存]()
- [spring data redis RedisTemplate操作redis相关用法](http://blog.mkfree.com/posts/515835d1975a30cc561dc35d)
- [文档](http://www.redis.cn/documentation.html)

----
- [Spring Boot中的缓存支持（二）使用Redis做集中式缓存](http://blog.didispace.com/springbootcache2/)
- [Spring4.1新特性——Spring缓存框架增强](http://www.tuicool.com/articles/vEV7Bz)
- [Spring Boot使用redis做数据缓存](http://wiselyman.iteye.com/blog/2184884)
- [SpringBoot之redis](http://my.oschina.net/wangnian/blog/661389)
- [](http://jinnianshilongnian.iteye.com/blog/2001040)
- []()
- []()
- []()


### redis参考网站

- [redis命令](http://www.yiibai.com/redis/keys_ttl.html)
- [Memcache,Redis,MongoDB（数据缓存系统）方案对比与分析](http://blog.csdn.net/suifeng3051/article/details/23739295)
- [文档比较详细]([[http://www.redis.cn/documentation.html]])
- [简单教程](http://www.runoob.com/redis/redis-commands.html)
- [极客学院的教程](http://wiki.jikexueyuan.com/project/all-about-redis/DataStructure/key/expire.html)
- []()
- []()
- []()
- []()
