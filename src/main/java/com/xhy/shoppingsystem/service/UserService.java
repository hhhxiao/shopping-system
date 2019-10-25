package com.xhy.shoppingsystem.service;

import com.xhy.shoppingsystem.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
   // User selectUserByEmailAndPassword(@Param("email") String email,@Param("password") String password);//查询
    //void registerPlainUser(@Param("email") String email,@Param("password") String password);//注册
    User login(User user);
    boolean register(User user);
}
