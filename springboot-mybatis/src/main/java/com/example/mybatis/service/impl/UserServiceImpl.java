package com.example.mybatis.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.mybatis.entity.User;
import com.example.mybatis.service.UserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName UserServiceImpl
 * @Description
 * @create 2019/8/21/0021 17:21
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends BaseService<User> implements UserService{




}
