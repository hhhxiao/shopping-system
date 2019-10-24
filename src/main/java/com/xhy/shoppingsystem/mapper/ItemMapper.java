package com.xhy.shoppingsystem.mapper;


import com.xhy.shoppingsystem.pojo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface ItemMapper {
    ArrayList<Item> getAllItem();//获取所有库存商品
    ArrayList<Item> selectItemsByName(String name);//搜索商品
}
