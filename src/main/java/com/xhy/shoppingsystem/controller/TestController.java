package com.xhy.shoppingsystem.controller;

import com.xhy.shoppingsystem.pojo.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


/**
 * 用于测试前端的接口,写完后删除
 */
@Controller
@RequestMapping("/test")
public class TestController {


    @ResponseBody
    @GetMapping("/")
    public String test() {
        return "test pages";
    }


    @ResponseBody
    @GetMapping("/get-item")
    public ArrayList<Item> getItem() {
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Item item = new Item();
            item.setItemId(i);
            item.setItemName("测试商品" + i);
            item.setManufact("厂家" + i);
            item.setPrice(i * 1.0);
            item.setSold(i);
            item.setStock(100 - i);
            items.add(item);
        }
        return items;
    }

    @ResponseBody
    @PostMapping("/search")
    public ArrayList<Item> searchItem(@RequestBody Item item) {
        System.out.println(item.getItemName());
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Item it = new Item();
            it.setItemId(i * 2);
            it.setItemName("测试商品" + i);
            it.setManufact("厂家" + i);
            it.setPrice(i * 1.0);
            it.setSold(i);
            it.setStock(100 - i);
            items.add(it);
        }
        return items;
    }
}
