# vertx-demo

这个项目包含一些vertx部分模块入门示例（java），包括vertx-core、vertx-web、vertx-mongo、vertx-kafka、vertx-cluster等,下面是对每个模块（包括子模块）的示例进行讲解

- ## vertx-core
   vertx-core是vertx的核心类库，包括以下功能：
     - 编写 TCP 客户端和服务端
     - 编写支持 WebSocket 的 HTTP 客户端和服务端
     - 事件总线(EventBus)
     - 共享数据 —— 本地的Map和分布式集群Map
     - 周期性、延迟性动作
     - 部署和撤销 Verticle 实例
     - 数据报套接字
     - DNS客户端
     - 文件系统访问
     - 高可用性（HA）
     - 集群
     
- ### verticle
    verticle是vertx进行逻辑处理的单位，和Actor模型中的actor类似，vertx底层使用NIO模型，和Netty一样都是对Reactor模式的一种实现，项目中的verticle简单示例在vertx-core/com/keepspy/vertx/core/verticle目录下，
    
