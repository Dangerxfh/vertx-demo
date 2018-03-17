package com.keepspy.vertx.core.eventbus.message;

/**
 * 自定义消息对象
 * Created by xufh on 2017/11/14.
 */
public class Message {

    private String type;

    private Object body;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

}
