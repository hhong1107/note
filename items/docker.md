<!-- toc -->

- [参考网站](#参考网站)
  - [教程类](#教程类)
  - [工具类](#工具类)
  - [杂类](#杂类)
  - [问题类](#问题类)
  - [Jenkins](#jenkins)
- [杂记](#杂记)
  - [进入容器命令](#进入容器命令)
  - [Docker的四种网络模式](#docker的四种网络模式)
  - [启动命令](#启动命令)

<!-- tocstop -->



#### 参考网站

##### 教程类
- [教程](http://www.runoob.com/docker/docker-command-manual.html)
- [Docker实战-书籍](http://yuedu.baidu.com/ebook/d817967416fc700abb68fca1?fr=aladdin&key=docker教程&f=read###)\
- [利用Docker构建开发环境](http://tech.uc.cn/?p=2726)
- [Docker终极指南](http://dockone.io/article/133)

##### 工具类
- [国外仓库](https://hub.docker.com)
- # [国内仓库](https://c.163.com/hub#/m/home/)

##### 杂类
- [docker创建私有仓库](http://www.cnblogs.com/fengzheng/p/5168951.html)
- [使用 Docker 搭建 Java Web 运行环境](https://my.oschina.net/huangyong/blog/372491)
- [极客学院](http://wiki.jikexueyuan.com/project/docker-technology-and-combat/enter.html)

- [Docker学习笔记 — Docker私有仓库搭建](http://blog.csdn.net/wangtaoking1/article/details/44180901)
- [使用Spring Cloud和Docker构建微服务](http://www.open-open.com/lib/view/open1437363835818.html#articleHeader9)
- [使用docker发布spring cloud应用](http://www.cnblogs.com/skyblog/p/5163691.html)
- [Docker学习笔记（3）-- 如何使用Dockerfile构建镜像](http://blog.csdn.net/qinyushuang/article/details/43342553)
- [Ubuntu下Docker固定IP配置及桥接](http://www.linuxidc.com/Linux/2015-02/113783.htm)
- [Docker-数据卷和数据容器卷](http://www.cnblogs.com/zydev/p/5809616.html)

- [如何进入Docker容器](http://blog.csdn.net/u010397369/article/details/41045251)
- [精简为王：Docker镜像体积详解](http://www.tuicool.com/articles/Bre2Ybj)

- [深入浅出Docker（二）：Docker命令行探秘](http://www.infoq.com/cn/articles/docker-command-line-quest/)
- [ Docker Dockerfile详解](http://blog.csdn.net/wsscy2004/article/details/25878223)
- [两种方式创建你自己的 Docker 基本映像](https://linux.cn/article-5427-1.html)
- [制作自己的 Docker 镜像](http://jingyan.baidu.com/article/948f5924151366d80ff5f9dc.html)
- [Docker学习总结之Run命令介绍](http://www.tuicool.com/articles/uUBVJr)
- [Dockerfile创建自定义Docker镜像以及CMD与ENTRYPOINT指令的比较](http://www.cnblogs.com/lienhua34/p/5170335.html) 这里看出run 的时候传参
- [最佳实战Docker持续集成图文详解](http://cloud.51cto.com/art/201507/485900_all.htm) 自动部署可以参考
##### 问题类
- [docker 容器故障导致无法启动解决办法](http://blog.csdn.net/fffy2366/article/details/50112535)


##### Jenkins
- [Jenkins服务器安装与配置](http://blog.csdn.net/gaowenhui2008/article/details/51691578)
- [Jenkins Gitlab持续集成打包平台搭建](http://blog.csdn.net/zgzhaobo/article/details/52002181)
- [使用Jenkins 实现自动化构建](http://aoyouzi.iteye.com/blog/2294990)
- [持续集成(CI)、自动化构建和自动化测试--初探](http://www.cnblogs.com/chaoa/articles/4447354.html)
- [使用Jenkins配置自动化构建](http://blog.csdn.net/littlechang/article/details/8642149)


#### 杂记

##### 进入容器命令
    使用docker attach
    使用SSH
    使用nsenter
    使用exec

```shell
docker exec -it 775c7c9ee1e1 /bin/bash
```

##### Docker的四种网络模式
    Docker在创建容器时有四种网络模式，bridge为默认不需要用--net去指定，其他三种模式需要在创建容器时使用--net去指定。

    bridge模式，使用--net=bridge指定，默认设置。
    none模式，使用--net=none指定。
    host模式，使用--net=host指定。

##### 启动命令
```shell
docker run -p 2002:2002 -h fincar-common-2 --name='fincar-common-02'   fincar-common:test-conf  '--server.port=2002'
```


```shell
docker run -idt -p 2003:2003 -h fincar-common-3 --name='fincar-common-03'   fincar-common-1110:latest  '--server.port=2003 &'
```

```shell
容器使用宿主的IP 否则注册上去后外部会不能调用
docker run  --net=host -p 2002:2002 --name='fincar-common-02'   fincar-common:test-conf  '--server.port=2002'
```

```shell
后台启动
docker run -idt --net=host -v /home/fincar/tmp/log2:/tmp/log -p 2007:2007 --name='fincar-common-07'   fincar-common:test-conf  '--server.port=2007 --logging.path=/tmp/log/'
```

````shell
docker run  --net=host -v /home/fincar/tmp/log3:/logs -p 9003:9003 --name='fincar-common-test-db'   fincar-common-test:test-log  '--server.port=9003'  '--spring.cloud.config.profile=test-db4wang' '--spring.application.name=fincar-common-testdb4wang' '/logs/nohup.log 2>&1 &' 
````





docker run  --net=host -v /home/fincar/tmp/log3:/logs -p 9100:9100 --name='fincar-account-test'   fincar-account:test  '--server.port=9100'   '/logs/nohup.log 2>&1 &' 

