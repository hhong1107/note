



### 参考网站

[利用K8S技术栈打造个人私有云（连载之：K8S集群搭建）](https://yq.aliyun.com/articles/419570?spm=5176.10695662.1996646101.searchclickresult.715942e48ZzaXa)

-[Kubernetes核心概念总结](http://www.cnblogs.com/zhenyuyaodidiao/p/6500720.html)

-[第一章 kubernetes入门](https://www.jianshu.com/p/63ffc2214788)

[你女儿也能看懂的插画版Kubernetes指南](http://www.linuxidc.com/Linux/2016-07/132908.htm)

[Kubernetes和Spring Cloud哪个部署微服务更好](http://blog.csdn.net/qq_34463875/article/details/53816943)

[搭建及使用K8s集群  <目录> ](http://blog.csdn.net/justhavetry/article/details/78248436)

[搭建及使用K8s集群 <k8s 集群部署springcloud 多应用>](http://blog.csdn.net/justhavetry/article/details/78249590)

[搭建及使用K8s集群 <k8s集群部署springcloud 单应用>](http://blog.csdn.net/justhavetry/article/details/78247429)

[搭建及使用K8s集群 <使用ingress 暴露springcloud服务>](http://blog.csdn.net/justhavetry/article/details/78257374)

[JustHaveTry的专栏](http://blog.csdn.net/justhavetry)

-[使用kubernetes访问外部服务（mysql\redis）](http://blog.csdn.net/qq_35904833/article/details/77447867)

-[理解Kubernetes网络之Flannel网络](http://tonybai.com/2017/01/17/understanding-flannel-network-for-kubernetes/)

-[Kubernetes的网络模型](http://blog.csdn.net/zjysource/article/details/52052420)



-[关于Kubernetes在2018年发展趋势的4项预测](https://www.kubernetes.org.cn/3516.html)

-[说说Kubernetes是怎么来的，又是怎么没的](https://www.kubernetes.org.cn/3518.html) ※

-[是时候使用Helm了：Helm, Kubernetes的包管理工具](https://www.kubernetes.org.cn/3435.html)

-[Kubernretes免费视频课程 | 开放技术*IBM微讲堂出品](https://www.kubernetes.org.cn/3546.html)

-[Kubernretes免费视频课程 | 开放技术*IBM微讲堂出品](https://www.kubernetes.org.cn/3546.html)

-[Kubernretes免费视频课程 | 开放技术*IBM微讲堂出品](https://www.kubernetes.org.cn/3546.html)

[中文社区](https://www.kubernetes.org.cn/)



----

-[centos7下安装kubectl](http://www.niuhp.com/docker/install-kubectl-on-centos7-64.html)  参考这个网站下载zip包来安装

-[Kubernetes网络原理及方案](https://www.kubernetes.org.cn/2059.html)


### 命令

````shell
    minikube status
    minikube dashboard
    kubectl cluster-info  - 查看状态
    kubectl get deploy xxx

    kubectl get po -o wide
    kubectl get rs
    # 查看service
    kubectl get svc

    # 查看暴露的端口
    kubectl get ep
    
    kubectl logs xxx
    kubectl exec -it  xxx /bin/bash

    # 升级image
    kubectl set image deploy nginx nginx=nginx:1.9.1
    # 查看详细详细
    kubectl describe deploy nginx

````