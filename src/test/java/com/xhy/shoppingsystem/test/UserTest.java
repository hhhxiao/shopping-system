package com.xhy.shoppingsystem.test;


import com.xhy.shoppingsystem.mapper.UserMapper;
import com.xhy.shoppingsystem.pojo.User;
import com.xhy.shoppingsystem.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    UserMapper  mapper;
    @Test
    public void selectUserByEmail(){
       User user = mapper.selectUserByEmail("hg@qq.com");
        System.out.println(user);
    }


    @Test
    public void addUser(){

        User user = new User();
        String email = "c@qq.com";
        user.setUserType(1);
        user.setUserEmail(email);
        user.setUserPassword("123456");
        User user2 = mapper.selectUserByEmail(email);
        if(user2 != null){
            System.out.println("user has existed!!!");
        }else {
             mapper.addUser(user);
            System.out.println("插入成功");
        }
    }



}
