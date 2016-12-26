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
