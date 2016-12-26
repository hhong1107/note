## spring-boot中的日志设计
- LogBack和Log4j都是开源日记工具库，LogBack是Log4j的改良版本，比Log4j拥有更多的特性，同时也带来很大性能提升。


### 设计
  1. 线上和开发环境日志级别分开
  2. error日志单独打印
  3. 每天生成一个日志文件，保存30天的日志文件(或者每小时一个)
  4. 打印纯业务数据
  ```
  logger.info("#[{}],request={}","开户服务",request.toString());
  ```
  5. 使用ToStringBuilder重写toString方法(如果需要日志脱敏可以在这里做处理)
  ```
  @Override
public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
}

  ```

### 配置步骤
1. 在 src/main/resources 下面创建 logback-spring.xml  
  ```
  <?xml version="1.0" encoding="UTF-8"?>
  <configuration>
      <include resource="org/springframework/boot/logging/logback/base.xml" />
      <logger name="org.springframework.web" level="INFO"/>
  ```
其中include 的是spring-boot 中的默认配置
  ```
    ${PID}，当前进程ID
    ${LOG_FILE}，Spring Boot配置文件中logging.file的值
    ${LOG_PATH}, Spring Boot配置文件中logging.path的值
  ```

  ```
  %d{HH:mm:ss.SSS}——日志输出时间
  %thread——输出日志的进程名字，这在Web应用以及异步任务处理中很有用
  %-5level——日志级别，并且使用5个字符靠左对齐
  %logger{36}——日志输出者的名字
  %msg——日志消息
  %n——平台的换行符
  ```
2. 依赖jar
```
<!--日志过滤器需要 否则报java.lang.ClassNotFoundException: org.codehaus.janino.ScriptEvaluato-->
<dependency>
    <groupId>janino</groupId>
    <artifactId>janino</artifactId>
    <version>2.5.10</version>
</dependency>
```


3. 完整的配置

```
<?xml version="1.0" encoding="UTF-8"?>
<configuration scan="false" >

    <!--<property name="APP_Name" value=${application,name} />-->

    <include resource="org/springframework/boot/logging/logback/base.xml" />

    <!--打印完整日志-->
    <appender name="dailyRollingFileAppender" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <File>${LOG_PATH}/full/full-${LOG_FILE}</File>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- daily rollover -->
            <FileNamePattern>full-${LOG_FILE}.%d{yyyy-MM-dd}</FileNamePattern>
            <!-- keep 30 days' worth of history -->
            <maxHistory>30</maxHistory>
        </rollingPolicy>
        <encoder>
            <Pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{35} - %msg %n</Pattern>
        </encoder>
    </appender>

    <!--利用过滤器过滤出印业务日志-->
    <appender name="appFileAppender" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <File>${LOG_PATH}/${LOG_FILE}</File>
        <filter class="ch.qos.logback.core.filter.EvaluatorFilter">
            <evaluator> <!-- 默认为 ch.qos.logback.classic.boolex.JaninoEventEvaluator -->
                <expression>return message.contains("#[");</expression>
            </evaluator>
            <OnMatch>ACCEPT </OnMatch>
            <OnMismatch>DENY</OnMismatch>
        </filter>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- daily rollover -->
            <FileNamePattern>${LOG_FILE}.%d{yyyy-MM-dd}</FileNamePattern>
            <!-- keep 30 days' worth of history -->
            <maxHistory>30</maxHistory>
        </rollingPolicy>
        <encoder>
            <Pattern>%d{HH:mm:ss.SSS} - %msg %n</Pattern>
        </encoder>
    </appender>

    <!--利用过滤器过滤出error日志-->
    <appender name="errorFileAppender" class="ch.qos.logback.core.FileAppender">
        <File>${LOG_PATH}/error-${LOG_FILE}</File>
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>ERROR</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <encoder>
            <Pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{35} - %msg %n</Pattern>
        </encoder>
    </appender>



    <springProfile name="test,dev">
        <!--<logger name="org.springframework.web" level="DEBUG" />-->
        <!--<logger name="org.springboot.sample" level="DEBUG" />-->
        <logger name="com.fincar" level="DEBUG">
            <appender-ref ref="appFileAppender"/>
        </logger>
        <root level="info" >
            <appender-ref ref="dailyRollingFileAppender"/>
            <appender-ref ref="errorFileAppender"/>
        </root>
    </springProfile>

    <springProfile name="prod" >
        <logger name="org.springframework.web" level="ERROR"/>
        <logger name="org.springboot.sample" level="ERROR" />
        <logger name="com.fincar" level="INFO">
            <appender-ref ref="appFileAppender"/>
        </logger>

        <root level="info" >
            <appender-ref ref="dailyRollingFileAppender"/>
            <appender-ref ref="errorFileAppender"/>
        </root>
    </springProfile>


</configuration>

```


4. 代码中使用：
```
 private Logger logger =  LoggerFactory.getLogger(this.getClass());
```


#### logback
 <property>:用来定义变量值的标签，<property> 有两个属性，name和value；其中name的值是变量的名称，value的值时变量定义的值。通过<property>定义的值会被插入到logger上下文中。定义变量后，可以使“${}”来使用变量。


----
#### 参考网站
- [spring boot日志升级篇—logback【从零开始学Spring Boot】](http://412887952-qq-com.iteye.com/blog/2307244) 里面有一些spring boot 相关的
- [Spring Boot Logback应用日志](http://blog.csdn.net/xiaoyu411502/article/details/48295973)
- [logback 配置详解（一）](http://blog.csdn.net/haidage/article/details/6794509)Logback的一系列教程
- [ logback 常用配置详解（二） <appender>](http://blog.csdn.net/haidage/article/details/6794529)
- [logback logback.xml常用配置详解（三） <filter>](http://blog.csdn.net/haidage/article/details/6794540)
- [项目中用到的logback列子](http://blog.csdn.net/haidage/article/details/6797039)
- [使用ToStringBuilder重写toString方法](http://my.oschina.net/moxia/blog/308536)
- []()
- [redis命令中文手册](http://blog.csdn.net/haidage/article/details/6804170)
- [Spring Boot日志管理](http://www.jianshu.com/p/59787a123b05)
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
- []()
- []()
- []()
- []()
- []()
- []()
- []()
