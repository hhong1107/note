

#### 基础命令



````shell

yum install nginx -y  # 安装
service nginx start		# 启动
systemctl enable nginx   # 自动启动
service nginx status 	# 查看状态


/usr/local/webserver/nginx/sbin/nginx -s reload            # 重新载入配置文件
/usr/local/webserver/nginx/sbin/nginx -s reopen            # 重启 Nginx
/usr/local/webserver/nginx/sbin/nginx -s stop              # 停止 Nginx
/usr/local/webserver/nginx/sbin/nginx -t 				   # 检查配置文件ngnix.conf的正确性
````





### 记录

403 问题

修改 /etc/nginx/nginx.conf   user root;

需要重启   nginx -c /etc/nginx/nginx.conf





#### 参考网站

[在本地 CentOS 7 上搭建 Web 开发环境 — Web 服务器 nginx](http://blog.csdn.net/zgmu/article/details/52889646)  用的这个的安装方法很简单  安装好的目录注意看状态就知道了

[nginx "403 Forbidden" 错误解决方法](https://yq.aliyun.com/ziliao/29119)

[很详细的Nginx配置说明](http://www.jb51.net/article/79216.htm)

-[Nginx安装及配置详解](http://www.cnblogs.com/zhouxinfei/p/7862285.html)

[Nginx配置文件（nginx.conf）配置详解](http://blog.csdn.net/tjcyjd/article/details/50695922)

[Web服务器之Nginx详解（操作部分）](http://blog.csdn.net/chengxuyuanyonghu/article/details/70801061)

[浅谈一个网页打开的全过程（涉及DNS、CDN、Nginx负载均衡等）](http://blog.csdn.net/king_a_123/article/details/52785516)

-[nginx 路由配置](http://www.cnblogs.com/jackylee92/p/6836948.html)

[Nginx配置实现前端Route路由与后端路由的分离](http://blog.csdn.net/a314368439/article/details/77773351)

[Nginx proxy pass路由转发简单用法](http://blog.csdn.net/guyue35/article/details/53907421)

-[Nginx+Https配置](https://segmentfault.com/a/1190000004976222)

[nginx启用对HTTP2的支持](http://www.jackieathome.net/archives/437.html)

-[ Nginx 上配置 HTTP2 最实在的教程了](http://www.cnblogs.com/probemark/p/5917927.html)

[Nginx负载均衡配置](http://blog.csdn.net/xyang81/article/details/51702900)

-[Nginx负载均衡的详细配置及使用案例详解.](http://www.cnblogs.com/wang-meng/p/5861174.html)

[如何快速实现一个基于Nginx的网站监控场景----需求篇](https://yq.aliyun.com/articles/72273)

[nginx优化 突破十万并发](http://blog.csdn.net/gb4215287/article/details/51765110)

[Nginx实现高并发优化](http://blog.csdn.net/atai2002/article/details/76041518)

##### 转发真实IP相关

-[学习笔记 - Nginx在多层代理下获取真实客户端IP地址](http://www.cnblogs.com/harryc/p/6361892.html)

-[Nginx获取真实用户IP](http://blog.csdn.net/zhongzh86/article/details/53067691)

-[nginx 如何配置来获取用户真实IP](http://blog.csdn.net/bigtree_3721/article/details/72820081)

