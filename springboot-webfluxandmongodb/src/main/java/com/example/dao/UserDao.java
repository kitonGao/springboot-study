package com.example.dao;

import com.example.entity.User;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName UserDao
 * @Description
 * @create 2019/8/23/0023 14:55
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
//public interface UserDao extends MongoRepository<User, String>{    //这个是SpringBoot 集成mongodo 的时候需要继承的类
//现在ReactiveMongoRepository 提供的方法都是响应式的
public interface UserDao extends ReactiveMongoRepository<User, String> {



}
