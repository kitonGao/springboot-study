package com.example.shiro.dao;

import com.example.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName UserMapper
 * @Description
 * @create 2019/8/23/0023 15:53
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Mapper
public interface UserMapper {


    User findByUserName(String userName);




}
