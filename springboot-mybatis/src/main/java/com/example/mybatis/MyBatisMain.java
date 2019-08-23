package com.example.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName MybatisMain
 * @Description
 * @create 2019/8/21/0021 17:06
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@SpringBootApplication
@MapperScan("com.example.mybatis.mapper")
public class MyBatisMain {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisMain.class, args);
    }


}
