package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName UserService
 * @Description
 * @create 2019/8/23/0023 14:57
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MongoTemplate template;


    public Flux<User> getUsers(){
        return userDao.findAll();
    }


    public Mono<User> getUser(String id) {
        return userDao.findById(id);
    }

    public Mono<User> createUser(User user) {
       return userDao.save(user);
    }

    public Mono<Void> deleteUser(String id){
        return  userDao.findById(id)
                .flatMap(user -> this.userDao.delete(user));

    }

    public Mono<User> updateUser(String id, User user){
        return this.userDao.findById(id)
                .flatMap(u -> {
                    u.setName(user.getName());
                    u.setAge(user.getAge());
                    u.setDescription(user.getDescription());
                    return this.userDao.save(u);
                });
    }



    public List<User> getUserByCondition(int size, int page, User user) {
        Query query = getQuery(user);
        Sort sort = new Sort(Sort.Direction.DESC, "age");
        Pageable pageable = PageRequest.of(page, size, sort);
        return template.find(query.with(pageable), User.class);

    }


    public long getUserByConditionCount(User user) {
        Query query = getQuery(user);
        return template.count(query, User.class);
    }



    private Query getQuery(User user) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        if (StringUtils.hasText(user.getName())) {
            criteria.and("name").is(user.getName());
        }
        query.addCriteria(criteria);
        return query;
    }


}
