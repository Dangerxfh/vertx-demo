package com.keepspy.vertx.core.eventbus.pubsub;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

public class ReceiverVerticle extends AbstractVerticle {




  @Override
  public void start() throws Exception {

    EventBus eb = vertx.eventBus();

    eb.consumer("com.keepspy.vertx.core.evemtbus", message -> System.out.println("Received message on consumer 1: " + message.body()));
    
    eb.consumer("com.keepspy.vertx.core.evemtbus", message -> System.out.println("Received message on consumer 2: " + message.body()));

    eb.consumer("com.keepspy.vertx.core.evemtbus", message -> System.out.println("Received message on consumer 3: " + message.body()));

  }


}
