package com.controller;

import com.config.aop.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName TestController
 * @Description
 * @create 2019/8/21/0021 9:57
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@RestController
public class TestController {

    @Log("执行方法一")
    @GetMapping(value = "/one")
    public void methodOne(String name) {}


    @Log("执行方法二")
    @GetMapping(value = "/two")
    public void methodTwo() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Log("执行方法三")
    @GetMapping(value = "/three")
    public void methodThree(String name, String age) {}


}
