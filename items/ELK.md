- [ELK官网](https://www.elastic.co)


- [非常有价值的书](https://www.gitbook.com/book/chenryn/elk-stack-guide-cn/details)



- [ ] 先解决logstash输入
- [ ] dissect 插件去匹配日志







#### 通过redis传输

[Logback和Logstash的集成](http://blog.csdn.net/kmtong/article/details/38920327)

[github文档](https://github.com/kmtong/logback-redis-appender)

[官方文档](https://www.elastic.co/guide/en/logstash/current/plugins-inputs-redis.html)

[ELKstack 中文指南](http://kibana.logstash.es/content/logstash/plugins/filter/grok.html)



````xml
<dependency>  
  <groupId>com.cwbase</groupId>  
  <artifactId>logback-redis-appender</artifactId>  
  <version>1.0.0</version>  
</dependency>  
````

logback.xml

````xml
<configuration>  
  <appender name="LOGSTASH" class="com.cwbase.logback.RedisAppender">  
    <source>YOUR_APPLICATION_NAME</source>  
    <type>test</type>  
    <host>YOUR_REDIS_SERVER</host>  
    <key>logstash</key>   <!-- 这个Key是Redis List的Key，需要和Logstash读取Redis的Key匹配 -->  
    <tags>test</tags>  
    <mdc>true</mdc>  
    <location>true</location>  
    <callerStackIndex>0</callerStackIndex>  
  </appender>  
  
  <root level="DEBUG">  
    <appender-ref ref="LOGSTASH" />  
  </root>  
  
</configuration>  
````







````
input {
  redis {
    host => "192.168.3.198"
    key => "logstash"
    data_type => "list"
  }
}

output {
  stdout { codec => rubydebug }
````





````
使用命令模板: 
    /bin/logstash 命令参数  选项 

选项: 
    -f ， 指定加载一个后缀为.conf文件的logstash配置模块 
    -e  , 命令行指定参数 ， 通常用来调试 
    -w,  指定logstash的工作线程数 
    -l,   指定logstash的默认日志写入到一个文件中，如果不指定，默认是标准输出 
    --quiet                       静默模式，仅仅只有error级别信息输出 
    --verbose                   info级别的log输出 
    --debug                      debug 级别的log输出. 
    -V, --version                查看logstash的版本 
    -p, --pluginpath PATH         加载自定义的logstash插件 
    -t, --configtest               检查logstash配置是否有效 
    -h, --help                    打印帮助 


（三）logstash的数据处理模型 

（1）input  =》 output 
（2）input =》 filter =》 output 

其中input常用的输入源有：file，syslog，redis，log4j，apache log或nginx log，或者其他一些自定义的log格式，业务log，搜索log，订单log等等

filter常用的选项有： 
grok：支持正则提取任何非结构化数据或结构化数据，其中logstash内置120多种正则，比如常见的时间，ip，用户名，等等也支持自定义正则解析 
mutate：修改字段名，删除，更新等操作，转换字段类型等 
drop： 删除某些时间，如debug 
clone：拷贝一份事件副本，用来添加或删除字段 
geoip : 通过ip获取地理位置信息，在做kibana区域统计图非常炫 
ruby： 支持原生的ruby代码，操作事件，实现强大的其他功能 

output常用的输出有： 
elasticsearch 比较常用 
file：写入文件 
redis：写入队列 
hdfs：写入HDFS，需插件支持 
zabbix： zabbix监控 
mongodb：写入mongodb库 
````





#### 参考网站

- [分布式日志收集之Logstash 笔记（一）](http://blog.csdn.net/u010454030/article/details/49659467)
- [分布式日志收集之Logstash 笔记（二）](http://blog.csdn.net/u010454030/article/details/49680531)
- [logstash快速入门](http://www.2cto.com/os/201411/352015.html)
- [SpringBoot应用之ELK](https://segmentfault.com/a/1190000004416276)
- [logstash使用grok正则解析日志](http://blog.csdn.net/earbao/article/details/49306465) ##
- [Elasticsearch权威指南（中文版）](http://es.xiaoleilu.com/010_Intro/10_Installing_ES.html)
- [分布式日志平台--ELKStack实践](http://ucode.blog.51cto.com/10837891/1775157)
- [ELKstack 中文指南](http://kibana.logstash.es/content/logstash/get-start/hello-world.html)

[ElasticSearch 5学习(2)——Kibana+X-Pack介绍使用（全）]: http://www.cnblogs.com/wxw16/p/6156335.html?utm_source=itdadao&amp;utm_medium=referral

