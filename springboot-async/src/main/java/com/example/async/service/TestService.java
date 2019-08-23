package com.example.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName TestService
 * @Description
 * @create 2019/8/22/0022 14:10
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Service
public class TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestService.class);


    /**
     * 异步方法无返回值
     */
//    @Async
//    要使用该线程池，只需要在@Async注解上指定线程池Bean名称即可：
    @Async(value = "asyncThreadTaskExecutor")
    public void asyncMethod1(){
       sleep();
       logger.info("异步方法内部线程名:{}",Thread.currentThread().getName());
    }


    @Async(value = "asyncThreadTaskExecutor")
    public Future<String> asyncMethod2(){
        sleep();
        logger.info("带返回参数的异步方法内部线程名：{}", Thread.currentThread().getName());
        return new AsyncResult<>("hello async");
    }



    public void syncMethod(){
        sleep();
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2); //2秒。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
