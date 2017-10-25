监控语句如下：

jstat -gcutil [进程号] 5000 --每5秒打印一次jvm各个内存区的状态

另外找了一个监控系统内存的语句：

vmstat | sed -n '/[0-9]/p'  





### 参考网站



-[Xms Xmx PermSize MaxPermSize 区别](http://www.cnblogs.com/mingforyou/archive/2012/03/03/2378143.html)