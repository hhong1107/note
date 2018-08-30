#### 参考网站

-[SpringCloud Zipkin](http://blog.csdn.net/z8414/article/details/78600646)

-[利用Zipkin对Spring Cloud应用进行服务追踪分析](https://yq.aliyun.com/articles/60165)



#### Actuator

````xml
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
````



| 路径           | 描述                                       |
| ------------ | ---------------------------------------- |
| /autoconfig  | 提供了一份自动配置报告，记录哪些自动配置条件通过了，哪些没通过          |
| /beans       | 描述应用程序上下文里全部的Bean，以及它们的关系                |
| /env         | 获取全部环境属性                                 |
| /configprops | 描述配置属性(包含默认值)如何注入Bean                    |
| /dump        | 获取线程活动的快照                                |
| /health      | 报告应用程序的健康指标，这些值由HealthIndicator的实现类提供    |
| /info        | 获取应用程序的定制信息，这些信息由info打头的属性提供             |
| /mappings    | 描述全部的URI路径，以及它们和控制器(包含Actuator端点)的映射关系   |
| /metrics     | 报告各种应用程序度量信息，比如内存用量和HTTP请求计数             |
| /shutdown    | 关闭应用程序，要求endpoints.shutdown.enabled设置为true |
| /trace       | 提供基本的HTTP请求跟踪信息(时间戳、HTTP头等)              |



- 如果只想打开一两个接口，那就先禁用全部接口，然后启用需要的接口：

````properties
endpoints.enabled = false
endpoints.metrics.enabled = true
````

- 安全建议

> 在使用Actuator时，不正确的使用或者一些不经意的疏忽，就会造成严重的信息泄露等安全隐患。在代码审计时如果是springboot项目并且遇到actuator依赖，则有必要对安全依赖及配置进行复查。也可作为一条规则添加到黑盒扫描器中进一步把控。
> 安全的做法是一定要引入security依赖，打开安全限制并进行身份验证。同时设置单独的Actuator管理端口并配置不对外网开放。

-[SpringBoot应用监控Actuator使用的安全隐患](https://xz.aliyun.com/t/2233)