package com.keepspy.vertx.core.eventbus.message;

/**
 * Created by keepspy
 */
import io.vertx.core.AbstractVerticle;

public class WorkVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        /**
         * 接受来自msg.test地址的消息并处理，handler处理
         */
        vertx.eventBus().consumer("msg.test", handler->{
            Message msg =  (Message) handler.body();
            System.out.println(msg.getBody());

            msg.setBody("消息已收到！！！这是反馈消息");

            //消息反馈
            handler.reply(msg);


        });

    }

}