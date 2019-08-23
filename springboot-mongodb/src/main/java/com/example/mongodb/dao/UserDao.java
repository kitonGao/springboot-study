package com.example.mongodb.dao;

import com.example.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName UserDao
 * @Description
 * @create 2019/8/22/0022 17:28
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Repository
public interface UserDao extends MongoRepository<User, String> {


    List<User> findByAgeBetween(Integer from, Integer to);


    List<User> findByAgeBetweenAndNameEqualsAndDesciptionIsLike(Integer from, Integer to, String name, String description);


}
