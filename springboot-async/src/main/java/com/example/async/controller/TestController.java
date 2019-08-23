package com.example.async.controller;

import com.example.async.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName TestController
 * @Description
 * @create 2019/8/22/0022 14:14
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);


    @Autowired
    private TestService testService;


    @GetMapping(value = "async1")
    public void testAsync1(){
        long startTime = System.currentTimeMillis();
        logger.info("异步方法1开启");
        testService.asyncMethod1();
        logger.info("总耗时{}",System.currentTimeMillis() - startTime);
    }

    @GetMapping(value = "async2")
    public String testAsync2() throws ExecutionException, InterruptedException, TimeoutException {
        long startTime = System.currentTimeMillis();
        logger.info("异步方法2开启");

        Future<String> stringFuture = testService.asyncMethod2();

        String string = stringFuture.get(60, TimeUnit.SECONDS);
        logger.info("异步方法2返回值：{}", string);

        logger.info("异步方法2执行结束");

        logger.info("总耗时：{}", System.currentTimeMillis() - startTime);

        return string;
    }


    @GetMapping(value = "sync")
    public void testSync(){
        long startTime = System.currentTimeMillis();
        logger.info("同步方法开启");
        testService.syncMethod();
        logger.info("总耗时{}", System.currentTimeMillis() - startTime);
    }


}
