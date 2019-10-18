package com.xhy.shoppingsystem.controller;

import com.xhy.shoppingsystem.pojo.User;
import com.xhy.shoppingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resources;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @ResponseBody
    @GetMapping("/queue")
    private User demo(Integer id) {
        return userService.queueUSerByID(id);
    }
}
