package com.xhy.shoppingsystem;


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
    UserService userService;

    @Test
    public void addUser(){
        userService.registerPlainUser("12@qq.com","3232");
    }



}
