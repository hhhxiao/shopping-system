package com.xhy.shoppingsystem;

import com.xhy.shoppingsystem.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingSystemApplicationTests {


    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {

    }

}
