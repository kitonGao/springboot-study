package com.example.shiro.config;

import com.example.shiro.dao.UserMapper;
import com.example.shiro.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName MyRealm
 * @Description
 * @create 2019/8/23/0023 15:38
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
//public class MyRealm extends AuthenticatingRealm{
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        return null;
//    }
//
//
//}

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    /**
     * 认证(登录)
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /*获取用户输入的用户名和密码*/
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        System.out.format("用户名：{} 认证-----ShiroRealm.doGetAuthenticationInfo", userName);

        /*通过用户去数据库中查询用户的信息*/
        User user = userMapper.findByUserName(userName);
        if (StringUtils.isEmpty(user)) {
            throw new UnknownAccountException("用户名或密码错误");
        }
        if (!password.equals(user)) {
            throw new IncorrectCredentialsException("用户名或密码错误");
        }
        if (user.getStatus().equals("0")) {
            throw new LockedAccountException("账户已被锁定，请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }


    /**
     * 授权(获取用户角色和权限)
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
