package com.example.kafka.entity;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName Message
 * @Description
 * @create 2019/8/22/0022 16:39
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
public class Message implements Serializable{

    private static final long serialVersionUID = 6678420965611108427L;

    private String from;

    private String message;

    public Message() {
    }

    public Message(String from, String message) {
        this.from = from;
        this.message = message;
    }


    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
