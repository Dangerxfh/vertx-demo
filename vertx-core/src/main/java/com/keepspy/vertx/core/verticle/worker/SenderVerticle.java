package com.keepspy.vertx.core.verticle.worker;

import io.netty.util.Version;
import io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * Created by xufh on 2018/3/17.
 */
public class SenderVerticle extends AbstractVerticle {

    //定义一个vertx实例，当然并没有进行任何配置
//    Vertx vertx=Vertx.vertx();

    @Override
    public void start() throws Exception {

        System.out.println("[Sender] Running in :"+Thread.currentThread().getName());
        //启动消费者Verticle
        vertx.deployVerticle(ReceiverVerticle.class.getName());

        Thread.sleep(2000);
        //我们通过eventbus向com.keepspy.vertx.core发送消息"hello vertx",并接受返回消息
        vertx.eventBus().send("com.keepspy.vertx.core","hello vertx",handler->{
            if(handler.succeeded()){
                System.out.println("[Sender]send success,and receive message: "+handler.result().body());
            }else {  //发送失败
                System.out.println("[Sender]send fail"+handler.cause());
            }
        });
    }

    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(SenderVerticle.class.getName());
    }
}
