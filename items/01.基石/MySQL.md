#### 参考网站

- [mysql中复制表数据（select into from和insert into select）](https://my.oschina.net/xsh1208/blog/182164)
- [MySQL中INSERT INTO SELECT的使用](http://www.cnblogs.com/RoadGY/archive/2011/07/22/2114088.html)
- [MySQL中in和=的区别](http://blog.csdn.net/budapest/article/details/51944757)


- [myBatis连接MySQL报错误：No operations allowed after conn](https://my.oschina.net/baishi/blog/203410) 出现这种问题 非常危险，同时有可能错误日志把硬盘塞满

- [Druid连接池基本配置](http://www.jianshu.com/p/4cb04939e370)  有密码加密的

- [Spring Boot 属性配置和使用 ](http://blog.csdn.net/isea533/article/details/50281151)

- [MYSQL如何设置大小写敏感](https://zhidao.baidu.com/question/2267340607864742028.html)

- [mysql 如何kill session](http://blog.csdn.net/stevendbaguo/article/details/48159167)

- [mysql使用kill命令解决死锁问题,杀死某条正在执行的sql语句](http://blog.csdn.net/buster2014/article/details/51035768)

- -[MySql DAL中间件总结](http://www.fblinux.com/?p=1060)

- -[MHA高可用](http://www.fblinux.com/?p=1018)

- [数据可视化之Grafana-Table Panel](http://blog.csdn.net/neven7/article/details/50980726)

- -[mysql远程表链接](http://www.cnblogs.com/findumars/p/6272233.html)

- [MySql下视图的创建](http://blog.csdn.net/kingkuang2006/article/details/6981484)

- [mysql view(视图)从0学起，以及实例](http://blog.51yip.com/mysql/1062.html)

- -[关于MySql链接url参数的设置](http://www.cnblogs.com/softidea/p/5765624.html)

- ​[docker - mysql - utf8 中文编码问题](http://blog.csdn.net/m0_37639542/article/details/72852875)

- ​

  ````
  1、linux下mysql安装完后是默认：区分表名的大小写，不区分列名的大小写； 
  2、用root帐号登录后，在/etc/my.cnf 中的[mysqld]后添加添加lower_case_table_names=1，重启MYSQL服务，这时已设置成功：不区分表名的大小写； 
  lower_case_table_names参数详解： 
  lower_case_table_names = 0 
  其中 0：区分大小写，1：不区分大小写 
  MySQL在Linux下数据库名、表名、列名、别名大小写规则是这样的： 
  　　 1、数据库名与表名是严格区分大小写的； 
  　　 2、表的别名是严格区分大小写的； 
  　　 3、列名与列的别名在所有的情况下均是忽略大小写的； 
  　　 4、变量名也是严格区分大小写的； 
  MySQL在Windows下都不区分大小写。 
  3、如果想在查询时区分字段值的大小写，则：字段值需要设置BINARY属性，设置的方法有多种： 
  A、创建时设置： 
  CREATE TABLE T( 
  A VARCHAR(10) BINARY 
  ); 
  B、使用alter修改： 
  ALTER TABLE `tablename` MODIFY COLUMN `cloname` VARCHAR(45) BINARY; 
  C、mysql table editor中直接勾选BINARY项。
  ````

  ​

  ​	

  #### 锁问题

  ````sql
  show status like '%lock%';
  show global variables like '%time%' ;

    show engine innodb status;

    -- 查看线程数据

    show processlist;

    -- 查看是否有锁

    select * from information_schema.innodb_trx;
  	kill 1175;
  ````


  


  ````

#### Druid连接池配置
  ````
<!-- 数据库基本信息配置 -->
		<property name="driverClassName" value="${oracle.driver}" />
		<property name="url" value="${oracle.url}" />
		<property name="username" value="${oracle.username}" />
		<property name="password" value="${oracle.password}" />		
		<!-- 初始化连接数量 -->
		<property name="initialSize" value="${druid.initialSize}" />
		<!-- 最大并发连接数 -->
		<property name="maxActive" value="${druid.maxActive}" />
		<!-- 最大空闲连接数 -->
		<property name="maxIdle" value="${druid.maxIdle}" />
		<!-- 最小空闲连接数 -->
		<property name="minIdle" value="${druid.minIdle}" />
		<!-- 配置获取连接等待超时的时间 -->		
		<property name="maxWait" value="${druid.maxWait}" />
		<!-- 超过时间限制是否回收 -->
		<property name="removeAbandoned" value="${druid.removeAbandoned}" />
		<!-- 超过时间限制多长； -->
		<property name="removeAbandonedTimeout" value="${druid.removeAbandonedTimeout}" />
		<!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
		<property name="timeBetweenEvictionRunsMillis" value="${druid.timeBetweenEvictionRunsMillis}" />
		<!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
		<property name="minEvictableIdleTimeMillis" value="${druid.minEvictableIdleTimeMillis}" />
		<!-- 用来检测连接是否有效的sql，要求是一个查询语句-->	
		<property name="validationQuery" value="${druid.validationQuery}" />
		<!-- 申请连接的时候检测 -->
		<property name="testWhileIdle" value="${druid.testWhileIdle}" />
		<!-- 申请连接时执行validationQuery检测连接是否有效，配置为true会降低性能 -->
		<property name="testOnBorrow" value="${druid.testOnBorrow}" />
		<!-- 归还连接时执行validationQuery检测连接是否有效，配置为true会降低性能  -->
		<property name="testOnReturn" value="${druid.testOnReturn}" />
		<!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
		<property name="poolPreparedStatements" value="${druid.poolPreparedStatements}" />		
		<property name="maxPoolPreparedStatementPerConnectionSize" value="${druid.maxPoolPreparedStatementPerConnectionSize}" />
		<!--属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有：  				
				监控统计用的filter:stat
				日志用的filter:log4j
 				防御SQL注入的filter:wall -->
		<property name="filters" value="${druid.filters}" />	
````



- 密码加密

  ````shell
  java –cp druid-1.0.18.jar com.alibaba.druid.filter.config.ConfigTools 你的密码
````

  ​



#### 数据库

````
mysql> show global variables like '%time%' ;
SET GLOBAL wait_timeout = 288000;
````

