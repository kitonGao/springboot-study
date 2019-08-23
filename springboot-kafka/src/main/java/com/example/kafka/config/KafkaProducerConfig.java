package com.example.kafka.config;

import com.example.kafka.entity.Message;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈消息生产者配置〉
 *
 * @author Administrator
 * @ClassName KafkaProducerConfig
 * @Description
 * @create 2019/8/22/0022 15:03
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

//    @Bean
//    public ProducerFactory<String, String> producerFactory(){
//        Map<String, Object> configProps = new HashMap<>();
//        /*为Kafka生产者的地址*/
//        configProps.put(
//                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers );
//        /*指定KEY*/
//        configProps.put(
//                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        /*value的序列化策略*/
//        configProps.put(
//
////                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class
//        );
//
//        return new DefaultKafkaProducerFactory<String, String>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate(){
//        return new KafkaTemplate<String, String>(producerFactory());
//    }


    /**
     * 将返回的对象改为Message对象，并且更改序列化策略
     * @return
     */
    @Bean
    public ProducerFactory<String, Message> producerFactory(){
        Map<String, Object> configProps = new HashMap<>();

        /*为Kafka生产者的地址*/
        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers );
        /*指定KEY*/
        configProps.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        /*value的序列化策略*/
        configProps.put(
//                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class
        );

        return new DefaultKafkaProducerFactory<String, Message>(configProps);
    }

    @Bean
    public KafkaTemplate<String, Message> kafkaTemplate(){
        return new KafkaTemplate<String, Message>(producerFactory());
    }



}
