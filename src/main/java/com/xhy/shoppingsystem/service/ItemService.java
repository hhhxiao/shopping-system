package com.xhy.shoppingsystem.service;

import com.xhy.shoppingsystem.pojo.Item;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


public interface ItemService {
   // ArrayList<Item> getAllItem();//获取所有库存商品
    //ArrayList<Item> selectItemsByName(String name);//搜索商品
}
