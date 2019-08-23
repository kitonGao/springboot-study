package com.example.mongodb.service;

import com.example.mongodb.dao.UserDao;
import com.example.mongodb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName UserService
 * @Description
 * @create 2019/8/22/0022 17:29
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Optional<User> getUser(String id){
      return userDao.findById(id);
    }

    public List<User> getUsers(){
        return userDao.findAll();
    }


    public void updateUser(String id, User user) {
        userDao.findById(id)
                .ifPresent(u -> {
                    u.setName(user.getName());
                    u.setDesciption(user.getDesciption());
                    u.setAge(user.getAge());
                    userDao.save(u);
                });
    }


    public User createUser(User user) {
        user.setId(null);
       return userDao.save(user);
    }


    public void deleteUser(String id){
        userDao.findById(id)
                .ifPresent(x -> {
                    userDao.delete(x);
                });
    }







}
