



````shell

# 启动命令
./build/env/bin/hue runserver_plus 0.0.0.0:8888 
# 配置文件位置： /hue/desktop/conf.dist/hue.ini
/hue/desktop/conf# vim pseudo-distributed.ini
# 设置是否启动mr  默认设置是more 会根据情况启动
hive.fetch.task.conversion=none

# 启动 hiveserver2 提供给hue访问
./hive --service hiveserver2 --hiveconf hive.server2.thrift.port=10001
````



[官网](http://gethue.com/category/hive-fr/)

-[hive官网](http://www.apache.org/dyn/closer.cgi/hive/)

-[hue git地址](https://github.com/cloudera/hue)

-[hue官网](http://gethue.com/hadoop-tutorials-series-ii-8-how-to-transfer-data/)

https://github.com/cloudera/hue/tree/master/tools/docker

#### 参考网站

-[Hue安装配置实践](http://shiyanjun.cn/archives/1002.html)

-[Hue（四）集成Hive](http://blog.csdn.net/maomaosi2009/article/details/45648829)

-[安装Hue后的一些功能的问题解决干货总结（博主推荐）](http://www.cnblogs.com/zlslch/p/6819622.html)

-[使用Docker安装HUE](http://blog.csdn.net/u012948976/article/details/51763338) 中文的 其实看英文的也差不多

-[安装Hue后的一些功能的问题解决干货总结（博主推荐）](http://www.cnblogs.com/zlslch/p/6819622.html)

-[安装Hue后的一些功能的问题和解决](http://blog.csdn.net/eason_oracle/article/details/52191897)

[hive查询优化总结](http://blog.csdn.net/azhao_dn/article/details/7707811)

[Hadoop集群之Hive安装配置](http://blog.csdn.net/blue_jjw/article/details/50479263)

-[Hive Web接口HWI的操作及使用](http://www.ithao123.cn/content-648234.html)

-[新手安装 hadoop、hive和hbase 笔记](http://www.cnblogs.com/chenfool/p/3574789.html)

-[Hive整合HBase，操作HBase表](http://www.cnblogs.com/1130136248wlxk/articles/5517726.html)

[hadoop，hbase，hive安装全记录](http://blog.csdn.net/chengweipeng123/article/details/7174717)参考了这个网站的

-[Hive集成HBase详解](http://www.cnblogs.com/MOBIN/p/5704001.html)

[HUE安装及问题](http://blog.csdn.net/sinat_25306771/article/details/53534017)

-[Hue（四）集成Hive](http://blog.csdn.net/maomaosi2009/article/details/45648829)

-[HUE配置文件hue.ini 的sqoop模块详解（图文详解）（分HA集群）](http://www.cnblogs.com/zlslch/p/6820409.html)

-[sqoop2-1.99.5-cdh5.5.4.tar.gz的部署搭建](http://www.cnblogs.com/zlslch/p/6821763.html)

-[框架Hue环境的搭建](http://www.jianshu.com/p/87b76a686216)

[HUE的简单介绍](http://blog.csdn.net/ywheel1989/article/details/51560312)



#### 问题查询

-https://community.hortonworks.com/questions/38116/hive-query-failing-with-orgapachehiveserviceclihiv.html

-[Hive学习之HiveServer2服务端配置与启动](http://www.aboutyun.com/thread-12278-1-1.html)

-[Hive hiveserver2 配置运行](http://blog.csdn.net/wind520/article/details/44084953)

-[Hue问题记录](http://www.ithao123.cn/content-1389854.html)

[Hue集成的一些问题](http://blog.csdn.net/u014658112/article/details/72751191)

- org.apache.hadoop.security.authorize.AuthorizationException

主要是hadoop权限的问题 修改  /home/hd01/opt/hadoop-2.7.1/etc/hadoop/core-site.xml 加入

注意用户名

````xml

<property>
        <name>hadoop.proxyuser.hd01.hosts</name>
        <value>*</value>
    </property>

    <property>
            <name>hadoop.proxyuser.hd01.groups</name>
            <value>*</value>
    </property>
````

https://stackoverflow.com/questions/16582126/getting-e0902-exception-occured-user-oozie-is-not-allowed-to-impersonate-ooz

https://my.oschina.net/gently/blog/683604

-[2 hive的使用 + hive的常用语法](http://www.cnblogs.com/zlslch/p/5947630.html)

https://community.hortonworks.com/questions/38116/hive-query-failing-with-orgapachehiveserviceclihiv.html

-[hive创建hbase外部表的问题 ](http://www.aboutyun.com/thread-18495-2-1.html)  目前碰到的问题与之类似

[Hive2.1.0的 Web Interface配置](http://blog.csdn.net/cuihaolong/article/details/52064824) 这个是hwi的 生产一般使用hue

-[Hive启动时，报错RelativepathinabsoluteURI:${system:java.io.tmpdir}](http://www.2cto.com/net/201702/596974.html)

[Hive学习1_hive配置遇到的问题：Relative path in absolute URI: ${system:java.io.tmpdir%7D/$%7Bsystem:user.name%](http://blog.csdn.net/wang_zhenwei/article/details/50561619)

-[hive 未初始化元数据库报错](http://www.bubuko.com/infodetail-1834078.html)

````shell
第一次需要执行初始化命令：schematool -dbType mysql -initSchema
````

[hive 部署需要注意的几点以及Version information not found 错误解决办法](http://blog.csdn.net/youngqj/article/details/19987727)

-[]()

-[]()

-[]()

-[]()

-[]()

-[]()

-[]()



````xml
 方法2：修改Hadoop配置文件hdfs-site.xml，修改dfs.permissions 数据为false。
  <property>
    <name>dfs.permissions</name>
    <value>false</value>
  </property>
````

