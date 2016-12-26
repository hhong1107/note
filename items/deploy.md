<!-- toc -->

- [python相关](#python相关)
- [其他](#其他)

<!-- tocstop -->

#### python相关
- 执行并返回执行结果和状态
- [参考网站](http://www.jb51.net/article/55327.htm)
```
(status, output) = commands.getstatusoutput('cat /proc/cpuinfo')
print status, output
```
- [创建文件夹/目录](http://jingyan.baidu.com/article/f3ad7d0ffe8b1409c2345b43.html)
- [删除文件夹以及里面的所有文件](http://zhidao.baidu.com/link?url=a3ChBpEvVQkgJsjgWAqBJWbTMzZbV1CTiB1m77VS6Q9tqlAwg_fCsPZh9-dVB4LKKGv_qkeJ12XN_xVM9wzd2GISMJJjbpFHxkDM5Shurkm)
shutil.rmtree(path)
- 判断文件夹是否存在:os.path.exists('d:/assist/getTeacherList.py') http://blog.sina.com.cn/s/blog_708be8850101bu02.html



#### 其他
- maven 安装跳过测试：mvn    package -Dmaven.test.skip=true
  - [参考网站](http://blog.csdn.net/redstarofsleep/article/details/46518585)
- mac 安装maven brew maven。 修改配置文件 /usr/local/Cellar/maven/3.3.9/libexec/conf
- [nohup命令](http://www.cnblogs.com/allenblogs/archive/2011/05/19/2051136.html)

- linux设置别名
[参考网站](linux中设置alias永久生效)
```
vi ~/.bashrc
加上 alias deploy='python ~/deploy_test.py'
source ~/.bashrc
```

- [grep 命令](http://www.jb51.net/article/31207.htm)
- [CentOS 6 安装MAVEN及系统配置](http://xugang-1017-126-com.iteye.com/blog/1634032)
- 安装git yum install git  https://git-scm.com/download/linux

- git设置全局变量
http://lansgg.blog.51cto.com/5675165/1556924
查看git配置 git config -l

- [Spring Boot 属性配置和使用](http://blog.csdn.net/isea533/article/details/50281151)
nohup java -jar xxx.jar --spring.cloud.config.profile='${config.profile:stg}'

----
- [通过python启动java程序](http://www.xuebuyuan.com/126568.html) 参考的这个网站
- 执行nohup 加上 & 就报syntax error near unexpected token：
  ```
    把 commands.getoutput 改成 os.system(cmd)
  ```
