package com.keepspy.vertx.core.eventbus.pubsub;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;

public class SenderVerticle extends AbstractVerticle {



  @Override
  public void start() throws Exception {

    EventBus eb = vertx.eventBus();

    vertx.deployVerticle(ReceiverVerticle.class.getName());

    // 每隔一秒发送一次消息
    //可以通过使用send和publish发送消息，比较点对点模式和发布订阅模式的区别
    //官方给出的在点对点模式中，如果在一个地址上注册有多个处理器,vertx将使用“不严格的轮询算法”选择其中一个
    //   vertx.setPeriodic(1000, v -> eb.send("com.keepspy.vertx.core.evemtbus", "hello eventBus"));
    vertx.setPeriodic(1000, v -> eb.publish("com.keepspy.vertx.core.evemtbus", "Some news!"));
  }

  public static void main(String[] args) {

//    Vertx vertx=Vertx.vertx();

    Vertx.vertx().deployVerticle(SenderVerticle.class.getName());
  }
}
