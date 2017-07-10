<!-- toc -->

			- [环境搭建](#环境搭建)
			- [参考网站](#参考网站)
				- [教程类](#教程类)
				- [工具类](#工具类)
- [国内仓库](#国内仓库httpsc163comhubmhome)
     - [杂类](#杂类)
         - [问题类](#问题类)
            - [Jenkins](#jenkins)
            - [杂记](#杂记)
            - [进入容器命令](#进入容器命令)
            - [Docker的四种网络模式](#docker的四种网络模式)
            - [启动命令](#启动命令)
            - [搭建私有仓库](#搭建私有仓库)
         - [Docker daemon日志的位置](#docker-daemon日志的位置httpblogcsdnnethalcyonbabyarticledetails47336269)
         - [命令](#命令)

<!-- tocstop -->



#### 环境搭建

一、升级内核（带aufs模块）

    1、yum安装带aufs模块的3.10内核（或到这里下载kernel手动安装：http://down.51cto.com/data/1903250）
    cd /etc/yum.repos.d
    
    wget http://www.hop5.in/yum/el6/hop5.repo
    
    yum install kernel-ml-aufs kernel-ml-aufs-devel
    2、修改grub的主配置文件/etc/grub.conf，设置default=0，表示第一个title下的内容为默认启动的kernel（一般新安装的内核在第一个位置）。
    3. 重启 reboot
    
    4、重启系统，这时候你的内核就成功升级了。
    [root@localhost ~]# uname -r
    3.10.5-3.el6.x86_64
        查看内核是否支持aufs：
    [root@localhost ~]# grep aufs /proc/filesystems
    nodev    aufs
    
    二、安装docker
        1、首先关闭selinux：
    setenforce 0
    sed -i '/^SELINUX=/c\SELINUX=disabled' /etc/selinux/config
        2、在Fedora EPEL源中已经提供了docker-io包，下载安装epel：
    rpm -ivh http://mirrors.sohu.com/fedora-epel/6/x86_64/epel-release-6-8.noarch.rpm
    sed -i 's/^mirrorlist=https/mirrorlist=http/' /etc/yum.repos.d/epel.repo
        3、yum安装docker-io：
    
    yum -y install docker-io

http://www.centoscn.com/image-text/install/2014/1128/4202.html

http://www.linuxidc.com/Linux/2014-07/104768.htm

http://www.server110.com/docker/201411/11105.html



#### 参考网站
- [在Docker容器中运行Spring Boot应用](https://www.tianmaying.com/tutorial/spring-boot-docker)
- [技术讨论：微服务和容器比虚拟机快多少？](http://dockone.io/article/1674)
- [微服务架构下应用docker化实践](http://7xi8kv.com5.z0.glb.qiniucdn.com/%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%9E%B6%E6%9E%84%E4%B8%8B%E5%BA%94%E7%94%A8docker%E5%8C%96%E5%AE%9E%E8%B7%B5.pdf)
- [再谈Docker-微服务的场景化应用](http://www.jianshu.com/p/9805545db4ad)
- [微服务革命：容器化的应用、数据及其它一切](http://www.infoq.com/cn/articles/microservices-revolution)
- [肖德时：如何用Docker来管理微服务架构的乱网](http://www.infoq.com/cn/articles/docker-microservice-architect)
- [如何优雅地停止运行中的内嵌Tomcat的Spring Boot应用](http://jaskey.github.io/blog/2016/04/05/shutdown-spring-boot-application-gracefully/)
- [使用Weave实现Docker多宿主机互联](http://www.tuicool.com/articles/YJF7ben)
- [Docker监控及日志采集神器](https://segmentfault.com/a/1190000007595832)
- [Docker本地仓库简单使用一些例子](http://www.111cn.net/sys/linux/118539.htm)
- [官方安装指南](https://store.docker.com/editions/community/docker-ce-server-centos) 按照这个就能使用
##### 教程类
- [教程](http://www.runoob.com/docker/docker-command-manual.html)
- [Docker实战-书籍](http://yuedu.baidu.com/ebook/d817967416fc700abb68fca1?fr=aladdin&key=docker教程&f=read###)
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
- [在Docker上运行微服务](http://www.infoq.com/cn/news/2015/06/qiniu-best531?utm_campaign=infoq_content&)
- [理解Docker（三）- 微服务的好基友](http://www.tuicool.com/articles/NzUnuuq)
- [介绍 Docker 的 pulldocker 和 CVFS](https://www.oschina.net/translate/docker-without-containers-pulldocker)
- [CentOS系统下docker的安装配置及使用详解](https://www.server110.com/docker/201411/11105.html) 这里有容器持久化的 可能会需要
- [如何在Docker容器内外互相拷贝数据？](http://blog.csdn.net/yangzhenping/article/details/43667785)
- [docker容器故障致无法启动解决实例](http://www.mincoder.com/article/4045.shtml)
- [使用Docker容器的十大误区](http://www.open-open.com/lib/view/open1463108483467.html)
- [Docker 容器日志的那些事儿](http://blog.csdn.net/shlazww/article/details/47283617)
  -[Docker 清理命令集锦](http://blog.csdn.net/huangjin0507/article/details/51162869)

-[docker 1.12.3版本搭建私有仓库，上传镜像报错：server gave HTTP response to HTTPS client”](https://www.bbsmax.com/A/A7zg22MVd4/)







[10个基于DOCKER的顶尖开发工具]: http://www.jdon.com/artichect/top-10-open-source-docker-developer-tools.html
[]:



##### 问题类
- [docker 容器故障导致无法启动解决办法](http://blog.csdn.net/fffy2366/article/details/50112535)

- 乱码问题：

  - [docker 容器 中文乱码问题](http://blog.csdn.net/u013092590/article/details/53408415)
  - [解决docker容器中,日志中文乱码问题](http://blog.csdn.net/zyf_balance/article/details/53172581)
  - [解决Ubuntu cannot change locale](http://blog.lmlphp.com/archives/94/Solve_Ubuntu_can_not_change_locale_en_US_UTF8)
  - [解决docker容器中文乱码，修改docker容器编码格式](http://www.cnblogs.com/z-belief/p/6148463.html)
  - []()


  实际解决办法：

   开始设置成为 LANG=en_US.UTF-8

  但是没有起效果  进系统的时候 会报Cannot set LC_CTYPE to default locale: No such file or directory

  应该是没有安装对应的包  而在docker有比较难安装 所以采用了在Dockfile中加入ENV LANG C.UTF-8

  最终解决了乱码问题

- []()

- []()

- []()

- []()

  ​




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





##### Docker容器时间同步问题

````
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
````

http://dockone.io/question/505



##### 删除none的镜像

````shell
docker ps -a | grep "Exited" | awk '{print $1 }'|xargs docker stop
docker ps -a | grep "Exited" | awk '{print $1 }'|xargs docker rm
docker images|grep none|awk '{print $3 }'|xargs docker rmi

````





docker run  --net=host -v /home/fincar/tmp/log3:/logs -p 9100:9100 --name='fincar-account-test'   fincar-account:test  '--server.port=9100'   '/logs/nohup.log 2>&1 &'



docker run  --net=host -v /tmp/fincar-logs:/logs -p 9102:9102 --name='fincar-account-3'   192.168.3.199:5000/fincar-account:V001 '--server.port=9102'  '--config.profile=test'   '/logs/nohup.log 2>&1 &'



----

####  搭建私有仓库



[CentOS 7 : Docker私有仓库搭建和使用]: http://blog.csdn.net/fgf00/article/details/52040492
[CentOS7搭建Docker私有仓库]: http://www.centoscn.com/CentosServer/ftp/2015/0426/5280.html
[docker 容器 中文乱码问题]: http://blog.csdn.net/u013092590/article/details/53408415

````
下载镜像
 sudo docker pull registry  
 启动镜像
 sudo docker run -d -p 5000:5000 registry  
 sudo docker run -d -p 5000:5000 -v /opt/data/registry:/tmp/registry registry

 那试验地镜像打个tag：:q
 sudo docker tag busybox 192.168.112.136:5000/busybox  
````









centOS:vi /etc/sysconfig/docker 文件中加入如下配置

````
OPTIONS='--insecure-registry 192.168.0.179:5000'    #CentOS 7系统
other_args='--insecure-registry 192.168.0.179:5000' #CentOS 6系统
````

加入后需要重启一下   service docker restart

ubuntu: 客户端通过HTTP协议拉取镜像，需要添加insecure-registry配置。在ubuntu14.04的环境下编辑docker的配置文件中，添加DOCKER_OPTS选项内容。，操作如下：加入如下内容（IP应为服务端IP）：

````
$ sudo vi /etc/default/docker

DOCKER_OPTS="--insecure-registry 192.168.142.128:5000"
````



- ### [Docker daemon日志的位置](http://blog.csdn.net/halcyonbaby/article/details/47336269)

Docker daemon日志的位置，根据系统不同各不相同。  

* Ubuntu - /var/log/upstart/docker.log
* Boot2Docker - /var/log/docker.log
* Debian GNU/Linux - /var/log/daemon.log
* CentOS - /var/log/daemon.log | grep docker
* Fedora - journalctl -u docker.service
* Red Hat Enterprise Linux Server - /var/log/messages | grep docker



### 命令

- [Docker学习笔记(2)--Docker常用命令](http://www.tuicool.com/articles/7V7vYn)

````
删除所有容器
docker rm `docker ps -a -q`
````



docker rm `docker ps -a -q`

- [Docker 重命名镜像 TAG](http://blog.csdn.net/a19891024/article/details/68946065)

````
docker tag IMAGEID(镜像id) REPOSITORY:TAG（仓库：标签）

#例子
docker tag ca1b6b825289 registry.cn-hangzhou.aliyuncs.com/xxxxxxx:v1.0
````



- 搭建支付系统



````shell
docker run -idt --net=host -v /tmp/ddsc-log:/logs -v /.keys:/.keys  -p 8118:8118 --name=ddsc-pay  ddsc.dock.registry:5000/ddsc-pay:1.0.0 '--server.port=8118'  '--config.profile=prod' '--spring.cloud.config.label=DEV20170301'


docker build -t ddsc.dock.registry:5000/ddsc-pay:1.0.0  .
````

