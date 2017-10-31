### 概要
- 首先，破坏了服务无状态特点。为了保证对外服务的安全性，我们需要实现对服务访问的权限控制，而开放服务的权限控制机制将会贯穿并污染整个开放服务的业务逻辑，这会带来的最直接问题是，破坏了服务集群中REST API无状态的特点。从具体开发和测试的角度来说，在工作中除了要考虑实际的业务逻辑之外，还需要额外可续对接口访问的控制处理。
- 其次，无法直接复用既有接口。当我们需要对一个即有的集群内访问接口，实现外部服务访问时，我们不得不通过在原有接口上增加校验逻辑，或增加一个代理调用来实现权限控制，无法直接复用原有的接口。
- 为了解决上面这些问题，我们需要将权限控制这样的东西从我们的服务单元中抽离出去，而最适合这些逻辑的地方就是处于对外访问最前端的地方，我们需要一个更强大一些的均衡负载器，它就是本文将来介绍的：服务网关。
- 服务网关是微服务架构中一个不可或缺的部分。通过服务网关统一向外系统提供REST API的过程中，除了具备服务路由、均衡负载功能之外，它还具备了权限控制等功能。Spring Cloud Netflix中的Zuul就担任了这样的一个角色，为微服务架构提供了前门保护的作用，同时将权限控制这些较重的非业务逻辑内容迁移到服务路由层面，使得服务集群主体能够具备更高的可复用性和可测试性。

- Zuul提供了一个框架，可以对过滤器进行动态的加载，编译，运行。过滤器之间没有直接的相互通信。他们是通过一个RequestContext的静态类来进行数据传递的。RequestContext类中有ThreadLocal变量来记录每个Request所需要传递的数据。

- Zuul可以通过加载动态过滤机制，从而实现以下各项功能：
  - 验证与安全保障: 识别面向各类资源的验证要求并拒绝那些与要求不符的请求。
  - 审查与监控: 在边缘位置追踪有意义数据及统计结果，从而为我们带来准确的生产状态结论。
  - 动态路由: 以动态方式根据需要将请求路由至不同后端集群处。
  - 压力测试: 逐渐增加指向集群的负载流量，从而计算性能水平。
  - 负载分配: 为每一种负载类型分配对应容量，并弃用超出限定值的请求。
  - 静态响应处理: 在边缘位置直接建立部分响应，从而避免其流入内部集群。
  - 多区域弹性: 跨越AWS区域进行请求路由，旨在实现ELB使用多样化并保证边缘位置与使用者尽可能接近。


----
- 过滤器是由Groovy写成。这些过滤器文件被放在Zuul Server上的特定目录下面。Zuul会定期轮询这些目录。修改过的过滤器会动态的加载到Zuul Server中以便于request使用。

- 有几种标准的过滤器类型：
  - PRE：这种过滤器在请求到达Origin Server之前调用。比如身份验证，在集群中选择请求的Origin Server，记log等。
  - ROUTING：在这种过滤器中把用户请求发送给Origin Server。发送给Origin Server的用户请求在这类过滤器中build。并使用Apache HttpClient或者Netfilx Ribbon发送给Origin Server。
  - POST：这种过滤器在用户请求从Origin Server返回以后执行。比如在返回的response上面加response header，做各种统计等。并在该过滤器中把response返回给客户。
  - ERROR：在其他阶段发生错误时执行该过滤器。
  - 客户定制：比如我们可以定制一种STATIC类型的过滤器，用来模拟生成返回给客户的response。


#禁用断路器超时，以免在重试前就被断路器断开
hystrix.command.default.execution.timeout.enabled=false


### 问题
- @ConditionalOnMissingBean annotations must specify at least one bean (type, name or annotation)
  可能是注解有冲突

```
//@EnableDiscoveryClient
//@SpringBootApplication
//@EnableCircuitBreaker
//@EnableDDSCAccountClient

```

### 配置
```
zuul.routes.retryable=true  重试开关？
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=6000
ribbon.ConnectTimeout=3000
ribbon.ReadTimeout=6000
```


### 参考网站
- [Spring Cloud构建微服务架构（五）服务网关](http://blog.didispace.com/springcloud5/)
- [spring 官网](http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html)
- [](http://lxlong.iteye.com/blog/2267985)
- [github地址](https://github.com/Netflix/zuul)
- [Netflix学习笔记：Zuul](http://lxlong.iteye.com/blog/2267985)
- [springcloud(第九篇)netflix zuul](http://blog.csdn.net/liaokailin/article/details/51525908)
- []()
- []()

----
##### gateway & facade？
- [SpringMVC中使用Interceptor拦截器](http://haohaoxuexi.iteye.com/blog/1750680)
- [第五章 处理器拦截器详解——跟着开涛学SpringMVC](http://jinnianshilongnian.iteye.com/blog/1670856)
- [SpringMVC拦截器详解 -附带源码分析](http://www.cnblogs.com/fangjian0423/p/springMVC-interceptor.html)
- [ java如何得到GET和POST请求URL和参数列表](http://blog.csdn.net/yaerfeng/article/details/18942739)
- [InputStream类只能读取一次](http://www.cnblogs.com/fzll/p/3400558.html)
- [ServletRequest中getReader()和getInputStream()只能调用一次的解决办法](http://liwx2000.iteye.com/blog/1542431)
- [SpringMVC源码剖析（五)-消息转换器HttpMessageConverter](http://my.oschina.net/lichhao/blog/172562)
- [SpringMVC中注解控制器及数据绑定](http://www.cnblogs.com/duanxz/p/5196087.html)
- [Spring filter和拦截器(Interceptor)的区别和执行顺序](http://www.cnblogs.com/ycpanda/p/3637312.html)
- [四种常见的 POST 提交数据方式](https://imququ.com/post/four-ways-to-post-data-in-http.html)
- [解决在Filter中读取Request中的流后, 然后再Control中读取不到的做法](http://my.oschina.net/vernon/blog/363693?fromerr=2jheR52d)
- [spring cloud-zuul的Filter详解](http://blog.csdn.net/liuchuanhong1/article/details/62236793) 这里有路由直接返回的的方法
- []()
- []()
- []()
- []()
- []()
- []()
- []()
- []()
- []()
- []()
- []()
- []()
