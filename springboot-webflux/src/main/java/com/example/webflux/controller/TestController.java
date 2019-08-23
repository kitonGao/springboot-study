package com.example.webflux.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName TestController
 * @Description
 * @create 2019/8/23/0023 14:07
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);


    @GetMapping("sync")
    public String sync(){
        logger.info("sync method start..");
        String result = this.execute();
        logger.info("sync method end");
        return result;
    }

    @GetMapping(value = "async/mono")
    public Mono<String> asyncMono(){
        logger.info("async method start...");
        Mono<String> result = Mono.fromSupplier(this::execute);
        logger.info("async method end...");
        return result;
    }



    @GetMapping(value = "async/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> asyncFlux(){
        logger.info("async method start");
        Flux<String> result = Flux.fromStream(IntStream.range(1,5).mapToObj(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "int value: "+i;
        }));
        logger.info("async method end");
        return result;
    }





    private String execute(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }


}
