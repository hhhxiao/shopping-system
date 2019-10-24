package com.xhy.shoppingsystem.controller;

import com.xhy.shoppingsystem.pojo.Item;
import com.xhy.shoppingsystem.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;
    Logger logger = LoggerFactory.getLogger(ItemController.class);

    /**
     * 此控制用于点击登录按钮后与index的中间转化层
     * 此方法用来加载所有商品类，以request属性值传递给index，便于index做进一步操作
     * @param request 请求
     *
     */
    @GetMapping("/login&index")
    public String login_index(HttpServletRequest request){
        ArrayList<Item> allItem = itemService.getAllItem();
        HttpSession session = request.getSession();
        session.setAttribute("allItem",allItem);
        return "redirect:/index";
    }

    /**
     * 搜索商品表单处理（即点击搜索按钮后,在本页只显示符合搜索条件的商品）表单提交地址为：/search
     * @param email 搜索框输入的email
     * @param request 请求
     */
    @PostMapping("/search")
    public String search(@RequestBody String email, HttpServletRequest request){
        ArrayList<Item> items = itemService.selectItemsByName(email);
        HttpSession session = request.getSession();
        session.setAttribute("items",items);
        return "redirect:/index";
    }
}
