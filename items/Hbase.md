





## Hbase集群搭建

- [官方文档](http://hadoop.apache.org/)

### 参考网站

- [Hadoop+HBase+ZooKeeper三者关系与安装配置](http://edu.dataguru.cn/thread-241488-1-1.html) 主要参考这个网站的示例
- [HA 模式下的 Hadoop+ZooKeeper+HBase 启动顺序](http://blog.csdn.net/u011414200/article/details/50437356)
- [hbase+zookeeper集群搭建](http://blog.csdn.net/lxf310/article/details/17263337)
- [Hadoop2.6+HA+Zookeeper3.4.6+HBase1.0.0集群安装](http://www.linuxidc.com/Linux/2015-08/121397.htm)
- [HBase集群安装部署（完全分布式）](http://blog.csdn.net/zwx19921215/article/details/41820199)
- [hadoop2.6完全分布式安装HBase1.1](https://yq.aliyun.com/articles/32314)
- [HBase介绍、搭建、环境、安装部署](http://www.cnblogs.com/oraclestudy/articles/5665780.html)
- [手把手教你安装Hbase,一次成功！](http://blog.csdn.net/achuo/article/details/51170946)
- [hbase安装配置（整合到hadoop）](http://blog.csdn.net/hguisu/article/details/7244413)
- [手把手教你配置Hbase完全分布式环境](https://my.oschina.net/lanzp/blog/348116)
- [Hadoop安装教程_单机/伪分布式配置_Hadoop2.6.0/Ubuntu14.04](http://www.powerxing.com/install-hadoop/)
- [HBase的特征和优点](http://www.thebigdata.cn/HBase/13396.html)
- [HBase在腾讯大数据的应用实践](http://www.thebigdata.cn/HBase/14270.html)
- [HBase与Zookeeper数据结构查询](http://www.thebigdata.cn/HBase/13255.html)
- [HBase相关文档](http://www.thebigdata.cn/HBase/defaultp5.html)
- [HBase最佳实践-列族设计优化](http://www.thebigdata.cn/HBase/30518.html)
- [那么问题来了：我们为什么要选择 Hbase？](http://www.thebigdata.cn/HBase/30332.html)
- [从零自学Hadoop(21)：HBase数据模型相关操作下](http://www.thebigdata.cn/HBase/30332.html)
- [HBase最佳实践 – 集群规划](http://www.thebigdata.cn/HBase/32604.html)
- [Apache HBase 入门](http://www.thebigdata.cn/HBase/32562.html)
- [HBase在腾讯大数据的应用实践](http://developer.51cto.com/art/201506/479413.htm)
- [Spark,Hive,HBase相互结合--数据读取和计算的几种方式](http://www.th7.cn/db/mssql/201609/205978.shtml)
- [使用spark进行hbase数据分析](http://blog.sina.com.cn/s/blog_a07df5fd0102w043.html)
- [Spark操作Hbase](http://blog.csdn.net/yhb315279058/article/details/50466103)
- [HBase 高性能加入数据 - 按批多“粮仓”式解决办法](http://www.cnblogs.com/wgp13x/p/4319466.html)
- [HBase数据模型解析和基本的表设计分析](http://blog.csdn.net/ymh198816/article/details/51244911)
- [Spark与HBase的整合](http://www.tuicool.com/articles/jY3iIrN)

- []()
- []()
- []()


### Hadoop相关的命令

````
- 重新格式化 如果报配置的 文件目录找不到的话 需要重新格式化一下
bin/hadoop namenode   –format
- 启动集群
bin/start-all.sh
- 这个应该类似于查看系统状态的
bin/hadoop  dfsadmin  –report
- 离开安全模式
hadoop dfsadmin -safemode leave
````

启动的时候会有短暂的安全模式 等一下让他过去就好



### zookeeper相关

- [[zookeeper系列之通信模型](http://www.cnblogs.com/ggjucheng/p/3376568.html)](http://www.cnblogs.com/ggjucheng/p/3376568.html)
- [分布式服务框架 Zookeeper -- 管理分布式环境中的数据](https://www.ibm.com/developerworks/cn/opensource/os-cn-zookeeper/)
- [zookeeper原理](http://cailin.iteye.com/blog/2014486)
- []()
- []()
- []()
- []()
- []()
- []()



### Hbase相关

- [深入HBase架构解析（一）](http://www.blogjava.net/DLevin/archive/2015/08/22/426877.html)
- [HBase 默认配置](http://eclecl1314-163-com.iteye.com/blog/1474286)

### 异常处理

[hbase遇到问题及解决方法](http://blog.csdn.net/wuwenxiang91322/article/details/45843307)

[hadoop异常大全](http://blog.csdn.net/zgc625238677/article/details/17241467)

###### org.apache.hadoop.hbase.MasterNotRunningException: Retried 7 times

这个异常一般是Hadoop没启动好查看Hadoop启动的模式和jar包是否一致等。注意看Hadoop的启动日志

启动正常的话  应该在每个节点上都启动



- [在hbase shell中解决ERROR: org.apache.hadoop.hbase.MasterNotRunningException: Retried 7 times](http://www.mincoder.com/article/2218.shtml)
- []()

###### ERROR: org.apache.hadoop.hbase.PleaseHoldException: Master is initializing

http://www.th7.cn/db/nosql/201611/212676.shtml

注意看hbase 的 master和子节点 的日志，一般来讲可能是启动的时候就已经异常了



######  WARN org.apache.hadoop.hbase.regionserver.HRegionServer: Unable to connect to master. Retrying. Error was: 

 WARN org.apache.hadoop.hbase.regionserver.HRegionServer: Unable to connect to master. Retrying. Error was: 
java.net.SocketException: 无效的参数 

注意hosts的配置 可能有错误的  如出现了 127.0.1.1 网上说是最好把127 的都去掉

http://www.cnblogs.com/zhanggl/p/3985114.html

http://www.linuxidc.com/Linux/2012-03/56343.htm

###### File /user/ha/firstTest could only be replicated to 0 nodes, instead of 1

http://f.dataguru.cn/thread-17327-1-1.html

 [hadoop伪分布式下 无法启动datanode的原因及could only be replicated to > 0 nodes, instead of 1的错误](http://blog.csdn.net/hackerwin7/article/details/19973045)



- [hadoop报错：could only be replicated to 0 nodes, instead of 1](http://blog.csdn.net/yangkai_hudong/article/details/18792267)
- []()
- []()
- []()
- []()
- []()
- ​
