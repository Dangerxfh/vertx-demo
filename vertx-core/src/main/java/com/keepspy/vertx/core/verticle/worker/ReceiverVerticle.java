package com.keepspy.vertx.core.verticle.worker;

import io.vertx.core.AbstractVerticle;

/**
 * Created by xufh on 2018/3/17.
 */
public class ReceiverVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {

        System.out.println("[Recevier] Running in:"+Thread.currentThread().getName());
        //消费者消费对应地址的数据
        vertx.eventBus().consumer("com.keepspy.vertx.core",handler->{

            if(handler.body()!=null){
                //接收消息
                String message= (String) handler.body();
                System.out.println("[Recevier]has receive message: "+message);

                //返回给生产者消息
                handler.reply("hello consumer has receive the message");
            }else {
                System.out.println("[Recevier]no message was recevied");
            }
        });
    }

}
