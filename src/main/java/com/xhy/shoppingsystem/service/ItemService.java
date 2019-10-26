package com.xhy.shoppingsystem.service;

import com.xhy.shoppingsystem.pojo.Item;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


public interface ItemService {
    ArrayList<Item> getAllItem();//获取所有库存商品
    ArrayList<Item> selectItemsByName(String name);//搜索商品
    boolean addItem(Item item);//管理员增加商品
    Item selectItemById(Integer id);//根据id查询物品
    boolean deleteItemById(Integer id);//管理员根据id删除商品
    void updateItemsInRepository(Item item);//更新仓库库存
}
