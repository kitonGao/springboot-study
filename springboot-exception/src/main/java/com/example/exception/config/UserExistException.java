package com.example.exception.config;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName UserExistException
 * @Description
 * @create 2019/8/21/0021 15:48
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
public class UserExistException extends RuntimeException {

    private static  final long serialVersionUID = -16843243423432L;

    private String id;

    public UserExistException(String id) {
        super("自定义错误 user 不存在");
        this.id = id;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
