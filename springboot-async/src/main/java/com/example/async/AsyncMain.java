package com.example.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName AsyncMain
 * @Description
 * @create 2019/8/22/0022 14:08
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@SpringBootApplication
//开启异步支持
@EnableAsync
public class AsyncMain {

    public static void main(String[] args) {
        SpringApplication.run(AsyncMain.class, args);
    }

}
