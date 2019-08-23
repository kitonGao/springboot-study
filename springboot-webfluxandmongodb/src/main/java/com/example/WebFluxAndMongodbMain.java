package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName WebFluxAndMongodbMain
 * @Description
 * @create 2019/8/23/0023 14:51
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@SpringBootApplication
@EnableReactiveMongoRepositories  //开启MongoDB
public class WebFluxAndMongodbMain {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxAndMongodbMain.class, args);
    }

}
