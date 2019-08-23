package com.example.redis.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName IUserService
 * @Description
 * @create 2019/8/21/0021 10:11
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@CacheConfig(cacheNames = "user")
@Repository
public interface IUserService {

    // 触发缓存琢出  allEntries为true的时候，移除所有缓存数据(非必须) beforeInvocation = true 会在方法调用前移除数据，默认为false(非必须)
    public void deleteUser(Integer id);
    @CacheEvict(key = "#p0", allEntries = true, beforeInvocation = true)


    @CachePut(key = "#p0.userno")  //更新缓存，而不会干扰方法的执行
    void updateUser();

    @Cacheable(key = "#p0")
    void queryAll();

}
