package com.example.shiro.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈公共返回DTO〉
 *
 * @author Administrator
 * @ClassName ResponseVo
 * @Description
 * @create 2019/8/23/0023 16:27
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
public class ResponseVo extends HashMap<String, Object>{

    private static final long serialVersionUID = 1L;


    public ResponseVo (){
        put("code", 0);
        put("msg", "操作成功");
    }

    public static ResponseVo error(){
        return error(1, "操作失败");
    }

    public static ResponseVo error(String message) {
        return error(500, message);
    }

    public static ResponseVo error(int code, String msg){
        ResponseVo responseVo = new ResponseVo();
        responseVo.put("code", code);
        responseVo.put("msg", msg);
        return responseVo;
    }


    public static ResponseVo ok(String msg) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.put("msg", msg);
        return responseVo;
    }

    public static ResponseVo ok(Map<String, Object> map){
        ResponseVo responseVo = new ResponseVo();
        responseVo.putAll(map);
        return responseVo;
    }



    public static ResponseVo ok() {
        return new ResponseVo();
    }

    @Override
    public ResponseVo put(String key, Object value){
        super.put(key, value);
        return this;
    }



}
