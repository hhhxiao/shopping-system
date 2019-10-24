package com.xhy.shoppingsystem.service;

import com.xhy.shoppingsystem.pojo.Item;

import java.util.ArrayList;

public interface ItemService {
    ArrayList<Item> getAllItem();//获取所有库存商品
    ArrayList<Item> selectItemsByName(String name);//搜索商品
}
