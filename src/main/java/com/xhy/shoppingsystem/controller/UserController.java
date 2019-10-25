package com.xhy.shoppingsystem.controller;

import com.xhy.shoppingsystem.pojo.User;
import com.xhy.shoppingsystem.service.UserService;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);


    /**
     * 登录
     *
     * @param user    用户
     * @param session session信息
     * @return 失败返回false 成功依据账户类型返回manager或者customer
     */
    @ResponseBody
    @PostMapping("/do_login")
    public HashMap<String, String> doLogin(@RequestBody User user, HttpSession session) {
        User u = userService.login(user);
        HashMap<String, String> resultMap = new HashMap<>();
        if (u != null && u.getUserPassword().equals(user.getUserPassword())) {
            resultMap.put("status", "success");
            resultMap.put("type", u.getUserType() == 0 ? "/manage" : "/index");
        } else {
            resultMap.put("status", "failure");
            resultMap.put("type", "null");
        }
        return resultMap;
    }

    /**
     * 注册
     *
     * @param user 用户信息
     * @return 成功返回true 失败返回false
     */
    @ResponseBody
    @PostMapping("/do_register")
    public boolean doRegister(@RequestBody User user) {
        return userService.register(user);
    }

//    @PostMapping("/do_login")//登录表单提交地址
//    public String do_login(@RequestBody User object, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        User user = (User)session.getAttribute("user");
//        if(user!=null){
//            System.out.println("login success");
//            return "redirect:/index";
//        }
//        User result = userService.selectUserByEmailAndPassword(object.getUserEmail(),object.getUserPassword());
//        System.out.println("do_login:" + result);
//        if (result == null) {
//            System.out.println("login failure");
//            return "redirect:/login";
//        } else {
//            System.out.println("login success");
//            session.setAttribute("user",result);
//            System.out.println("login failure");
//            return "redirect:/index";
//        }
//    }
//
//    /**
//     * 注册（两次密码不同，需要在前端验证，到这意味着两次输入的密码一致）
//     * @param object 注册的用户对象
//     *
//     *
//     */
//    @PostMapping("/do_register")//注册表单提交地址
//    public String do_register(@RequestBody User object){
//        String userEmail = object.getUserEmail();
//        String userPassword = object.getUserPassword();
//        userService.registerPlainUser(userEmail,userPassword);
//        return "redirect:/login";
//    }
}
