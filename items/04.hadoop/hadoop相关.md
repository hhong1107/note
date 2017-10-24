#### 参考网站

- [Hive集成HBase详解](http://www.cnblogs.com/MOBIN/p/5704001.html)
- [《Hadoop基础教程》之初识Hadoop](http://blessht.iteye.com/blog/2095675)
- [java 获取 hbase数据 springdatahadoop -- hbasetemplate](http://blog.csdn.net/linlinv3/article/details/42737113)
- [Hadoop核心架构HDFS+MapReduce+Hbase+Hive内部机理详解](http://www.csdn.net/article/2014-02-17/2818431-HDFS+MapReduce+Hbase)
- [Hadoop生态上几个技术的关系与区别：hive、pig、hbase 关系与区别](http://www.cnblogs.com/chamie/p/4737423.html)
- [Hadoop Hive与Hbase关系 整合](http://blog.csdn.net/liuzhenwen/article/details/28078625)
- [spring hadoop 访问hbase入门](http://codecloud.net/68707.html)
- [Hadoop2.7.1+Hbase1.2.1集群环境搭建(9)spring-hadoop实战](http://aperise.iteye.com/blog/2254491)
- [java 获取 hbase数据 springdatahadoop -- hbasetemplate](http://blog.csdn.net/linlinv3/article/details/42737113)
- [Hbase系统架构及数据结构](http://blog.csdn.net/cnbird2008/article/details/9151585)
- [标准知识图谱](http://lib.csdn.net/base/hbase)
- [HBase数据模型解析和基本的表设计分析](http://lib.csdn.net/article/hbase/45098?knId=1662)
- [HBase (2)---数据存储结构](http://blog.csdn.net/heyutao007/article/details/5766945)
- [springmvc 引入hbase](http://blog.csdn.net/hjxgood/article/details/46912793)
- [Spark技术在京东智能供应链预测的应用](http://mp.weixin.qq.com/s?__biz=MjM5MDE0Mjc4MA==&mid=2650995653&idx=1&sn=f376f83a79a225ec76ebbfd1e748c63e&chksm=bdbf03968ac88a80d581475f7b5488888264f33931d344496489125dccf59e6768411c5f337e&scene=0#rd)
- [Hive和HBase整合](https://www.iteblog.com/archives/1718.html)
- [Hive和HBase整合](http://dxer.github.io/2016/10/18/hive&hbase/)
- [HDFS写文件过程分析](http://shiyanjun.cn/archives/942.html)
- [Hadoop学习笔记—4.初识MapReduce](http://www.cnblogs.com/edisonchou/p/4287784.html)
- [淘宝之HBase MapReduce实例分析](http://www.aboutyun.com/thread-7072-1-1.html)
- [Hive整合HBase，操作HBase表](http://www.cnblogs.com/1130136248wlxk/articles/5517726.html)
- [hive为什么与hbase整合](http://www.aboutyun.com/thread-7317-1-1.html)
- [支付宝之所以牛逼：来看内部架构剖析](http://www.wtoutiao.com/p/J1cLpx.html)
- [基于Hadoop生态圈的数据仓库实践](http://lib.csdn.net/article/20/32639?knId=561)
- [基于Hadoop的数据仓库Hive 基础知识](http://blog.csdn.net/namelessml/article/details/52608881)
- [Hadoop Hive与Hbase关系 整合](http://blog.csdn.net/liuzhenwen/article/details/28078625)
- [浅析hadoop写入数据api](http://blog.csdn.net/qiuchenl/article/details/8617990)
- [Hadoop第4周练习—HDFS读写文件操作](http://www.cnblogs.com/shishanyuan/p/4172806.html)
- [全栈工程师-Hadoop, HBase, Hive, Spark](http://www.cnblogs.com/charlesblc/p/6014158.html)
- [adoop常见错误及处理方法](http://blog.csdn.net/yonghutwo/article/details/9206059)
- -[HBase Master高可用（HA）](http://www.cnblogs.com/captainlucky/p/4710642.html)
- [为Hbase建立高可用性多主节点](http://www.importnew.com/3020.html)
- [Hadoop 2.0 HA高可用集群配置详解](http://blog.csdn.net/carl810224/article/details/52160418)
- [hadoop命令 -- job相关](http://blog.csdn.net/lxpbs8851/article/details/12969105)
- -[【hadoop】 running beyond virtual memory错误原因及解决办法](http://blog.csdn.net/AHAU10/article/details/53484770)
- -[hadoop HDFS常用文件操作命令](https://segmentfault.com/a/1190000002672666) 很多文件相关的命令
- [Hadoop/Yarn/MapReduce内存分配（配置）方案](http://blog.csdn.net/bluishglc/article/details/42436321)  参考这个配置
- [Hadoop教程](http://www.yiibai.com/hadoop/hadoop_enviornment_setup.html#article-start)
- []()
- []()
- []()
- []()
- []()
- []()
- []()
- []()
- []()

#### 其他



````
参考连接http://blog.csdn.net/u011763190/article/details/50828410 
解决办法： 
生成秘钥：如果本地环境有则不需要 
ssh-keygen -t rsa -P “” 
实现本地登录免密码登录，因为搭建的时候，我们做了对其他主机的免密码登录，但是本地ssh连接本地没有 
所以，讲本地的公钥导入私钥就可以 
cat /root/.ssh/id_rsa.pub >> /root/.ssh/authorized_keys
````

