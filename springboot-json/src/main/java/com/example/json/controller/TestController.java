package com.example.json.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName TestController
 * @Description
 * @create 2019/8/21/0021 11:15
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@RestController
public class TestController {

    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping(value = "/get")
    @ResponseBody
    public String serialization(){
        try {
            return "dddd";
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    @RequestMapping(value = "/get2")
    @ResponseBody
    public String serialization2(){
        Object o = new Object();
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("readjsonstring")
    @ResponseBody
    public String readJsonString() {
        try {
            String json = "{\"name\":\"mrbird\",\"age\":26}";
            JsonNode node = objectMapper.readTree(json);
            String name = node.get("name").asText();
            int age = node.get("age").asInt();


            String json2 = "{\"name\":\"mrbird\",\"hobby\":{\"first\":\"sleep\",\"second\":\"eat\"}}";;
            JsonNode node1 = objectMapper.readTree(json2);
            JsonNode hobby = node1.get("hobby");
            String first = hobby.get("first").asText();

            return name + " " + age;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
