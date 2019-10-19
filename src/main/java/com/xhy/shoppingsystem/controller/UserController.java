package com.xhy.shoppingsystem.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xhy.shoppingsystem.pojo.User;
import com.xhy.shoppingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resources;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    /*-----demo to delete-----*/
    @ResponseBody
    @GetMapping("/queue")
    private User demo(Integer id) {
        return userService.queueUSerByID(id);
    }

    @ResponseBody
    @PostMapping("/do_login")
    public Object do_login(@RequestBody User object, HttpSession session) {
        User result = userService.queueUSerByID(object.getUserId());
        System.out.println(result);
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
