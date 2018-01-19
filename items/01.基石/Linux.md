



#### 问题

##### source .bashrc 报错 command not found: shopt

是因为使用了zsh 所以 要 source ~/.zshrc



#### 使用命令

######  screen

````
1、新建一个screen 直接screen或者screen -S XXX（XXX是你为这个screen指定的名字）
2、在screen中新建一个虚拟终端（此时你的screen中就有了两个虚拟终端了）
     ctrl+a+c（先按ctrl+a，然后再按c，下面的命令也一样）
3、在虚拟终端之间切换: 前一个ctrl+a+p  后一个ctrl+a+n 列表选择ctrl+a+shift+"
4、关闭一个虚拟终端 ctrl+a+k或者exit
5、挂起screen（挂起之后你又回到了创建screen的shell）
ctrl+a+d
6、重新连接screen: 
screen -ls列出当前挂起的screen
比如有这样一条“8888.XXX (Detached)”
那么可以使用screen -r 8888或者screen -r XXX来重新连接。
````



###### 修改时区

-[我使用过的Linux命令之tzselect - 选择时区](http://codingstandards.iteye.com/blog/834280)

````shell
tzselect    

# 选1 5 9 1
# 系统提示 You can make this change permanent for yourself by appending the line
#	TZ='Asia/Shanghai'; export TZ
# to the file '.profile' in your home directory; then log out and log in again

export TZ='Asia/Shanghai'

````







###### 其他命令

- 显示版本信息：cat /etc/issue  或  name-a


- centos 安装ssh ：yum install openssh-clients 


- 查看网络端口  netstat -an | grep 5672


- 关闭centos的防火墙：

          setenforce 0     

          service iptable stop

- 查进程 netstat –apn | grep 8080


- jps： 查看Java进程


- Kill -9：杀掉server 这个进程


-  Nohup ./startWerblogic.sh & ：启动服务并且重定向输出 敲两个回车


- Ps aux|grep java ：查看java进程，其中还包含了一些启动信息l


- Scp ./filename root@192.168.123.153 : 远程路径 上传jar包到服务器


- Jar xvf tiger.jar 解压


- tar xvf pigeon-server-1.0.0-SNAPSHOT-assembly.tar.gz


- rm -rf filename 递归强制删除


- 查找文件中内容：find . -name "*" |xargs grep "20160205427022"


- 强制安装ded： sudo dpkg -i google-chrome-stable_current_i386.deb --force


- 补齐依赖 ：sudo apt-get install -f


- 查看文件夹大小：du -h --max-depth=1 


- scp指定端口：scp -P33033 zp.tar root@111.222.123.01:/da1/web/zhaopin.shouhuobao.com


- 使用du -sh * 命令也可以列出当前文件以及文件夹的大小。这个命令要注意：sh与*之前要有个空格的。列出home目录所有文件大小的总和命令为：du -s  /home或du -sh /home


- CentOS查看内核版本、系统版本、系统位数 :uname -r    

- 查看系统java 

  home windows：echo java_home
  linux：echo $JAVA_HOME

- zip解压 unzip

- 压缩解压缩+密码

- 安装gnome   sudo apt-get  install gnome   重启后就可以了 注意看提示


````shell
tar -zcvf - pma|openssl v4.0.0.cer -salt -k 6kIu9RE8OBciD5nC | dd of=v4.0.0.cer.tar
tar -zcvf - pma|openssl ddsc-gateway.keystore -salt -k p0gXOwb73BRsuK6m | dd of=ddsc.tar

tar -czvf - ddsc-gateway.keystore | openssl des3 -salt -k p0gXOwb73BRsuK6m -out ddsc.tar.gz

openssl des3 -d -k p0gXOwb73BRsuK6m -salt -in ddsc.tar.gz | tar xzf -
````

- 关闭防火墙 centos 7: systemctl stop firewalld
- 查看端口：netstat -anp|grep 80 
- 如果提示netstat未找到命令: yum install net-tools


#### 用户相关

###### 添加用户

````
sudo adduser xxx 这样的命令会在home目录下添加一个帐号
sudo useradd xxx 仅仅是添加用户， 不会在home目录添加帐号
# useradd –d /usr/sam -m sam
此命令创建了一个用户sam，其中-d和-m选项用来为登录名sam产生一个主目录/usr/sam（/usr为默认的用户主目录所在的父目录）。
假设当前用户是sam，则下面的命令修改该用户自己的口令：
# passwd
Old password:**
New password:*
Re-enter new password:*
如果是超级用户，可以用下列形式指定任何用户的口令：
# passwd sam
New password:*
Re-enter new password:*
http://www.cnblogs.com/daizhuacai/archive/2013/01/17/2865132.html
Ubuntu建立和删除用户 http://www.linuxidc.com/Linux/2012-06/62985.htm](http://www.linuxidc.com/Linux/2012-06/62985.htm)

````



###### 给用户添加sudo权限



[给用户添加sudo的权限](http://www.cnblogs.com/xiaochaoyxc/p/6206481.html)

````
2.添加sudo文件的写权限,命令是:
chmod u+w /etc/sudoers

3.编辑sudoers文件
vi /etc/sudoers
找到这行 root ALL=(ALL) ALL,在他下面添加xxx ALL=(ALL) ALL (这里的xxx是你的用户名)

ps:这里说下你可以sudoers添加下面四行中任意一条
youuser            ALL=(ALL)                ALL
%youuser           ALL=(ALL)                ALL
youuser            ALL=(ALL)                NOPASSWD: ALL
%youuser           ALL=(ALL)                NOPASSWD: ALL

第一行:允许用户youuser执行sudo命令(需要输入密码).
第二行:允许用户组youuser里面的用户执行sudo命令(需要输入密码).
第三行:允许用户youuser执行sudo命令,并且在执行的时候不输入密码.
第四行:允许用户组youuser里面的用户执行sudo命令,并且在执行的时候不输入密码.

4.撤销sudoers文件写权限,命令:
chmod u-w /etc/sudoers

这样普通用户就可以使用sudo了
````



#### 软件相关

- [查看端口被哪个程序占用](http://www.2cto.com/os/201212/172982.html)

  ````
  yum install lsof
  lsof -i:8080
  ````

  ​





###### 卸载软件

````
找到此软件名称,然后sudo apt-get purge ......(点点为为程序名称),purge参数为彻底删除文件,

然后sudo apt-get autoremove,sudo apt-get clean和dpkg -l |grep ^rc|awk '{print $2}' |sudo xargs dpkg -P 两条命令来清除残余的配置文件

````



###### 解压缩

````
-c: 建立压缩档案

-x：解压

-t：查看内容

-r：向压缩归档文件末尾追加文件

-u：更新原压缩包中的文件

这五个是独立的命令，压缩解压都要用到其中一个，可以和别的命令连用但只能用其中一个。下面的参数是根据需要在压缩或解压档案时可选的。

-z：有gzip属性的

-j：有bz2属性的

-Z：有compress属性的

-v：显示所有过程

-O：将文件解开到标准输出

下面的参数-f是必须的

-f: 使用档案名字，切记，这个参数是最后一个参数，后面只能接档案名。

# tar -cf all.tar *.jpg 

这条命令是将所有.jpg的文件打成一个名为all.tar的包。-c是表示产生新的包，-f指定包的文件名。

# tar -rf all.tar *.gif 

这条命令是将所有.gif的文件增加到all.tar的包里面去。-r是表示增加文件的意思。

# tar -uf all.tar logo.gif 

这条命令是更新原来tar包all.tar中logo.gif文件，-u是表示更新文件的意思。

# tar -tf all.tar 

这条命令是列出all.tar包中所有文件，-t是列出文件的意思

# tar -xf all.tar 

这条命令是解出all.tar包中所有文件，-x是解开的意思

压缩

tar –cvf jpg.tar *.jpg //将目录里所有jpg文件打包成tar.jpg

tar –czf jpg.tar.gz *.jpg   //将目录里所有jpg文件打包成jpg.tar后，并且将其用gzip压缩，生成一  个gzip压缩过的包，命名为jpg.tar.gz

tar –cjf jpg.tar.bz2 *.jpg //将目录里所有jpg文件打包成jpg.tar后，并且将其用bzip2压缩，生成一个bzip2压缩过的包，命名为jpg.tar.bz2

tar –cZf jpg.tar.Z *.jpg   //将目录里所有jpg文件打包成jpg.tar后，并且将其用compress压缩，生成一个umcompress压缩过的包，命名为jpg.tar.Z

rar a jpg.rar *.jpg //rar格式的压缩，需要先下载rar for linux

zip jpg.zip *.jpg //zip格式的压缩，需要先下载zip for linux

解压

tar –xvf file.tar //解压 tar包

tar -xzvf file.tar.gz //解压tar.gz

tar -xjvf file.tar.bz2   //解压 tar.bz2

tar –xZvf file.tar.Z   //解压tar.Z

unrar e file.rar //解压rar

unzip file.zip //解压zip

总结

  (1)、*.tar 用 tar –xvf 解压

  (2)、*.gz 用 gzip -d或者gunzip 解压

  (3)、.tar.gz和.tgz 用 tar –xzf 解压

  (4)、*.bz2 用 bzip2 -d或者用bunzip2 解压

  (5)、*.tar.bz2用tar –xjf 解压

  (6)、*.Z 用 uncompress 解压

  (7)、*.tar.Z 用tar –xZf 解压

  (8)、*.rar 用 unrar e解压

  (9)、*.zip 用 unzip 解压
  
````



###### htop

安装：

````shell
# ubuntu
sudo apt-get install htop

# centos 7
## 首先启用 EPEL Repository:
yum -y install epel-release
## 启用 EPEL Repository 後, 可以用 yum 直接安裝 Htop:
yum -y install htop
````



Shortcut Key	Function Key	Description	中文说明
h, ?	F1	Invoke htop Help	查看htop使用说明
S	F2	Htop Setup Menu	htop 设定
/	F3	Search for a Process	搜索进程
\	F4	Incremental process filtering	增量进程过滤器
t	F5	Tree View	显示树形结构
<, >	F6	Sort by a column	选择排序方式
[	F7	Nice - (change priority)	可减少nice值，这样就可以提高对应进程的优先级
]	F8	Nice + (change priority)	可增加nice值，这样就可以降低对应进程的优先级
k	F9	Kill a Process	可对进程传递信号
q	F10	Quit htop	结束htop





-[centos6.5-64bit安装htop](http://www.cnblogs.com/liyou-blog/p/5741829.html)

-[为什么 Linux 的 htop 命令完胜 top 命令](https://linux.cn/article-3141-1.html)

-[Linux下取代top的进程管理工具 htop](http://www.cnblogs.com/mchina/archive/2013/03/15/2858041.html)

[htop使用备忘](http://www.cppblog.com/aurain/archive/2014/11/20/208928.html)





#### 其他

------

[centos7重新调整分区大小](http://blog.csdn.net/perfectzq/article/details/73606119)  之前没有重新挂载回home会导致系统没法重新启动

[http://www.centoscn.com/CentOS/2015/0430/5321.html](http://www.centoscn.com/CentOS/2015/0430/5321.html)

[64位Ubuntu kylin 16.04显示CPU内存使用率](http://blog.csdn.net/zn2857/article/details/52599980)

[Cloudinsight 监控系统](http://cloudinsight.oneapm.com/index.html)

xxx is not in the sudoers file.This incident will be reported.的解决方法 [http://www.cnblogs.com/xiaochaoyxc/p/6206481.html](http://www.cnblogs.com/xiaochaoyxc/p/6206481.html)

Seafile - 自己动手搭建个人/团队/公司专属私有文件同步服务 (云存储网盘)

- [linux的hostname修改详解](http://soft.chinabyte.com/os/281/11563281.shtml)


[12款最佳Linux命令行终端工具](http://www.vaikan.com/best-terminal-alternatives-for-linux-systems/)




如果把系统的/etc/profile 改坏了可以在命令行输入：

```shell
# export PATH=/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin:/root/bin
```



- [Linux修改/etc/profile配置错误commandisnotfound自救方法](http://www.2cto.com/os/201507/415607.html)


- xxx is not in the sudoers file.This incident will be reported.的解决方法
- [linux screen 命令详解](http://www.cnblogs.com/mchina/archive/2013/01/30/2880680.html)
- [ifconfig配置网络时，出现“SIOCSIFADDR: No such device”和“eth0:ERROR while getting interface flags:No such dev”](http://blog.csdn.net/sirenxiaohuayuan/article/details/50762358)
- [ubuntu14.04设置静态ip](http://www.cnblogs.com/vincedotnet/p/4013099.html)
- [CentOS yum 源的配置与使用](http://www.cnblogs.com/mchina/archive/2013/01/04/2842275.html)
- [超简单将Centos的yum源更换为国内的阿里云源](http://blog.csdn.net/chavo0/article/details/51939362)
- [CentOS 7.0关闭默认防火墙启用iptables防火墙](http://www.linuxidc.com/Linux/2015-05/117473.htm)
- [[GPG key retrieval failed: [Errno 14\] curl#37 - "Couldn't open file /etc/pki/rpm-gpg/RPM-GPG-KEY-Cent](http://blog.csdn.net/moolight_shadow/article/details/45749065)](http://blog.csdn.net/moolight_shadow/article/details/45749065)centos7更新完源之后安装软件会出现这个错误
- [在 Linux 下用 mkdir 命令来创建目录和子目录](https://linux.cn/article-2713-1.html)
- -[linux查看和修改PATH环境变量的方法](http://www.cnblogs.com/hust-chenming/p/4943268.html)
- -[Linux中使用export命令设置环境变量](http://www.cnblogs.com/isoftware/p/3778028.html)
- [linux下的top命令参数说明 （virt,res,shr,data 的意义）](http://blog.csdn.net/liuxingjiaofu/article/details/8237967)
- -[linux下的缓存机制及清理buffer/cache/swap的方法梳理](http://www.cnblogs.com/kevingrace/p/5991604.html)
- [手动释放linux内存cache](https://linux.cn/article-211-1.html)
- [linux查看哪个进程占用磁盘IO](http://blog.csdn.net/daiyudong2020/article/details/53863314)
- -[Linux查看某个进程的磁盘IO读写情况](http://www.cnblogs.com/EasonJim/p/8099956.html)
- [在Load average 高的情况下如何鉴别系统瓶颈](http://blog.csdn.net/aliaichidantong/article/details/70056182)

[Linux命令大全](http://man.linuxde.net/par/3)

[linux公社下载](http://linux.linuxidc.com/)

[Ubuntu 美化及超 NB 的 zsh 配置](https://zhuanlan.zhihu.com/p/27052046)

[Ubuntu 下安装oh-my-zsh](https://www.jianshu.com/p/9a5c4cb0452d)

