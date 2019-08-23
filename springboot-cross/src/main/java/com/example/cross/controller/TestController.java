package com.example.cross.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br>
 * 〈跨域问题〉
 *
 * @author Administrator
 * @ClassName TestController
 * @Description
 * @create 2019/8/22/0022 11:13
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Controller
public class TestController {

    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }



    @ResponseBody
    @RequestMapping(value = "hello")
    @CrossOrigin(value = "*")
    public String hello(){
        return "hello";
    }


}
