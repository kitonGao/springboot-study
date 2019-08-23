package com.example.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName RedisMain
 * @Description
 * @create 2019/8/21/0021 10:09
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@EnableCaching //开启注解缓存功能
@SpringBootApplication
public class RedisMain {


    public static void main(String[] args) {
        SpringApplication.run(RedisMain.class, args);
    }

}
