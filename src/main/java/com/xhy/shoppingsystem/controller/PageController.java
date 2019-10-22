package com.xhy.shoppingsystem.controller;

import com.xhy.shoppingsystem.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;

/**
 * 页面controller
 * 返回静态的html
 *
 * @author xhy
 */
@Controller
public class PageController {


    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/item")
    public String item() {
        return "item_info";
    }

    @GetMapping("/manage")
    public String manage() {
        return "manage";
    }

}
