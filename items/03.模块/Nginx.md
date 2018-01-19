

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