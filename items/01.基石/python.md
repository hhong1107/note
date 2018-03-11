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

[Mac下 Pyenv 的安装使用](https://www.jianshu.com/p/cea9259d87df) 版本管理工具  ※  如果安装报错可能是没有gcc   yum -y install gcc

-[Python多版本共存管理工具之pyenv](http://www.cnblogs.com/ZhangRuoXu/p/6367084.html)
-[pyenv和pip安装](http://www.360doc.com/content/14/0909/11/14416931_408117076.shtml)
-[python字符串连接的三种方法及其效率、适用场景详](https://www.cnblogs.com/chenjingyi/p/5741901.html)
-[Python3中byte和string之间各种编码转换](http://blog.csdn.net/htdeyanlei/article/details/50866307)
-[Python—操作redis](https://www.cnblogs.com/melonjiang/p/5342505.html)
-[使用python来操作redis用法详解](https://www.jianshu.com/p/2639549bedc8)
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



- 指定python版本

````python
#!/usr/local/opt/python/bin/python2.7
````


##### 关于open()的mode参数：

https://www.cnblogs.com/zywscq/p/5441145.html


'r'：读

'w'：写

'a'：追加

'r+' == r+w（可读可写，文件若不存在就报错(IOError)）

'w+' == w+r（可读可写，文件若不存在就创建）

'a+' ==a+r（可追加可写，文件若不存在就创建）

对应的，如果是二进制文件，就都加一个b就好啦：

'rb'　　'wb'　　'ab'　　'rb+'　　'wb+'　　'ab+'














