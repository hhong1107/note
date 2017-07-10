#### 参考网站

- [mysql中复制表数据（select into from和insert into select）](https://my.oschina.net/xsh1208/blog/182164)
- [MySQL中INSERT INTO SELECT的使用](http://www.cnblogs.com/RoadGY/archive/2011/07/22/2114088.html)
- [MySQL中in和=的区别](http://blog.csdn.net/budapest/article/details/51944757)


- [myBatis连接MySQL报错误：No operations allowed after conn](https://my.oschina.net/baishi/blog/203410) 出现这种问题 非常危险，同时有可能错误日志把硬盘塞满
- [Druid连接池基本配置](http://www.jianshu.com/p/4cb04939e370)  有密码加密的
- [Spring Boot 属性配置和使用 ](http://blog.csdn.net/isea533/article/details/50281151)
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

