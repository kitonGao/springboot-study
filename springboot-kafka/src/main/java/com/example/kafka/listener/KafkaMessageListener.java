package com.example.kafka.listener;

import com.example.kafka.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName KafkaMessageListener
 * @Description
 * @create 2019/8/22/0022 15:58
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Component
public class KafkaMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

//    @KafkaListener(topics = "test") //, groupId = "test-consumer"
//    public void listenerMessage(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition){
//        logger.info("接收消息：{}, partition:{}", message, partition);
//    }

    @KafkaListener(topics = "test") //, groupId = "test-consumer"
    public void listenerMessage(Message message){
        logger.info("接收消息：{}", message);
    }

}
