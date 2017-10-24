### JPA

- Repository ： 最顶层的接口，是一个空接口，目的是为了统一所有的 Repository 的类型，且能让组件扫描的时候自动识别。
- CrudRepository： Repository 的子接口，提供CRUD的功能
- PageingAndSortingRepository ： CrudRepository 的子接口，添加分页排序的功能
- JpaRepository ： PageingAndSortingRepository 的子接口，增加批量操作等功能
- JpaSpecificationExecutor ： 用来做复杂查询的接口


### 步骤

激活repository
```

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

@Import(FinCarAccountRepositoryConf.class)
public @interface EnableFinCarAccountRepository {
}
```
repository配置
```
@Configuration
@EnableJpaRepositories(basePackages = "com.fincar.account.repository.api")
@EntityScan(basePackages = "com.fincar.account.repository.entity")
//@ComponentScan("com.fincar.account.repository.api")
public class FinCarAccountRepositoryConf {
}

```
entity配置
```
@Entity
@Table(name = "customer_info")
public class CustomerInfo {

    @Id
    private String customerId;

    @Column(name = "customer_name")
    private String customerName;

```
连接池的配置
```
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
    <!--property name="driverClassName" value="${db.driverClass}"/-->
    <property name="url" value="${db.jdbcUrl}" />
    <property name="username" value="${db.user}" />
    <property name="password" value="${db.password}" />

    <!-- 配置初始化大小、最小、最大 -->
    <property name="initialSize" value="${db.initialSize}" />
    <property name="minIdle" value="${db.minIdle}" />
    <property name="maxActive" value="${db.maxActive}" />
    <!-- 配置获取连接等待超时的时间 -->
    <property name="maxWait" value="${db.maxWait}" />
    <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
    <property name="timeBetweenEvictionRunsMillis" value="${db.timeBetweenEvictionRunsMillis}" />
    <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
    <property name="minEvictableIdleTimeMillis" value="${db.minEvictableIdleTimeMillis}" />

    <property name="validationQuery" value="SELECT 'x' from dual" />
    <property name="testWhileIdle" value="true" />
    <property name="testOnBorrow" value="false" />
    <property name="testOnReturn" value="false" />
    <!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
    <property name="poolPreparedStatements" value="${db.poolPreparedStatements}" />
    <property name="maxPoolPreparedStatementPerConnectionSize" value="${db.maxPoolPreparedStatementPerConnectionSize}" />
</bean>

```


### 问题
- Not an managed type
  加了 @EntityScan("my.package.base.\*") 后解决
  [参考网站](http://stackoverflow.com/questions/28664064/spring-boot-not-an-managed-type)
- [Spring集成JPA后，报“Not an managed type: class x.x.x"](http://my.oschina.net/buwei/blog/486513) 通过注解 @EnableJpaRepositories 也可以解决

- [spring-data-jpa中findOne与getOne的区别](http://my.oschina.net/since1986/blog/336750)get的时候如果是没查到不会返回null
- javax.persistence.EntityNotFoundException 加上 @EntityScan(basePackages = "com.fincar.account.repository.entity")


### 参考网站
- [程序猿DD](http://blog.didispace.com/springbootdata2/)
- [Spring Data JPA @EnableJpaRepositories配置详解](http://www.linuxidc.com/Linux/2015-08/121198.htm)
- [Spring Data JPA 入门](http://blog.csdn.net/chenlong220192/article/details/46708689)
- [Spring Data JPA 入门（二）](http://wheniworking.com/2016/03/26/%60Spring%20Data%20JPA%60%20%E5%85%A5%E9%97%A8/)
- [Spring Data 中文版本](https://czeng.gitbooks.io/spring-data/content/xml_configuration.html)
- [第一章：Spring Data JPA入门](http://sishuok.com/forum/blogPost/list/7000.html)
- [Spring Boot下配置MyBatis多数据源](https://yq.aliyun.com/articles/39195)
- []()
- []()
- []()
- 连接池
- [阿里巴巴开源项目 Druid 负责人温少访谈  ](http://www.iteye.com/magazines/90)
- [应用Druid监控SQL语句的执行情况](http://blog.csdn.net/wind520/article/details/9202555)
- [Spring Data Jpa 详解 （配置篇）](http://www.cnblogs.com/liuyitian/p/4062748.html)
- []()
- []()


----
#### spring-boot-mybatis

- [Spring Boot MyBatis 连接数据库](http://blog.csdn.net/catoop/article/details/50553714)
- [Java Persistence with MyBatis 3(中文版) 第四章 使用注解配置SQL映射器](http://blog.csdn.net/luanlouis/article/details/35780175)
- [MyBatis教程](http://blog.csdn.net/u010349169/article/category/2363143)
- [Spring Boot MyBatis 通用Mapper插件集成](https://yq.aliyun.com/articles/5831)
- []()
- []()
- []()
- []()
- []()
- []()
- []()
- []()
