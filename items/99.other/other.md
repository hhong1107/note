

### java相关

#### java编译不通过：

```
Information:Using javac 1.7.0_75 to compile java sources  
Information:java: javacTask: 源发行版 1.7 需要目标发行版 1.7  
Information:java: Errors occurred while compiling module 'qqqq'  
Information:15/3/26 13:22 - Compilation completed with 1 error and 0 warnings in 5s 771ms  
Error:java: Compilation failed: internal java compiler error  
```
在idea中设置  setting->Compiler->Java Compiler 设置相应Module的byte code version的合适版本就行了。
```xml
<profiles>  
   <profile>  
      <id>jdk-1.7</id>  
      <activation>  
         <activeByDefault>true</activeByDefault>  
         <jdk>1.7</jdk>  
      </activation>  
      <properties>  
         <maven.compiler.source>1.7</maven.compiler.source>  
         <maven.compiler.target>1.7</maven.compiler.target>  
         <maven.compiler.compilerVersion>1.7</maven.compiler.compilerVersion>  
      </properties>  
   </profile>  
</profiles>  
```
- [参考网站 IntelliJ Idea编译报错，解决方法](http://blog.csdn.net/zhihui1017/article/details/50555304)
- [ [转]Redis、Memcached、Guava、Ehcache中的算法](http://blog.csdn.net/heiyeshuwu/article/details/44904381)这篇文章还是比较有深度的



#### 工具类

- [Typora For Markdown 语法](http://www.jianshu.com/p/092de536d948)




#### git

删除add:git rm -r --cached .

[git中忽略掉已经add过的文件](https://segmentfault.com/q/1010000004398517)





#### 异常

- org.apache.ibatis.binding.BindingException: Invalid bound statement (not found):

- 引起该异常应该是没有对应的xml文件扫面到

- debug 进

  ````
  org.apache.ibatis.binding.MapperMethod#MapperMethod
  org.apache.ibatis.binding.MapperMethod.SqlCommand#SqlCommand
  configuration.hasStatement(statementName) // 这个地方是找不到对应的xml配置的 后面就报错了
  //这次的原因还是因为在pom中配置了别的系统的 repository包导致了先扫了别的系统的mapper 文件夹没有扫到自己系统的repository
  ````

  http://ljhzzyx.blog.163.com/blog/static/38380312201412453629988/



#### mybatis

[spring+mybatis 物理分页](http://blog.csdn.net/flamingsky007/article/details/7195399)

[Mybatis使用篇之十二：实现物理分页](http://chenjc-it.iteye.com/blog/1402965)



#### spring cloud

[Spring Cloud 异常处理](http://www.cnblogs.com/yish/p/5850813.html)



#### 其他

[为什么说传统分布式事务不再适用于微服务架构？](http://mp.weixin.qq.com/s/wPeDzVk7UKMFXNWyzUyugg)

[Intellij IDEA 一些不为人知的技巧](Intellij IDEA 一些不为人知的技巧)

[IDEA 使用中的一些方法](http://blog.csdn.net/rznice/article/details/49964373)

[git add时候报错:LF will be replaced by CRLF](http://blog.csdn.net/loovejava/article/details/22114477)

[SIGIR 2016信息检索精选论文](http://geek.csdn.net/news/detail/133916)
[Linux用数字设置权限](http://blog.csdn.net/u013063153/article/details/53113979)
[技术博客](https://my.oschina.net/itblog/home)

[RandomAccessFile 的默认编码为ISO-8859-1](http://v.youku.com/v_show/id_XMjY3NzU2MTA2MA==.html?spm=a2h0j.8191423.item_XMjY3NzU2MTA2MA==.A)

[linux tomcat日志错误Cannot run without an instance id & java.net.UnknownHostException](http://blog.csdn.net/zero_295813128/article/details/52813146)

[linux的hostname修改详解](http://soft.chinabyte.com/os/281/11563281.shtml)

[]()

[]()

[]()

[]()

[]()



###  备读

http://blog.csdn.net/jarth







