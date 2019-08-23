package com.example.annotation.config;

import com.example.annotation.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName BeanConfig
 * @Description
 * @create 2019/8/21/0021 18:13
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Configuration
public class BeanConfig {

    @Bean(initMethod = "init")
    public User user(){
        return new User("test", 20);
    }

    @Bean(destroyMethod = "destroy")
    public User User1(){
        return new User("22", 2);
    }


}


