package com.xhy.shoppingsystem.controller;


import com.xhy.shoppingsystem.pojo.Item;
import com.xhy.shoppingsystem.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;
    Logger logger = LoggerFactory.getLogger(ItemController.class);


    @ResponseBody
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ArrayList<Item> getAllItems() {
        return itemService.getAllItem();
    }


    @ResponseBody
    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArrayList<Item> getItemByName(@PathVariable String name) {
        return itemService.selectItemsByName(name);
    }

    @ResponseBody
    @PostMapping(value = "/add")
    boolean addItem(@RequestBody Item item) {
        item.setSold(0);
        System.out.println(item + "  add to db");
        return itemService.addItem(item);
    }


    @ResponseBody
    @PostMapping(value = "/get-id", produces = MediaType.APPLICATION_JSON_VALUE)
    Item getItem(@RequestBody Item item) {
        //取得 session里面的id，查询数据然后返回
        return itemService.selectItemById(item.getItemId());
    }


    @ResponseBody
    @PostMapping(value = "/delete")
    boolean deleteById(@RequestBody Item item) {

        return itemService.deleteItemById(item.getItemId());
    }

    @ResponseBody
    @PostMapping("/stock-modify")
    public Boolean modify(@RequestBody Item item) {//为啥不能直接将item传入？？？
        Item item1 = new Item();
        item1.setItemId(item.getItemId());
        item1.setStock(item.getStock());
        System.out.println(item.getItemId());
        System.out.println(item1);
        return itemService.updateItemsInRepository(item1);
    }


    /**
     * 此控制用于点击登录按钮后与index的中间转化层
     * 此方法用来加载所有商品类，以request属性值传递给index，便于index做进一步操作
     * @param request 请求
     *
     */
//    @GetMapping("/login&index")
//    public String login_index(HttpServletRequest request){
//        ArrayList<Item> allItem = itemService.getAllItem();
//        HttpSession session = request.getSession();
//        session.setAttribute("allItem",allItem);
//        return "redirect:/index";
//    }

    /**
     * 搜索商品表单处理（即点击搜索按钮后,在本页只显示符合搜索条件的商品）表单提交地址为：/search
     * @param email 搜索框输入的email
     * @param request 请求
     */
//    @PostMapping("/search")
//    public String search(@RequestBody String email, HttpServletRequest request){
//        ArrayList<Item> items = itemService.selectItemsByName(email);
//        HttpSession session = request.getSession();
//        session.setAttribute("items",items);
//        return "redirect:/index";
//    }
}
