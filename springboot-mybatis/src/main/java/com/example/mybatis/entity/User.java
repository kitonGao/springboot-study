package com.example.mybatis.entity;

import lombok.*;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName User
 * @Description
 * @create 2019/8/21/0021 17:17
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
public class User {

    private Long id;

    private String username;

    private String passwd;

    private Date createTime;

    private String status;



}
