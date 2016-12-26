- [Spring之——quartz集群的问题及解决方案(基于Spring4.0+quartz2.2.1的集群架构) _一九八网络科技V客学院-IT技术博客](http://blog.inet198.cn/?l1028386804/article/details/49150267)
- [Spring之——quartz集群(MySQL数据源) _一九八网络科技V客学院-IT技术博客](http://blog.inet198.cn/?l1028386804/article/details/49129603)
- [ Spring4+Quartz2集群动态创建任务](http://blog.csdn.net/zjx86320/article/details/52346187)  参考了这个
- [项目ITP(六) spring4.0 整合 Quartz 实现动态任务调度](http://www.cnblogs.com/Alandre/p/3735072.html)
- [spring4.1.6配置quartz2.2.1（maven）](https://my.oschina.net/ydsakyclguozi/blog/465179)
- [Quartz 2.x与Spring 动态整合](http://linhongyu.blog.51cto.com/6373370/1530148)
- [Quartz深入浅出(一)](http://blog.csdn.net/chenweitang123/article/details/37777399)
- [Spring 3整合Quartz 2实现定时任务二：动态添加任务](http://www.dexcoder.com/selfly/article/308)
- [Spring 3整合Quartz 2实现定时任务三：动态暂停 恢复 修改和删除任务](http://www.dexcoder.com/selfly/article/311)
- [零、Quartz是什么？能干什么？](http://www.cnblogs.com/pzy4447/p/5203308.html)
- [几种任务调度的 Java 实现方法与比较](https://www.ibm.com/developerworks/cn/java/j-lo-taskschedule/)
- [Spring定时任务的几种实现](http://gong1208.iteye.com/blog/1773177)
- [ 定时任务框架Quartz浅谈](http://blog.csdn.net/ang_dd/article/details/12032159)
- [Spring集成Quartz定时任务框架介绍和Cron表达式详解](http://www.cnblogs.com/obullxl/archive/2011/07/10/spring-quartz-cron-integration.html)
- []()
- []()
- []()
- []()
- []()
- []()
----
1）Cron表达式的格式：秒 分 时 日 月 周 年(可选)。

            字段名                 允许的值                        允许的特殊字符  

            秒                         0-59                               , - * /  

            分                         0-59                               , - * /  

            小时                   0-23                               , - * /  

            日                         1-31                               , - * ? / L W C  

            月                         1-12 or JAN-DEC          , - * /  

            周几                     1-7 or SUN-SAT            , - * ? / L C #  

            年 (可选字段)     empty, 1970-2099      , - * /

            “?”字符：表示不确定的值

            “,”字符：指定数个值

            “-”字符：指定一个值的范围

            “/”字符：指定一个值的增加幅度。n/m表示从n开始，每次增加m

            “L”字符：用在日表示一个月中的最后一天，用在周表示该月最后一个星期X

            “W”字符：指定离给定日期最近的工作日(周一到周五)

            “#”字符：表示该月第几个周X。6#3表示该月第3个周五

      2）Cron表达式范例：

              每隔5秒执行一次：*/5 * * * * ?

              每隔1分钟执行一次：0 */1 * * * ?

              每天23点执行一次：0 0 23 * * ?

              每天凌晨1点执行一次：0 0 1 * * ?

              每月1号凌晨1点执行一次：0 0 1 1 * ?

              每月最后一天23点执行一次：0 0 23 L * ?

              每周星期天凌晨1点实行一次：0 0 1 ? * L

              在26分、29分、33分执行一次：0 26,29,33 * * * ?

              每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?




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
