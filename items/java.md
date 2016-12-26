
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





#### 其他

- [ 史上最全的java随机数生成算法](http://blog.csdn.net/yaerfeng/article/details/18362623)
- [Java获取随机数的3种方法