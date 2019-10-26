package com.xhy.shoppingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    //请求页面
    @GetMapping("/id/{id}")
    String item_info(@PathVariable Integer id, HttpSession session) {
        //把id信息暂存到session里面
        //请求数据的时候去查询
        //避免一次查询
        session.setAttribute("id", id);
        return "item_info";
    }

    @GetMapping("/manage")
    public String manage() {
        return "manage";
    }

}
