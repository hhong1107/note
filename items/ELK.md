- [ELK官网](https://www.elastic.co)


- [非常有价值的书](https://www.gitbook.com/book/chenryn/elk-stack-guide-cn/details)



- [ ] 先解决logstash输入
- [ ] dissect 插件去匹配日志







#### 通过redis传输

[Logback和Logstash的集成](http://blog.csdn.net/kmtong/article/details/38920327)

[github文档](https://github.com/kmtong/logback-redis-appender)

[官方文档](https://www.elastic.co/guide/en/logstash/current/plugins-inputs-redis.html)

[ELKstack 中文指南](http://kibana.logstash.es/content/logstash/plugins/filter/grok.html)

[指南](https://kibana.logstash.es/content/kibana/v5/discover.html)

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
- [linux screen 命令详解](http://www.cnblogs.com/mchina/archive/2013/01/30/2880680.html)
- [elasticsearch外网IP无法访问](http://blog.csdn.net/buzaiqq/article/details/67637731)
- [搜索请求](https://kibana.logstash.es/content/elasticsearch/api/search.html)
- [官方api文档](https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-get.html)
- [19.ELK实时日志分析平台之Elasticsearch REST API简介](http://blog.csdn.net/a464057216/article/details/50909215)
- [kibana使用的lucene查询语法](http://blog.csdn.net/jiao_fuyou/article/details/49662051)
- -[基于ELK的数据分析实践——满满的干货送给你](http://www.cnblogs.com/xing901022/p/6596182.html)
- [20.ELK实时日志分析平台之Elasticsearch 查询简介](http://blog.csdn.net/a464057216/article/details/50917500)
- -[Elasticsearch——Rest API中的常用用法](http://www.cnblogs.com/xing901022/p/5303740.html)
- http://192.168.3.67:9200/logstash-2017.07.21/_search?pretty&size=10
- [看所有索引](http://192.168.3.67:9200/_cat/indices?v)
- [过滤查询以及聚合(Filtering Queries and Aggregations)](http://blog.csdn.net/dm_vincent/article/details/42757519)
- [ElasticSearch java API - 聚合查询](https://elasticsearch.cn/article/102)
- [官方java-api文档](https://www.elastic.co/guide/en/elasticsearch/client/java-api/5.1/transport-client.html)
- [Elasticsearch 5.X下JAVA API使用指南](http://blog.csdn.net/napoay/article/details/53581027)
- [ElasticSearch Java Api(一) －创建索引](http://blog.csdn.net/napoay/article/details/51707023)
- [在 Java 应用程序中使用 Elasticsearch](https://www.ibm.com/developerworks/cn/java/j-use-elasticsearch-java-apps/)
- [Spark搭档Elasticsearch](https://yq.aliyun.com/articles/52440)
- [spark与elasticsearch整合](http://blog.csdn.net/myproudcodelife/article/details/50985057)
- [相关教程](http://www.sojson.com/tag_elasticsearch.html)
  -
- [elasticsearch 深分页问题以及解决方法](http://blog.csdn.net/wild46cat/article/details/64123353)
- [Elasticsearch使用scroll进行分页查询](http://blog.csdn.net/lom9357bye/article/details/64500638)
- [elasticsearch中的mapping简介](http://blog.csdn.net/lvhong84/article/details/23936697)
- [Elasticsearch索引mapping的写入、查看与修改](http://blog.csdn.net/napoay/article/details/52012249)
- -[Elasticsearch——分页查询From&Size VS scroll](http://www.cnblogs.com/xing901022/p/5284902.html)
- -[Elasticsearch基本概念及核心配置文件详解](http://www.cnblogs.com/xiaochina/p/6855591.html)
- []()
- []()
- []()
- []()
- []()
- []()

### 参考网站-tmp

-[elasticsearch基本操作之--使用QueryBuilders进行查询](http://www.cnblogs.com/wenbronk/p/6432990.html)

- [Elasticsearch教程（五） elasticsearch Mapping的创建](http://www.sojson.com/blog/86.html)
- [Elasticsearch java API (18)Aggregations 聚合 Bucket](http://blog.csdn.net/u012116196/article/details/51790016)
- [聚合中的重要概念 - Buckets(桶)及Metrics(指标)](http://blog.csdn.net/dm_vincent/article/details/42387161)
- -[Elasticsearch聚合 之 Terms](http://www.cnblogs.com/xing901022/p/4947436.html)
- [使用 ElasticSearch Aggregations 进行统计分析](http://blog.csdn.net/zxjiayou1314/article/details/53837719)
- [Elasticsearch count 查询，Elasticsearch 查询是否存在](http://www.sojson.com/blog/206.html)
- -[Elasticsearch 统计代码例子](http://www.cnblogs.com/didda/p/5485681.html)
- [聚合的测试数据](http://blog.csdn.net/dm_vincent/article/details/42407823)
- [实时搜索引擎Elasticsearch（4）——Aggregations （聚合）API的使用](http://blog.csdn.net/xialei199023/article/details/48298635)
- [ElasticSearch java API - 聚合查询](https://elasticsearch.cn/article/102)
- -[elasticsearch基本操作之--使用QueryBuilders进行查询](http://www.cnblogs.com/wenbronk/p/6432990.html)
- [ElasticSearch 全文检索 termQuery和queryString](http://blog.csdn.net/lishaojun0115/article/details/51837552)
- -[ElasticSearch的Java Api基本操作入门指南](http://aoyouzi.iteye.com/blog/2116597)
- -[elasticsearch基本操作之--java基本操作 api](http://www.cnblogs.com/wenbronk/p/6383194.html)
- []()
- []()
- []()
- []()
- []()
- []()
- []()

[ElasticSearch 5学习(2)——Kibana+X-Pack介绍使用（全）]: http://www.cnblogs.com/wxw16/p/6156335.html?utm_source=itdadao&amp;utm_medium=referral



[启动时使用多个配置文件](http://blog.csdn.net/ty_0930/article/details/52180470)

````
./logstash -f ../../conf/
````
