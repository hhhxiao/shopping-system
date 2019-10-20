package com.xhy.shoppingsystem.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xhy.shoppingsystem.pojo.User;
import com.xhy.shoppingsystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resources;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    /*-----demo to delete-----*/
    @ResponseBody
    @GetMapping("/queue")
    private User demo(Integer id) {
        return userService.queueUSerByID(id);
    }

    /**
     * 登录服务
     * 成功返回true,把用户添加到session
     * 失败就直接返回false
     * @param object ajax传来的User对象
     * @param session session
     * @return 返回是否登录成功
     */
    @ResponseBody
    @PostMapping("/do_login")
    public Object do_login(@RequestBody User object, HttpSession session) {
        User result = userService.queueUSerByID(object.getUserId());
        if (result == null) {
            return false;
        } else {
            if (result.getUserPassword().equals(object.getUserPassword())) {
                session.setAttribute("user", result);
                return true;
            }
        }
        return false;
    }
}
