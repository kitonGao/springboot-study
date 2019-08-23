package com.example.mongodb.controller;

import com.example.mongodb.entity.User;
import com.example.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName UserController
 * @Description
 * @create 2019/8/22/0022 17:34
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers(){
       return userService.getUsers();
    }


    @PostMapping
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(String id) {
        userService.deleteUser(id);
    }


    @PutMapping(value = "/{id}")
    public void updateUser(@PathVariable String id, User user) {
        userService.updateUser(id, user);
    }


    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable String id) {
       return userService.getUser(id).orElse(null);
    }




}
