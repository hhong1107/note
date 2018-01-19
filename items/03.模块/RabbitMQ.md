<!-- toc -->

- [队列](#队列)
- [交换器](#交换器)
  - [理解](#理解)
- [其他](#其他)
- [Spring-rabbitMQ](#spring-rabbitmq)

<!-- tocstop -->



### 安装

- [安装参考网站](http://my.oschina.net/u/998693/blog/547873)
- 启动：sbin ./rabbitmq-server
- 停止：./rabbitmqctl stop
- 启动web管理台：sbin ./rabbitmq-plugins enable rabbitmq_management
- 查看网络端口(管理台一般在 15672端口) netstat -an | grep 5672  [参考网站

### 概述

- AMQP元素-交换器、队列和绑定
- 我们可以吧Rabbit当做是一种投递服务。Rabbit在应用程序和服务器之间扮演路由器的角色。
- 消息包含两部分：有效负荷(payload)和标签(label)
- 信道：每条信道都被指派一个唯一ID（AMQP的库会帮忙记录ID）


### 队列
- Message durability消息持久化：durable=True
- Message acknowledgment 消息确认：消费端处理完数据后发ack
- Fair dispatch 公平分发：设置prefetch_count=1 。这样RabbitMQ就会使得每个Consumer在同一个时间点最多处理一个Message。换句话说，在接收到该Consumer的ack前，他它不会将新的Message分发给它。

### 交换器
- direct：如果路由键匹配的话，消息就被投递带对应的队列。服务器必须实现direct类型的交换器，包含一个空白字符串名词的默认交换器。当声明一个队列时他会自动绑定到默认交换器，并以队列名称作为路由键
  - Direct exchange
    ![](../label/img/direct-exchange.png)
> Direct exchange的路由算法非常简单：通过binding key的完全匹配
> exchange X和两个queue绑定在一起。Q1的binding key是orange。Q2的binding key是black和green。
    当P publish key是orange时，exchange会把它放到Q1。如果是black或者green那么就会到Q2。其余的Message都会被丢弃

    -Multiple bindings
    ![direct-exchange-multiple](../label/img/direct-exchange-multiple.png)
> 多个queue绑定同一个key是可以的。对于下图的例子，Q1和Q2都绑定了black。也就是说，对于routing key是black的Message，会被deliver到Q1和Q2。其余的Message都会被丢弃。    

- fanout：广播。当发送一条消息到fanout交换器时，他会将消息投递给所有附件在此交换器上的队列。这允许你对单条消息做不同方式的反应。(当然在同一队列上的应用只有一个能收到消息)

- Topic exchange
> 对于Message的routing_key是有限制的，不能使任意的。格式是以点号“."分割的字符表。比如："stock.usd.nyse", "nyse.vmw", "quick.orange.rabbit"。你可以放任意的key在routing_key中，当然最长不能超过255 bytes。


- 对于routing_key，有两个特殊字符（在正则表达式里叫元字符）：

  \* (星号) 代表任意 一个单词

  \# (hash) 0个或者多个单词

  ![](../label/img/python-five.png)

> 比如routing_key是 "quick.orange.rabbit"将会发送到Q1和Q2中。消息"lazy.orange.elephant" 也会发送到Q1和Q2。但是"quick.orange.fox" 会发送到Q1；"lazy.brown.fox"会发送到Q2。"lazy.pink.rabbit" 也会发送到Q2，但是尽管两个routing_key都匹配，它也只是发送一次。"quick.brown.fox" 会被丢弃。
> 如果发送的单词不是3个呢？ 答案要看情况，因为#是可以匹配0个或任意个单词。比如"orange" or "quick.orange.male.rabbit"，它们会被丢弃。如果是lazy那么就会进入Q2。类似的还有 "lazy.orange.male.rabbit"，尽管它包含四个单词。

- Topic exchange和其他exchange
  由于有"\*" (star) and "#" (hash)， Topic exchange 非常强大并且可以转化为其他的exchange：
  如果binding_key 是 "#" - 它会接收所有的Message，不管routing_key是什么，就像是fanout exchange。
  如果 "\*" (star) and "#" (hash) 没有被使用，那么topic exchange就变成了direct exchange。

----
- String 集成的时候 默认是会返回ack 的。在代码实现的时候需要注意异常不能抛出 否则容易引起 rabbitmq一直调用

#### 理解
- queue对应的是消费者，exchange对应的是生产者
- 多个系统或者客户端对接同一个queue的话同一份消息只会收到一次。理解的时候不要把queue就直接当做客户端

----
### 其他
- [RabbitMQ从入门到精通](http://blog.csdn.net/column/details/rabbitmq.html)
- [Spring AMQP](http://docs.spring.io/spring-amqp/reference/htmlsingle/)
- [spring-boot 集成rabbitmq](https://segmentfault.com/a/1190000004401870)
- [RabbitMQ+Python入门经典 兔子和兔子窝](http://blog.csdn.net/linvo/article/details/5750987)
- [RabbitMQ与AMQP协议详解](http://www.cnblogs.com/frankyou/p/5283539.html)
- [Kafka、RabbitMQ、RocketMQ消息中间件的对比—— 消息发送性能](https://yq.aliyun.com/articles/25385)
- [ AMQP协议（经典）](http://blog.csdn.net/zhangxinrun/article/details/6411841)
- [RabbitMQ中的基本概念](http://emacsist.github.io/2015/12/06/RabbitMQ中的基本概念/)
- -[RabbitMQ erlang.cookie解惑](http://www.cnblogs.com/xgtx/articles/6068392.html)
- -[RabbitMQ报错Error: unable to connect to node rabbit@xxx: nodedown的解决方式](http://chingo.org/post/rabbitmq-error-unable-to-connect-to-node-rabbit-nodedown-solution.html)
- -[RabbitMQ学习笔记四：RabbitMQ命令（附疑难问题解决）](http://www.cnblogs.com/wuzhiyuan/p/6856985.html)
- [Rabbitmq学习之路2-rabbitmqctl](https://my.oschina.net/guol/blog/186445)
- -[RabbitMQ 集群与高可用配置](http://88250.b3log.org/rabbitmq-clustering-ha)
- -[python RabbitMQ队列使用（入门篇）](http://www.cnblogs.com/kerwinC/p/5967584.html)
- []()
- []()

### Spring-rabbitMQ
- [spring boot实战(第十四篇)整合RabbitMQ源码分析前言](http://blog.csdn.net/liaokailin/article/details/49562651)
   手动监听
```java
@Bean  
    public SimpleMessageListenerContainer messageContainer() {  
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());  
        container.setQueues(queue());  
        container.setExposeListenerChannel(true);  
        container.setMaxConcurrentConsumers(1);  
        container.setConcurrentConsumers(1);  
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认  
        container.setMessageListener(new ChannelAwareMessageListener() {  

            @Override  
            public void onMessage(Message message, Channel channel) throws Exception {  
                byte[] body = message.getBody();  
                System.out.println("receive msg : " + new String(body));  
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费  
            }  
        });  
        return container;  
    }  
```

- [Spring AMQP消息监听容器配置](http://blog.csdn.net/sn_gis/article/details/41252109)
- [AmqpTemplate-发送-接收-消息](http://www.aichengxu.com/view/37900)
- []()
- []()
- []()
- []()
- []()
- []()
- []()
