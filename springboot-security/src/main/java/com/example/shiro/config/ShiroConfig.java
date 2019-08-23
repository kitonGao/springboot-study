package com.example.shiro.config;


import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈shiro 配置类〉
 *
 * 用户认证分为：
 *  1.定义个shiroConfig，然后配置SecurityManager Bean, SecurityManager为shiro的安全管理器， 管理者所有subject
 *  2. 在shiroconfig中配置shiroFilterFactoryBean，其为shiro过滤工厂类，依赖于SecurityManager
 *  3.自定义Realm实现， Realm包含doGetAuthorizationInfo() 和 doGetAuthenticationInfo() 方法。
 *
 * @author Administrator
 * @ClassName ShiroConfig
 * @Description
 * @create 2019/8/23/0023 15:32
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Configuration
public class ShiroConfig {


    /**
     * TODO 过滤路径的时候是基于短路机制。
     *    /user/** = anon
     *    /user/aa =authc  永远不会执行
     * @param manager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean (SecurityManager manager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        /*设置securityManager*/
        shiroFilterFactoryBean.setSecurityManager((org.apache.shiro.mgt.SecurityManager) manager);
        /*登录URL*/
        shiroFilterFactoryBean.setLoginUrl("/login");
        /*登录成功后跳转的url*/
        shiroFilterFactoryBean.setSuccessUrl("/index");
        /*未授权的url*/
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        /*定义filterChain 静态资源不拦截*/
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/fonts/**","anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        /*druid数据源监控页面不拦截*/
        filterChainDefinitionMap.put("/druid","anon");
        /*配置退出过滤器，其中具体的退出代码Shiro已经实现了*/
        filterChainDefinitionMap.put("/logout","logout");
        filterChainDefinitionMap.put("/","anon");
        /*除了上面的url，其他的都必须通过认证才可以访问，未通过的认证自动访问LoginUrl*/
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }





    @Bean
    public SecurityManager securityManager (){
        /*配置SencurityManager 并注入ShiroRealm*/
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(shiroRealm());
        return manager;
    }

    private MyRealm shiroRealm() {
        /*配置Realm， 需自己实现*/
        MyRealm shiroRealm = new MyRealm();
        return shiroRealm;
    }

}
