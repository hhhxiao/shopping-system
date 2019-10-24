package com.xhy.shoppingsystem.service;

import com.xhy.shoppingsystem.pojo.Item;
import com.xhy.shoppingsystem.pojo.SoldRecord;
import com.xhy.shoppingsystem.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface UserService {
    User selectUserByEmailAndPassword(@Param("email") String email,@Param("password") String password);//查询
    void registerPlainUser(@Param("email") String email,@Param("password") String password);//注册
    Set<Item> getAllItem();//获取所有库存商品
    Set<Item> selectItemsByName(String name);//搜索商品
    Set<SoldRecord> getAllSoldRecord(String email);//获取所有交易
}
