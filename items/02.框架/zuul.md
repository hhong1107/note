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

  ## 问题

  ### serviceId 改为url

  现象：facade-app 报 com.fasterxml.jackson.databind.JsonMappingException: No suitable 

  说明该系统无法解析报文

  通过断点以下类的代码

  /home/jh/~/codes/.m2/repository/org/springframework/spring-webmvc/4.2.6.RELEASE/spring-webmvc-4.2.6.RELEASE-sources.jar!/org/springframework/web/servlet/mvc/method/annotation/AbstractMessageConverterMethodArgumentResolver.java:196

````java
// IoUtiles.toString(inputMessage.getBody())   
// 发现这里的报文已经被截取了
if (inputMessage.getBody() != null) {
    inputMessage = getAdvice().beforeBodyRead(inputMessage, param, targetType, converterType);
    body = genericConverter.read(targetType, contextClass, inputMessage);
    body = getAdvice().afterBodyRead(body, inputMessage, param, targetType, converterType);
}

/**
/home/jh/~/codes/.m2/repository/org/springframework/spring-webmvc/4.2.6.RELEASE/spring-webmvc-4.2.6.RELEASE-sources.jar!/org/springframework/web/servlet/mvc/method/annotation/RequestMappingHandlerAdapter.java:743

这里发现 header中有个字段 context-length 刚好是被截取到的报文长度
而这个值是 最原始的app发起请求的时候的报文长度 也就是说 在网关处理塞入新的字段后 报文已经比原始的长了，而网关把原始的 context-length 传给了下游系统。而下游系统在接到报文后以这个长度为标准去截取了不完整的字符串。

  
 */ 
  
````

解决办法：让网关不要把context-length转发下来



````properties

zuul.routes.ddsc-facade-app.path=/ddsc-app/**
zuul.routes.ddsc-facade-app.serviceId=ddsc-facade-app
# ribbon禁掉Eureka
ribbon.eureka.enabled=false
# 下面 如果配多个地址 用, 隔开的话是可以实现负载均衡的
ddsc-facade-app.ribbon.listOfServers=http://192.168.3.30:6060/
````



-[使用Zuul构建API Gateway](https://blog.csdn.net/zhanglh046/article/details/78651993) 参考这个网站-还有很多内容如 文件上传等

-[springCloud（15）：使用Zuul构建微服务网关-Header与文件上传和过滤器](http://blog.51cto.com/1754966750/1958684)

-[Zuul(SpringCloud学习笔记一)](http://www.cnblogs.com/xd03122049/p/6036318.html) 这个网站也有正确的配置



网上的一份配置

https://blog.csdn.net/mn960mn/article/details/51832753

````properties
server.port=8181  
  
#这里的配置表示，访问/baidu/** 直接重定向到http://www.baidu.com  
zuul.routes.baidu.path=/baidu/**  
zuul.routes.baidu.url=http://www.baidu.com  
  
#反响代理配置  
#这里的配置类似nginx的反响代理  
#当请求/api/**会直接交给listOfServers配置的服务器处理  
#当stripPrefix=true的时候 （http://127.0.0.1:8181/api/user/list -> http://192.168.1.100:8080/user/list）  
#当stripPrefix=false的时候（http://127.0.0.1:8181/api/user/list -> http://192.168.1.100:8080/api/user/list）  
zuul.routes.api.path=/api/**  
zuul.routes.api.stripPrefix=false  
api.ribbon.listOfServers=192.168.1.100:8080,192.168.1.101:8080,192.168.1.102:8080  
  
#url重写配置  
#这里的配置，相当于访问/index/** 会直接渲染/home的请求内容(和直接请求/home效果一样), url地址不变  
zuul.routes.index.path=/index/**  
zuul.routes.index.url=forward:/home  
````



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
