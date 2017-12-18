
<!-- toc -->

- [Spring Boot 参考网站](#spring-boot-参考网站)
- [其他](#其他)
- [拦截器](#拦截器)
- [AOP](#aop)
- [spring boot start](#spring-boot-start)
- [获取配置文件值](#获取配置文件值)
- [参考网站](#参考网站)

<!-- tocstop -->



#### Spring Boot 参考网站
- [spring-boot实战](http://blog.csdn.net/liaokailin?viewmode=contents)
- [Spring Boot——开发新一代Spring Java应- 用](http://www.tianmaying.com/tutorial/spring-boot-overview)
- [Spring Cloud学习笔记——Netflix的那些东西](http://blog.loli.io/2016/02/21/spring-cloud-netflix-01/)
- [Spring Cloud官方文档](http://cloud.spring.io/spring-cloud-static/docs/1.0.x/spring-cloud.html)
- [Spring cloud项目实践](http://sail-y.github.io/2016/03/21/Spring-cloud项目实践/)
- [微服务框架](http://www.cnblogs.com/skyblog/category/774535.html)
- [Spring Boot 属性配置和使用 ](http://blog.csdn.net/isea533/article/details/50281151)
- [ Spring Boot 静态资源处理 ](http://blog.csdn.net/isea533/article/details/50412212)
- [Spring Boot Junit单元测试](https://yq.aliyun.com/articles/6925)
- [如何优雅地停止运行中的内嵌Tomcat的Spring Boot应用](http://jaskey.github.io/blog/2016/04/05/shutdown-spring-boot-application-gracefully/)
- [正确、安全地停止SpringBoot应用服务](http://www.jianshu.com/p/44ef43b282f0)
- [服务链路追踪](https://zhuanlan.zhihu.com/p/26991897)
- []()
- []()
- []()
- []()
- []()
- []()
  ![example](../label/img/架构图.png)


启动：
[Spring Boot 部署与服务配置](http://blog.csdn.net/catoop/article/details/50588851)

```
- java启动
nohup java -jar ./fincar-common-server-1.0.0-SNAPSHOT.jar --spring.cloud.config.profile='${config.profile:stg}' &


- 这个注解可以解析出配置文件中的字符成数组
@RabbitListener(queues = "#{'${account.open.queue.names}'.split(',')}" )

private @Value("#{T(java.util.Arrays).asList(projectProperties['my.list.of.strings'])}") List<String> myList;

```

#### 其他
- [Spring-boot中读取config配置文件的两种方式](http://www.aichengxu.com/view/2543992)
- [在Spring Boot中使用 @ConfigurationProperties 注解](在Spring Boot中使用 @ConfigurationProperties 注解)
```
@ConfigurationProperties(prefix = "spring.db_items",locations = "classpath:config/db.properties")
```


#### 拦截器
- [spring-boot学习笔记之Web拦截器](http://www.jianshu.com/p/f14ed6ca4e56)
- [spring boot 中使用spring mvc interceptor(拦截器)判断操作权限](https://my.oschina.net/gmd/blog/615849)
- [Spring Boot 拦截器](http://blog.csdn.net/catoop/article/details/50501696)
- [Spring Boot中使用AOP统一处理Web请求日志
  ](http://www.tuicool.com/articles/3qY7vqj)
- [spring aop 面向切面编程初接触](http://www.cnblogs.com/lic309/p/4079194.html)
- [HTTP cookies 详解](http://www.jianshu.com/p/8731e8d62b3d)
- [HTTP cookies 详解](http://bubkoo.com/2014/04/21/http-cookies-explained/)
- []()
- []()
- []()
- []()
- []()
- []()

#### AOP
    Spring AOP中，当拦截对象实现了接口时，生成方式是用JDK的Proxy类。当没有实现任何接口时用的是GCLIB开源项目生成的拦截类的子类.
- [ Spring中的AOP（四）——在Advice方法中获取目标方法的参数](http://blog.csdn.net/caomiao2006/article/details/51287200)
- [Spring中的AOP（五）——在Advice方法中获取目标方法的参数](https://my.oschina.net/itblog/blog/211693)


- [Spring Boot 开启AOP的方法](http://www.jianshu.com/p/c690de40e2bf)
- [spring aop 面向切面编程初接触](http://www.cnblogs.com/lic309/p/4079194.html)
- [Spring Boot中使用AOP统一处理Web请求日志](http://www.tuicool.com/articles/3qY7vqj)
- [spring boot 使用spring AOP实现拦截器](http://blog.csdn.net/clementad/article/details/52035199)
- []()
- []()

#### spring boot start
- [Spring Boot：定制自己的starter](http://www.jianshu.com/p/85460c1d835a)  
  spring.factories 关键是这个文件，在这里面可以配置如AopAutoConfiguration 类，spring初始化的时候就会找对应的类了(AopAutoConfiguration包附近的类应该都能被这样使用)

- [Spring Boot的自动配置、Command-line Runner](http://www.jianshu.com/p/846bb2d26ff8)  
- [深入SpringBoot:自定义Conditional](http://www.jianshu.com/p/1d0fb7cd8a26)
- [@EnableAutoConfiguration原理及自定义扩展](http://blog.csdn.net/xiaoyu411502/article/details/52770723)
- []()
- []()
- []()
- []()
- []()

#### 获取配置文件值
- [SpringBoot读取application.properties文件](http://blog.csdn.net/jixuju/article/details/52205500)
- [ Spring Boot 属性配置和使用 ](http://blog.csdn.net/isea533/article/details/50281151)
```
private Enviroment env;
env.getProperty("test.url");
```



uml 配置：

````yaml
spring.redis.cluster.nodes[0]=192.168.0.1:6379  
spring.redis.cluster.nodes[1]=192.168.0.2:6379  
或  
spring:  
   redis:  
      cluster:  
         nodes:  
            - 192.168.0.1:6379  
            - 192.168.0.2:6379  
````







#### 参考网站

- [spring官网](http://start.spring.io/)

- [SpringBoot文档-英文](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/?cm_mc_uid=14358288081314078496117&cm_mc_sid_50200000=1465543344)

- [SpringBoot文档](https://qbgbook.gitbooks.io/spring-boot-reference-guide-zh/content/)

- [SpringBoot相关的简书](http://www.jianshu.com/collection/f0cf6eae1754)

- [SpringBoot和Mybatis整合](http://www.jianshu.com/p/5ef281100bb6#)

- [Running Dubbo On Spring Boot](http://www.jianshu.com/p/ed466de44967)

- [深入学习微框架：Spring Boot](http://www.infoq.com/cn/articles/microframeworks1-spring-boot)

- [使用 Spring Boot 快速构建 Spring 框架应用](https://www.ibm.com/developerworks/cn/java/j-lo-spring-boot/)

- [文档翻译-git](https://github.com/qibaoguang/Spring-Boot-Reference-Guide/blob/master/SUMMARY.md#summary)

- [使用Spring Boot创建微服务](http://www.infoq.com/cn/articles/boot-microservices)

- [Spring Boot中使用@Async实现异步调用](http://blog.didispace.com/springbootasync/)

  [SpringBoot应用服务启动与安全终止](http://blog.csdn.net/wangshuang1631/article/details/62054798)
