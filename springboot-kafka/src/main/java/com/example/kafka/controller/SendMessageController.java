package com.example.kafka.controller;

import com.example.kafka.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.Nullable;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈生产者发送消息〉
 *
 * @author Administrator
 * @ClassName SendMessageController
 * @Description
 * @create 2019/8/22/0022 15:13
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@RestController
public class SendMessageController {

    private static final Logger logger = LoggerFactory.getLogger(SendMessageController.class);

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate2;



//    @GetMapping(value = "send/{message}")
//    public void sendMessage(@PathVariable(value = "message") String message){
//        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send("test", message);
//        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//            @Override
//            public void onFailure(Throwable throwable) {
//                logger.info("消息{}发送失败，原因是：{}", message, throwable.getMessage());
//            }
//
//            @Override
//            public void onSuccess(@Nullable SendResult<String, String> result) {
//                logger.info("成功发送消息：{}, offset=[{}]",message, result.getRecordMetadata() );
//            }
//        });
//    }


    @GetMapping(value = "sendComplexity/{message}")
    public void sendComplexity(@PathVariable String message) {
        kafkaTemplate2.send("test", new Message("test", message));
    }


}
