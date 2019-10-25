package com.xhy.shoppingsystem.mapper;

import com.xhy.shoppingsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
  //  User selectUserByEmailAndPassword(@Param("email") String email,@Param("password") String password);//查询
   // void registerPlainUser(@Param("email") String email,@Param("password") String password);//注册
    User selectUserByEmail(String email);
    void addUser(User user);
}
