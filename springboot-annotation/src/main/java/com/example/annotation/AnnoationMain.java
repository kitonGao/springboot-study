package com.example.annotation;

import com.example.annotation.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName AnnoationMain
 * @Description
 * @create 2019/8/21/0021 17:29
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@ComponentScan("com.example.annotation.service")
@SpringBootApplication
public class AnnoationMain {


    public static void main(String[] args) {

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
//        User user =ctx.getBean("person");
//        System.out.println(null);

        ConfigurableApplicationContext context = new SpringApplicationBuilder(AnnoationMain.class)
                .web(WebApplicationType.NONE)
                .run(args);
        TestService testService = context.getBean("testService", TestService.class);
        System.out.println("testService Bean:   "+ testService);
        context.close();
    }




}
