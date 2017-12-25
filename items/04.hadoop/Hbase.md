





## Hbase集群搭建

- [官方文档](http://hadoop.apache.org/)
- [官网](http://hbase.apache.org/)
- [中文文档](http://abloz.com/hbase/book.html)

### 参考网站

#### 安装

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




#### 攻略

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
- [随笔分类 - HBase](http://www.cnblogs.com/MOBIN/category/761581.html) 这里有关于 hvie和hbase整合的以及 SHDP
- [java 获取 hbase数据 springdatahadoop -- hbasetemplate](http://blog.csdn.net/linlinv3/article/details/42737113)
- [HBase客户端API基本操作](http://www.thebigdata.cn/HBase/14513.html)
- [SpringBoot --集成HBASE/基于SpringDataHadoop](http://www.jianshu.com/p/8c2b47cc0c9f)
- [**spring-hadoop-samples**](https://github.com/spring-projects/spring-hadoop-samples/blob/master/hbase/src/main/java/org/springframework/samples/hadoop/hbase/UserRepository.java)
- [Spring for Apache Hadoop - Reference Documentation](http://docs.spring.io/spring-hadoop/docs/2.5.0.M1/reference/html/)
- [官方的hadoop+hbase各版本支持](http://hbase.apache.org/book.html#arch.overview)
- -[HBase -ROOT-和.META.表结构(region定位原理)](http://blog.csdn.net/chlaws/article/details/16918913)
- -[深入HBase架构解析（一）](http://www.blogjava.net/DLevin/archive/2015/08/22/426877.html)
- [HBase高性能复杂条件查询引擎](http://blog.csdn.net/bluishglc/article/details/31799255)
- [hbase高性能读取数据](http://blog.csdn.net/zbc1090549839/article/details/50487336)
- [Hbase 统计表行数的3种方式总结](http://blog.csdn.net/u013709332/article/details/52296748)


-[hbase操作（shell 命令，如建表，清空表，增删改查）以及 hbase表存储结构和原理](http://blog.csdn.net/longshenlmj/article/details/48317567)

[Hbase教程](http://www.yiibai.com/hbase/hbase_delete_data.html)



#### 数据迁移相关

- [hadoop和hbase节点添加和单独重启](http://blog.csdn.net/xiaolang85/article/details/7987990)

- [数据导入HBase最常用的三种方式及实践分析](http://www.csdn.net/article/2014-01-07/2818046)

- [HBase数据迁移（3）-自己编写MapReduce Job导入数据](http://www.importnew.com/3912.html)

  [hbase备份以及导出问题](http://www.aboutyun.com/thread-12742-1-1.html)


#### 异常处理

- [Hbase 建表基本命令总结](http://blog.csdn.net/kky2010_110/article/details/12616137)
- -[hbase总结：hbase client访问的超时时间、重试次数、重试间隔时间的配置](http://blog.csdn.net/jamin_tan007/article/details/50055549)
- [HBase数据导入的几种操作](http://blog.csdn.net/scgaliguodong123_/article/details/46771929)
- [HBase 0.96.0 的数据导入: 利用ImportTsv，completebulkload，Import](http://blog.csdn.net/samhacker/article/details/21282243)
- [HBase scan shell操作详解](http://blog.csdn.net/vaq37942/article/details/54949428)


-[Hadoop,HBase添加和删除节点](http://blog.csdn.net/long1657/article/details/39526025)

- []()
- []()
- []()
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
- -[ZooKeeper系列3：ZooKeeper命令、命令行工具及简单操作](http://www.cnblogs.com/likehua/p/3999588.html)
- [分布式服务框架 Zookeeper -- 管理分布式环境中的数据](https://www.ibm.com/developerworks/cn/opensource/os-cn-zookeeper/)
- [Zookeeper 的学习与运用](http://www.oschina.net/question/928033_84720)
- -[zookeeper 入门讲解实例 转](http://blackproof.iteye.com/blog/2039040)
- -[Zookeeper系列（一）](http://blog.csdn.net/tswisdom/article/details/41522069) 这个是一系列的
- -[zookeeper原理（转）](http://cailin.iteye.com/blog/2014486)
- -[zookeeper编程（二）](http://www.cnblogs.com/zhangchaoyang/articles/3813217.html)
- []()
- []()



### Hbase相关

- [深入HBase架构解析（一）](http://www.blogjava.net/DLevin/archive/2015/08/22/426877.html)
- [HBase 默认配置](http://eclecl1314-163-com.iteye.com/blog/1474286)
- [hbase教程](http://www.yiibai.com/hbase/hbase_describe_and_alter.html)
- ​[Hbase 数据导出到文件中](http://blog.csdn.net/maixia24/article/details/38414565) 直接用命令导出的

### 异常处理



-[hbase创建表提示表已经存在而list显示无该表的处理](http://www.cnblogs.com/wxflovedxd/p/3668150.html)

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



###### 服务器时间问题

如果机器之间时间相差太大会不能启动

Server datanode2,60020,1493035907006 has been rejected; Reported time is too far out of sync with master.  Time difference of 33646ms > max allowed of 30000ms

````shell
sudo yum install ntpdate
sudo apt-get install ntpdate
sudo ntpdate -u ntp.api.bz

````

https://my.oschina.net/myaniu/blog/182959

http://blog.csdn.net/bbirdsky/article/details/20445385

http://www.jb51.net/LINUXjishu/73979.html

[java.net.UnknownHostException](http://blog.csdn.net/xtqve/article/details/9672617) 这里有hostname相关的

````shell
hostname newname
vim /etc/hostname
````





- [hadoop报错：could only be replicated to 0 nodes, instead of 1](http://blog.csdn.net/yangkai_hudong/article/details/18792267)

- [启动hbase输出ignoring option PermSize=128m; support was removed in 8.0告警信息](http://blog.csdn.net/kamereon/article/details/54582976)

  ````
  解决办法：
  由于JDK使用的是jdk1.8.0_65

  注释掉以下：

  # Configure PermSize. Only needed in JDK7. You can safely remove it for JDK8+
  export HBASE_MASTER_OPTS="$HBASE_MASTER_OPTS -XX:PermSize=128m -XX:MaxPermSize=128m"
  export HBASE_REGIONSERVER_OPTS="$HBASE_REGIONSERVER_OPTS -XX:PermSize=128m -XX:MaxPermSize=128m"
  ````

  ​

- Registration of NodeManager failed, Message from ResourceManager: NodeManager from  hadoop.slave1 doesn't satisfy minimum allocations, Sending SHUTDOWN signal to the NodeManager.

  内存不足的问题

  yarn-site.xml中的内存参数设置的问题，好像不能设置1G以下的 我设置了256MB遇到跟楼主一样的现象

  http://www.dataguru.cn/thread-460817-1-1.html



​	我们一直都是用Apache的原生发行版。Hadoop 2.7.2，HBase 1.2.2 ， Hive 2.1.0 ，Zookeeper 3.4.8 ，Sqoop 1.4.6 ， Spark 2.0.2  ，Kafka 2.11-0.10.0.0等等

- -[Hadoop版本选择探讨](http://dongxicheng.org/mapreduce-nextgen/how-to-select-hadoop-versions/)
- -[Hadoop2.7.1+Hbase1.2.1集群环境搭建(10)基于ZK的Hadoop HA集群安装](http://aperise.iteye.com/blog/2305809)
- []()
- ​

### 升级到hadoop2.7.1+hbase1.2.5

- 因为hbase-client 版本默认的是0.96以上的hbase需要再zookeeper中找到/hbase/meta-region-server

  节点。 而之前安装的0.94版本的hbase 在zookeeper中注册的是/hbase/root-region-server  且发现hbase0.94+hadoop-1.0.3 并没有通过测试 故做hadoop+hbase升级

http://stackoverflow.com/questions/19903622/hbase-hbase-meta-region-server-node-does-not-exist



- [CentOS7安装Hadoop2.7完整步骤](http://www.linuxidc.com/Linux/2015-11/124800.htm)
- [Hadoop2.7.1安装与配置](http://jingyan.baidu.com/article/f00622283a76c0fbd3f0c839.html)
- [轻松搭建hadoop-1.2.1集群(5)—配置HBase集群](http://blog.csdn.net/baolibin528/article/details/43919897)
- [Hadoop2.7.2+Hbase1.2.1分布式环境搭建整理](http://blog.csdn.net/sinat_30569973/article/details/52232850) 参考这个


- 管理端口变为16010：http://192.168.3.67:16010/master-status

  或者手动在 hbase-site.xml 中配置 

  ````
  <property>
          <name>hbase.master.info.port</name>
          <value>60010</value>
   </property>
  ````

  如果还是无法访问

  hadoop的safemode(安全模式)引起的 
  解决方案： 
  执行下述命令 
  hadoop dfsadmin -safemode leave 
  (注意将hadoop目录的bin子目录加入到PATH 可修改/etc/profile文件) 
  重启hbase(start-hbase.sh)

- Hadoop管理台页面：http://192.168.3.67:8088/cluster/nodes   

  http://192.168.3.67:50070/dfshealth.html#tab-startup-progress

- -[Apache Hadoop 2.2.0 HDFS HA + YARN多机部署](http://blog.csdn.net/u010967382/article/details/20380387)

- ​

-[HBase client访问ZooKeeper获取root-region-server DeadLock问题（zookeeper.ClientCnxn Unable to get data of znode /hbase/root-region-server）](http://www.cnblogs.com/shenguanpu/archive/2012/12/02/2798217.html)



### 数据导入

#### hadoop相关：



#### 异常处理

###### 内存大小受限

````
Invalid resource request, requested memory < 0, or requested memory > max configured, requestedMemory=1536, maxMemory=1024
需要将内存调大
找 
yarn.scheduler.maximum-allocation-mb

yarn.nodemanager.resource.memory-mb
所有节点都修改好后重启 yarm
- http://blog.sina.com.cn/s/blog_e699b42b0102xg2k.html
````

###### jobtracker任务和页面没有

- hadoop jobtracker 和 tasktracker 没有启动  Hadoop2.x不存在这个两个单独的线程 都是通过start-all.sh启动的 yarm管理？
- 如果要看的任务页面的话可以使用  mapred historyserver  然后访问http://192.168.3.67:19888/  停止使用 mr-jobhistory-daemon.sh stop historyserver
- http://bbs.csdn.net/topics/390907783
- http://www.aboutyun.com/thread-5738-1-1.html
- [yarn详解](http://www.aboutyun.com/thread-7678-1-1.html)
- [hadoop（2.x）以hadoop2.2为例完全分布式最新高可靠安装文档](http://www.aboutyun.com/thread-7684-1-1.html)
- [hadoop2.x—mapreduce实战和总结](http://blog.csdn.net/u012749168/article/details/52809278)
- [Ubuntu中关于hadoop环境变量的设置方法](http://blog.csdn.net/u010255818/article/details/51073273)



bin/hadoop fs -ls 提示ls: `.\': No such file or directory 解决方法

hadoop fs -ls / 



#### Hbase相关

- [从hdfs批量导数据到hbase](http://blog.csdn.net/pighead_chen/article/details/8677699)
- ​
- [ImportTsv－HBase数据导入工具](http://blog.csdn.net/opensure/article/details/47111705) 参考这个

###### 命令历史



````shell
# hfs创建文件
hadoop fs -mkdir /test_income
hadoop fs -ls /
hadoop fs -copyFromLocal localdb_qianyitoa_ddb_income.tsv /test_income/old_income.tsv

# 启动查看job的页面
screen -R jobv
mapred historyserver

# 导入数据：注意要有个字段是 HBASE_ROW_KEY的
hbase org.apache.hadoop.hbase.mapreduce.ImportTsv -Dimporttsv.columns=testfm:incomeAmount,testfm:terminalcurrentamount,testfm:incomedate,testfm:aaa,testfm:bbb,HBASE_ROW_KEY -Dimporttsv.bulk.output=/test_income/storefile-outputdir testt  /test_income/old_income.tsv

./hbase org.apache.hadoop.hbase.mapreduce.LoadIncrementalHFiles /test_income/storefile-outputdir testt
````



#### Hbase数据迁移

[Hbase集群间数据迁移方法总结（包括不通信集群）](http://blog.csdn.net/bigkeen/article/details/51034902) 部分参考这个  不过add_table.rb脚本那里不需要采用 直接执行下面的 hbase hbck .. 那个命令就行

[Hbase集群间数据迁移方法总结](http://blog.csdn.net/jingling_zy/article/details/7554676)

[源hbase集群中复制出HBase](http://blog.csdn.net/zreodown/article/details/7917532)

-[hbase meta表修复](http://blackproof.iteye.com/blog/2052898)

[解决方案：hbase数据迁移发生ERROR: Unknown table错误](http://www.voidcn.com/article/p-tdnmjldo-baa.html) 这篇文章非常有参考价值  并且提到了 使用 get put 直接导出导入

- 本次实行的是离线迁移

````shell

# hadoop导出到本地的文件
hadoop fs -copyToLocal /hbase/data/default/account ./hbase-backup/account
# 将本地文件导入hadoop
hadoop fs -copyFromLocal  ./settle_current_income    /hbase/data/default/settle_current_income

# 先修复.META.表：
hbase hbck -fixMeta
# 重新分区
hbase hbck -fixAssignments

http://www.voidcn.com/article/p-tdnmjldo-baa.html
````



另外还有一种导出导入方法：

````shell
hadoop dfs -get /hbase/test ./
hadoop dfs -put test /hbase/test
````



[HDFS和HBASE动态增加和减少节点](http://blog.csdn.net/clark_xu/article/details/69666612)

[]





```

```



