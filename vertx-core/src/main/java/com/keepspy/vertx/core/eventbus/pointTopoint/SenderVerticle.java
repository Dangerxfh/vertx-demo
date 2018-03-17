package com.keepspy.vertx.core.eventbus.pointTopoint;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;

/**
 * Created by xufh on 2018/3/17.
 */
public class SenderVerticle extends AbstractVerticle {

    //点对点消息模式
    @Override
    public void start() throws Exception {

        vertx.deployVerticle(RecevierVerticle.class.getName());
        EventBus eventBus=vertx.eventBus();

        //每隔1s发送一次消息
        vertx.setPeriodic(1000,hanlder->{
           eventBus.send("com.keepspy.vertx.core.eventbus","hello",handler->{
               if(handler.succeeded()){
                   System.out.println("[Sender] Recevied reply: "+handler.result().body());
               }else {
                   System.out.println("no reply");
               }
           });
        });
    }

    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(SenderVerticle.class.getName());
    }
}
