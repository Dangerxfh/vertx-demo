package com.keepspy.vertx.core.eventbus.message;

/**
 * 发送消息的EventBus
 * Created by keepspy on 2017/11/14.
 */
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.MessageCodec;

public class MainVerticle extends AbstractVerticle {

    //  此示例实现了对象在eventbus中的传输，需要使用编解码器对对象进行序列化
   //   因为eventbus只接受string、buffer、json类型数据

    public static void main(String[] args) {

        DeploymentOptions deployment = new DeploymentOptions();
        deployment.setWorker(true);  //设置verticle实例为worker verticle

        try {
            for(int i=0;i<100;i++){  //启动100个verticle
                Vertx.vertx().deployVerticle(MainVerticle.class.getName(), deployment);
                Thread.sleep(2000);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    @Override
    public void start() throws Exception {

        vertx.deployVerticle(WorkVerticle.class.getName(), new DeploymentOptions().setWorker(true));

        MessageCodec codec=new MsgCodec();
        //订阅消息

        Message message = new Message();
        message.setType("get");
        message.setBody("我来请求数据！！");

//        注册默认编解码器
        vertx.eventBus().registerDefaultCodec(Message.class, new MsgCodec());

        //发送给msg.test地址一个请求数据的消息，然后通过replyHandler来接受反馈
        vertx.eventBus().send("msg.test", message, replyHandler->{
            if (replyHandler.result()!=null){
                Message msg = (Message) replyHandler.result().body();
                System.out.println(msg.getBody());
            }
            else {
                System.out.println("等待请求");
            }
        });
    }
}