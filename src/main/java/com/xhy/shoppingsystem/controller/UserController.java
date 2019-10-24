package com.xhy.shoppingsystem.controller;

import com.xhy.shoppingsystem.pojo.User;
import com.xhy.shoppingsystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);


    /**
     * 登录服务
     * 成功返回true,把用户添加到session
     * 失败就直接返回false
     *
     * @param object  ajax传来的User对象
     * @param request request
     * @return 返回重定向路径
     */

    @PostMapping("/do_login")//登录表单提交地址
    public String do_login(@RequestBody User object, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            System.out.println("login success");
            return "redirect:/index";
        }
        User result = userService.selectUserByEmailAndPassword(object.getUserEmail(),object.getUserPassword());
        System.out.println("do_login:" + result);
        if (result == null) {
            System.out.println("login failure");
            return "redirect:/login";
        } else {
            System.out.println("login success");
            session.setAttribute("user",result);
            System.out.println("login failure");
            return "redirect:/index";
        }
    }

    /**
     * 注册（两次密码不同，需要在前端验证，到这意味着两次输入的密码一致）
     * @param object 注册的用户对象
     *
     *
     */
    @PostMapping("/do_register")//注册表单提交地址
    public String do_register(@RequestBody User object){
        String userEmail = object.getUserEmail();
        String userPassword = object.getUserPassword();
        userService.registerPlainUser(userEmail,userPassword);
        return "redirect:/login";
    }

    /**
     *
     *
     */
}
