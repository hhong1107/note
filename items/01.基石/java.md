
##### java读取properties
- [java读取properties](http://zheng0324jian.iteye.com/blog/1176932)
```
static {   
        Properties prop = new Properties();   
        InputStream in = Object.class.getResourceAsStream("/test.properties");   
        try {   
            prop.load(in);   
            param1 = prop.getProperty("initYears1").trim();   
            param2 = prop.getProperty("initYears2").trim();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   

```
- [扫描Class文件的方法](http://m310851010.iteye.com/blog/2034279)
- [Java如何扫描指定package下所有的类](http://blog.csdn.net/neosmith/article/details/43955963)
- [JAVA中的反射机制](http://blog.csdn.net/liujiahan629629/article/details/18013523)
- [Java反射机制详解](http://www.cnblogs.com/lzq198754/p/5780331.html)
- [java获取当前类的绝对路径](http://blog.csdn.net/dagouaofei/article/details/5588008)
- 这些可参考 com.ddsc.pay.thirdparty.hailer.tool.ServiceFactory
- [Java多线程之Lock的使用](http://blog.csdn.net/huang_xw/article/details/7090177)




#### java调用js

- [在Java中直接调用js代码](http://blog.csdn.net/xzyxuanyuan/article/details/8062887)
- -[JS函数调用的四种方法](http://www.cnblogs.com/leejersey/p/3663278.html)
- [JS生成随机字符串的多种方法](http://www.jb51.net/article/50910.htm)
- -[JS产生随机数的几个用法！](http://www.cnblogs.com/banbu/archive/2012/07/25/2607880.html)
- -[JS中的JSON对象 定义和取值](http://www.cnblogs.com/yangdm/p/5081080.html)
- -[JAVA中脚本语言的使用](http://blog.csdn.net/jasonware/article/details/51954727) 参考这个网站
- [JAVA运行脚本语言(Scripting)](http://blog.csdn.net/atco/article/details/51144835)






#### 其他

- [ 史上最全的java随机数生成算法](http://blog.csdn.net/yaerfeng/article/details/18362623)
- [JSch - Java实现的SFTP（文件上传详解篇）](http://www.cnblogs.com/longyg/archive/2012/06/25/2556576.html)
- [JSch - Java实现的SFTP（文件下载详解篇）](http://www.cnblogs.com/longyg/archive/2012/06/25/2561332.html)
- [Java内部类的使用小结](http://android.blog.51cto.com/268543/384844/)
- [bigdecimal 保留小数位](http://www.cnblogs.com/liqforstudy/p/5652517.html)
- [使用BigDecimal进行精确运算](http://www.cnblogs.com/chenssy/archive/2012/09/09/2677279.html)
- [Spring对注解(Annotation)处理源码分析2——解析和注入注解配置的资源](http://blog.csdn.net/chjttony/article/details/6301591)
- [Java NIO 应用 -- 使用内存映射文件实现进程间通信](https://unmi.cc/java-nio-memory-mapping-communicate/)
- [JVM源码分析之Attach机制实现完全解读](http://blog.csdn.net/huaweitman/article/details/50601602)
- [进程间通信和线程间通信](http://blog.csdn.net/stand1210/article/details/52485311)
- [Java进程间通信](http://www.cnblogs.com/flyingwind/archive/2012/10/24/2737204.html)
- [实现自己的类加载时，重写方法loadClass与findClass的区别](http://blog.csdn.net/fenglibing/article/details/17471659)
- [Java类加载机制——如何实现一个工程中不同模块加载不同版本的同名jar包。](http://blog.csdn.net/tiantiandjava/article/details/43733875)
- [Maven类包冲突终极解决小技若干](http://stamen.iteye.com/blog/2030552)
- [Java并发中常用同步工具类](https://my.oschina.net/itblog/blog/775918)
- [ Dom4j解析和生成XML文档](http://blog.csdn.net/chenghui0317/article/details/11486271)
- [使用Dom4j解析XML](http://blog.csdn.net/redarmy_chen/article/details/12969219)
- [Java解决UTF-8 BOM问题](http://blog.csdn.net/dream_it_life/article/details/6045140)
- [Java正确判别出文件的字符集（尤其是带BOM和不带BOM的UTF-8字符)](http://blog.csdn.net/oicqxiesidilieric/article/details/8464630)
- [优先使用TimeUnit类中的sleep](http://www.importnew.com/7219.html)
- -[JSON序列化和反序列化的时候日期处理](http://blog.csdn.net/u011113654/article/details/50470893)
- -[fackson /常用注解/ annotation](http://blog.csdn.net/u010457406/article/details/50921632)
- [解决hbase-client中guava包冲突问题](http://blog.csdn.net/ludonqin/article/details/52387769) 最后使用16.0 的版本 需要在每个项目中显式的添加一下
- [SpringBoot --集成HBASE/基于SpringDataHadoop](http://blog.csdn.net/cwenao/article/details/57980188)
- [hbaseclient官方api](http://hbase.apache.org/apidocs/org/apache/hadoop/hbase/client/Scan.html)
- [HBase的特征和优点](http://www.thebigdata.cn/HBase/13396.html)
- [HBase最佳实践-列族设计优化](http://www.thebigdata.cn/HBase/30518.html)
- [我们为什么要选择 Hbase](http://www.thebigdata.cn/HBase/30332.html)
- [HBase在腾讯大数据的应用实践](http://developer.51cto.com/art/201506/479413.htm)
- [HBase客户端API基本操作](http://www.thebigdata.cn/HBase/14513.html)
- -[HBase的基本操作](http://www.cnblogs.com/MOBIN/p/4647556.html)
- [HBase中Scan类属性maxResultSize的说明](https://my.oschina.net/psuyun/blog/375637)
- [HBase shell scan 模糊查询](http://www.th7.cn/db/nosql/201511/144465.shtml)
- [HBase 常用Shell命令](http://www.cnblogs.com/nexiyi/p/hbase_shell.html)
- [HBase基本数据操作详解](http://blog.csdn.net/wulantian/article/details/41011297)
- [java工具类 获取包下所有类](http://blog.csdn.net/jdzms23/article/details/17550119)
- -[java中的Maven项目的两种打包方法](http://blog.csdn.net/u010910436/article/details/48290323)
- [使用Cookie进行会话管理](http://blog.csdn.net/yerenyuan_pku/article/details/51945105)
- -[JAVA解析Excel文件的两种方式 --jxl技术](http://max1487.iteye.com/blog/2298291)
- [Java调用linux shell脚本的方法](http://www.jb51.net/article/61529.htm)
- [Java md5签名出现位数错误情况](http://blog.csdn.net/JJ_One/article/details/59483366)
- [使用itext直接替换PDF中的文本](http://blog.csdn.net/sishenkankan/article/details/53107195)
- [Java操作PDF之iText详细入门](http://blog.csdn.net/zmx729618/article/details/52150070)
- [JXL读取货币类型和科学计数法的处理](http://www.xuebuyuan.com/791820.html)
- [ArrayList.toArray(T[\] a) 的说明](http://blog.csdn.net/zhangyunfei_happy/article/details/51153754)
- -[JVM:查看java内存情况命令](http://www.cnblogs.com/zzck/p/5707168.html)
- [Java读取String分行字符串](http://blog.csdn.net/fjssharpsword/article/details/68066502)
- ​
- []()
- []()
- []()
- []()
- []()
- []()
- []()
- []()

#### 代码块

- [使用visualvm远程监控JVM LINUX服务器与客户端配置方法](http://blog.csdn.net/xianzhi/article/details/22298525)

  ````shell
  java -Dcom.sun.management.jmxremote.port=8099 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Djava.rmi.server.hostname=192.168.3.199 -jar ./ddsc-supervise-server-1.0.0-SNAPSHOT.jar
  ````

  ​

  ​

  ​

- [杂记--泛型与json解析（fastjson）](http://blog.csdn.net/u013583905/article/details/49281639)


````java
BaseBean<CategoryBean> cat=JSON.parseObject(str, new TypeReference<BaseBean<CategoryBean>>(){});	
List<CategoryBean> list= cat.getData();
````

