package com.example.webflux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName ViewController
 * @Description
 * @create 2019/8/23/0023 14:25
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Controller
public class ViewController {

    @GetMapping("flux")
    public String flux(){
        return "flux";
    }

}
