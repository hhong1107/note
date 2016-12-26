

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



