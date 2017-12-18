##### centOS安装pip

````
sudo yum -y install epel-release
sudo yum -y install python-pip
sudo pip install 需要安装的包名
````

- [centos下使用yum 安装pip](http://www.cnblogs.com/Rsean/p/5635904.html)



##### ubuntu安装pip

````
$ sudo apt-get install python-pip python-dev build-essential 
$ sudo pip install --upgrade pip 
$ sudo pip install --upgrade virtualenv 
````

- [ubuntu 安装pip](http://blog.csdn.net/lmmilove/article/details/44470585)





#### 参考网站

-[python中的字符数字之间的转换函数](http://www.cnblogs.com/wuxiangli/p/6046800.html)

-[python操作Excel读写--使用xlrd](http://www.cnblogs.com/lhj588/archive/2012/01/06/2314181.html)

[Requests的好基友BeautifulSoup4](https://mp.weixin.qq.com/s/k_wQWkb3BieR3dtL-9Tr8A)





#### 知识点

#####  python使用any判断一个对象是否为空的方法

- 判断对象

````shell
>>> eth = {"eth0″:"192.168.1.1″}
>>> any(eth)
True
>>> eth = {}
>>> any(eth)
False
````

- 判断list: 由于一个空 list 本身等同于 False，所以可以直接：

````shell
if mylist:
    # Do something with my list
else:
    # The list is empty
````

#####  读取二进制文件

````python
binfile=open(filepath,'rb')    读二进制文件
或
binfile=open(filepath,'wb')    写二进制文件
````



















