package com.keepspy.vertx.core.eventbus.pointTopoint;

import io.vertx.core.AbstractVerticle;

/**
 * Created by keepspy on 2018/3/17.
 */
public class RecevierVerticle  extends AbstractVerticle{
    @Override
    public void start() throws Exception {
        vertx.eventBus().consumer("com.keepspy.vertx.core.eventbus",message->{

            if(message!=null){
                System.out.println("[Receive] recevied message: "+message.body());
                message.reply("vertx!");
            }
        });
    }
}
