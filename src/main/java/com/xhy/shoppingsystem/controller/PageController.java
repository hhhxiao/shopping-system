package com.xhy.shoppingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面controller
 * 返回静态的html
 * @author xhy
 */
@Controller
public class PageController {


    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
