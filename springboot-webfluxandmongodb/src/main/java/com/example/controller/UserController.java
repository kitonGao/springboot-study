package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName UserController
 * @Description
 * @create 2019/8/23/0023 15:07
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 以数组形式返回
     * @return
     */
    @GetMapping
    public Flux<User> getUsers(){
        return userService.getUsers();
    }


    /**
     * 以 Server sent events 形式返回数据
     * @return
     */
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getUserStream(){
        return userService.getUsers();
    }

    @PostMapping
    public Mono<User> createUser(User user){
       return userService.createUser(user);
    }


    /**
     * 存在返回200， 不存在返回404
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable String id) {
        return userService.deleteUser(id)
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                .defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

    /**
     * 存在返回修改后的User
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> updateUser(@PathVariable String id, User user) {
        return userService.updateUser(id, user)
                .map(u -> new ResponseEntity<User>(u, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<User>(HttpStatus.NOT_FOUND));
    }


    /**
     * 根据用户 id 查询
     * 存在返回，不存在返回404
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Mono<ResponseEntity<User>> getUser(@PathVariable String id) {
        return userService.getUser(id)
                .map(user -> new ResponseEntity<User>(HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<User>(HttpStatus.NOT_FOUND));
    }





}
