 -[官网文档](https://docs.docker.com/  )

- Linux 重启命令 reboot
- Linux 查看文件夹大小 du -sh *
- [使用yum快速升级CentOS 6.5内核到 3.10.28](http://www.tuicool.com/articles/rUvERv)


- 启动容器
  - docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
- 重启容器
  - docker start some-rabbit
- 查看日志
   docker logs docker容器的名字或进程id


#### 问题
- docker启动是 iptables 报iptables 报No chain/target/match by that name
  解决办法是容器下docker ： service docker restart

  ----
- [这个网站有iptables相关的内容 不过用了也没用](http://www.lxy520.net/2015/09/24/centos-7-docker-qi-dong-bao/)
- [iptables的详细介绍及配置方法](https://my.oschina.net/shipley/blog/299025)
- [linux下IPTABLES配置详解](http://www.cnblogs.com/JemBai/archive/2009/03/19/1416364.html)
- [常用docker命令，及一些坑](http://blog.csdn.net/wsscy2004/article/details/25878363)
- [ Docker 容器日志的那些事儿](http://blog.csdn.net/shlazww/article/details/47283617)


  [在 Docker 中使用 Java Spring Boot 框架](http://docs.daocloud.io/java-docker/docker-java-spring-boot)
  [蓝绿发布](http://leaver.me/2014/09/14/蓝绿发布的整个部署过程/)





### 单独安装

````
rpm -ivh erlang-19.0.4-1.el7.centos.x86_64.rpm
rpm -ivh rabbitmq-server-3.6.6-1.el7.noarch.rpm 
# 如果报没有装 socat
yum install socat

/sbin/service rabbitmq-server stop #关闭

/sbin/service rabbitmq-server start #启动

/sbin/service rabbitmq-server status #状态

./rabbitmq-plugins list

./rabbitmqctl status

./rabbitmq-plugins enable rabbitmq_management # 装管理台插件

# 默认guest 用户是不能远程登录的
rabbitmqctl add_user test 123456
rabbitmqctl  set_user_tags  test  administrator
rabbitmqctl set_permissions -p "/" test ".*" ".*" ".*"
````



[CentOS7 安装RabbitMQ](http://www.cnblogs.com/liaojie970/p/6138278.html) 安装参考网站

[RabbitMQ：安装、配置与使用初探](http://blog.csdn.net/sharetop/article/details/49716897)

[官网地址](http://www.rabbitmq.com/which-erlang.html)

-[rabbitmq的web管理界面无法使用guest用户登录](http://www.cnblogs.com/mingaixin/p/4134920.html)

[安装启动rabbitmq并配置远程访问web管理界面](http://blog.csdn.net/ownfire/article/details/51335072)

[设置RabbitMQ远程ip登录](http://www.jianshu.com/p/e3af4cf97820) 用户设置可参考