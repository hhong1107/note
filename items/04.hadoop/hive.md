http://www.aboutyun.com/thread-7870-1-1.html

觉得在问区别之前，我应该显示说相同点，这样一想，糊涂了，Hive和HBase哪里像？
好像哪里都不像，既然哪里都不像，又何来“区别是什么”这一问题，他两所有的都算区别

那么，Hive是什么?

  不严格一点来说,Hive可以认为是MR的一个包装。Hive的意义就是把写好的Hive的sql
转换为复杂的MR程序

于是HBase又是什么?

  同样,不严格一点来说，HBase可以认为是HDFS的一个包装。它的本质是数据存储
是个Nosql数据库；HBase部署于HDFS之上，并克服了HDFS在随机读写方面的缺点

所以要问Hive和HBase的区别，就应该问问MR和HDFS之间的区别，问区别
就要先说说他两哪里像？

于是，你又问MR和HDFS哪里像了?

http://fireinjava.iteye.com/blog/1779420
http://www.cnblogs.com/viviman/archive/2013/01/29/2881784.html


- [基于Hadoop的数据仓库Hive 基础知识]()
- [使用 Hive 构建数据仓库](http://www.ibm.com/developerworks/cn/data/library/bd-hivewarehouse/)
- [基于Hadoop的数据仓库Hive 学习指南](http://blog.csdn.net/achuo/article/details/51332214)
- [Hive定义、Hive与HBase关系、Hive与RDBMS的关系、数据库与数据仓库的区别](http://blog.csdn.net/u012110719/article/details/48690189)
- -[Hive性能优化](http://www.cnblogs.com/smartloli/p/4356660.html)
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




####  问题

- 报 hadoop执行时指向的是一个错误的jdk  在hadoop-env.sh 中加入JAVA_HOME 可以了



#### 初始化mysql表

````shel
./schematool -dbType mysql -initSchema
````






````
CREATE TABLE hbase_table_1(key int, value1 string, value2 int, value3 int) 
STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler'
WITH SERDEPROPERTIES (
"hbase.columns.mapping" = ":key,a:b,a:c,d:e"
);

CREATE EXTERNAL TABLE settle_current_income_test(key string, accountId string,incomeDate string,incomeAmount string) 
STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler'
WITH SERDEPROPERTIES ("hbase.columns.mapping" = "record:accountId,record:incomeDate,record:incomeAmount")
TBLPROPERTIES("hbase.table.name" = "settle_current_income", "hbase.mapred.output.outputtable" = "settle_current_income");



CREATE EXTERNAL TABLE trade_recharge(key string, accountId string,orderDate string,rechargeId string) 
STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler'
WITH SERDEPROPERTIES ("hbase.columns.mapping" = "recharge_info:accountId,recharge_info:orderDate,recharge_info:rechargeId")
TBLPROPERTIES("hbase.table.name" = "trade_recharge", "hbase.mapred.output.outputtable" = "trade_recharge");



CREATE TABLE current_income_test (

  d1 float,

  d2 float,

  income_date string,

  d3 string,

  d4 string,

  accountid string,

  key string)

PARTITIONED BY (

  stat_date string)

ROW FORMAT DELIMITED

  FIELDS TERMINATED BY '\t'

STORED AS INPUTFORMAT

  'org.apache.hadoop.mapred.TextInputFormat'

OUTPUTFORMAT

  'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat';


  LOAD DATA LOCAL INPATH '/home/hd01/tmp/qingxires_ddb_income_history.tsv' OVERWRITE INTO TABLE current_income_test PARTITION (stat_date='2014-12-05');
````



#### hiveserver2 内存不足问题



问题描述：hive内部命令可以，但是通过hue 调用的时候  hiveserver2就会报内存不足

解决：

- 注意日志打印 把  hive-log4j2.properties.template 拷贝成   hive-log4j2.properties。修改其中的 property.hive.log.dir 或 property.hive.log.level
- 把 hive-env.sh.template 拷贝成 hive-env.sh  修改如下配置

````shell
if [ "$SERVICE" = "cli" ]; then
   if [ -z "$DEBUG" ]; then
     export HADOOP_OPTS="$HADOOP_OPTS -XX:NewRatio=12 -Xms10m -XX:MaxHeapFreeRatio=40 -XX:MinHeapFreeRatio=15 -XX:+UseParNewGC -XX:-UseGCOverheadLimit -XX:PermSize=256M -XX:MaxPermSize=512M -Xmx2048m"
   else
     export HADOOP_OPTS="$HADOOP_OPTS -XX:NewRatio=12 -Xms10m -XX:MaxHeapFreeRatio=40 -XX:MinHeapFreeRatio=15 -XX:-UseGCOverheadLimit -XX:PermSize=256M -XX:MaxPermSize=512M -Xmx2048m"
   fi
 fi
 
# 因为if判断好像没进去 直接在下面写
export HADOOP_OPTS="$HADOOP_OPTS -XX:NewRatio=12 -Xms10m -XX:MaxHeapFreeRatio=40 -XX:MinHeapFreeRatio=15 -XX:-UseGCOverheadLimit -XX:PermSize=256M -XX:MaxPermSize=512M -Xmx2048m"
````

http://blog.csdn.net/levy_cui/article/details/53992402