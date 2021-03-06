package com.xhy.shoppingsystem.controller;


import com.xhy.shoppingsystem.pojo.Item;
import com.xhy.shoppingsystem.pojo.SoldRecord;
import com.xhy.shoppingsystem.pojo.User;
import com.xhy.shoppingsystem.service.ItemService;
import com.xhy.shoppingsystem.service.RecordService;
import com.xhy.shoppingsystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashMap;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;
    @Autowired
    private RecordService recordService;
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
            session.setAttribute("user", u);
            resultMap.put("status", "success");
            resultMap.put("type", u.getUserType() == 0 ? "/manage" : "/index");
        } else {
            resultMap.put("status", "failure");
            resultMap.put("type", "null");
        }
        return resultMap;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
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

    /**
     * 购买的后端接口
     *
     * @param record  　前段传来的购买相关信息
     * @param session 　session用来获取当前执行购买的用户的信息
     * @return 返回是否购买成功
     */
    @ResponseBody
    @PostMapping("/buy")
    public boolean buy(@RequestBody SoldRecord record, HttpSession session) {
        Item item = itemService.selectItemById(record.getItemId());
        //if the stock < nums to by
        System.out.println("a buy request");
        int currentStock = item.getStock();
        if (currentStock < record.getSoldNum() || record.getSoldNum() <= 0) {
            System.out.println("less stock");
            return false;
        } else {
            item.setStock(currentStock - record.getSoldNum());
            item.setSold(item.getSold() + record.getSoldNum());
            itemService.updateItemsInRepository(item);
            itemService.updateItemSold(item);
            User user = (User) session.getAttribute("user");
            assert (user != null);
            record.setUserEmail(user.getUserEmail());
            record.setSoldTime(new Timestamp(System.currentTimeMillis()));
            recordService.addSoldRecord(record);
            System.out.println("success to by");
            return true;
        }
    }

}
