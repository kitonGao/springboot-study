package com.example.shiro.controller;

import com.example.shiro.entity.User;
import com.example.shiro.utils.MD5Utils;
import com.example.shiro.vo.ResponseVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName UserController
 * @Description
 * @create 2019/8/23/0023 16:25
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Controller
public class UserController {

    @GetMapping(value = "/login")
    public ResponseVo login(String username, String password) {
        /*密码MD5加密*/
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        /*获取Subject 对象*/
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ResponseVo.ok();
        } catch (UnknownAccountException e) {
            return ResponseVo.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResponseVo.error(e.getMessage());
        } catch (LockedAccountException e) {
            return ResponseVo.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseVo.error("认证失败");
        }
    }


    @RequestMapping(value = "/")
    public String redirectIndex(){
        return "redirect:/index";
    }


    @RequestMapping(value = "/index")
    public String index(Model model) {
        /*登录成功后，即可通过Subject 获取登录的用户信息*/
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";

    }


}
