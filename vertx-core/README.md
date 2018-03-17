# vertx-core

- ### verticle
    verticle是vertx进行逻辑处理的单位，和Actor模型中的actor类似，vertx底层使用NIO模型，和Netty一样都是对Reactor模式的一种实现，项目中的verticle简单示例在[vertx-core/com/keepspy/vertx/core/verticle](https://github.com/Dangerxfh/vertx-demo/tree/master/vertx-core/src/main/java/com/keepspy/vertx/core/verticle)目录下，
   
    - SenderVerticle是消息发送者，将消息通过eventBus发送到相应地址，因为它是异步的，所以不会等待消费者返回消息，可以去执行其他任务；
    - RecevierVerticle 是消息消费者，它首先要在eventbus上相应的地址注册，然后如果注册的地址有消息就会消费，然后返回给发送方消息作为应答。
    
- ### eventBus
    Event Bus 是 Vert.x 的神经系统(官方给出)，我的个人理解，eventBus就像队列，能够起到模块间解耦、消息并行处理的作用，它的主要功能是：
    
     - 支持发布/订阅、点对点、请求/响应的消息通信方式;
     - 可形成跨越多个服务器节点和多个浏览器的点对点；
     
 :pushpin: EventBus简单工作原理如图：
        ![](https://github.com/Dangerxfh/vertx-demo/blob/master/imgs/eventbus.png)
