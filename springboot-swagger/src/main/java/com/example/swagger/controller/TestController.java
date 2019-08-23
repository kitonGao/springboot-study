package com.example.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName TestController
 * @Description
 * @create 2019/8/21/0021 14:05
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Api
@Controller
@RequestMapping(value = "/test")
public class TestController {


    /*使用该注解忽略这个API；*/
    @ApiIgnore
    @GetMapping(value = "/hello")
    public @ResponseBody String hello(){
        return "hello";
    }

    @ApiOperation(value = "获取信息", notes = "根据ID获取所有的信息")
    @ApiImplicitParam(name = "id", value = "用户的ID", required = true, dataType = "Long", paramType = "path" )
    @GetMapping(value = "/{id}")
    public @ResponseBody String getMessage(@PathVariable(value = "id")  Long id){
        return id.toString();
    }






}
