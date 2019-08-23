package com.example.exception.controller;

import com.example.exception.config.UserExistException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName TestController
 * @Description
 * @create 2019/8/21/0021 15:36
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@RestController
@RequestMapping(value = "/exception")
public class TestController {


    @RequestMapping(value = "/1/{id}")
    public void get(@PathVariable(value = "id")String id) {
//        throw new RuntimeException("手动抛出报错");
        throw  new UserExistException(id);
    }



}
