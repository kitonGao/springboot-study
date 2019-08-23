package com.example.annotation.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName EnableHelloWorld
 * @Description
 * @create 2019/8/21/0021 18:21
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfig.class)
public @interface EnableHelloWorld {



}
