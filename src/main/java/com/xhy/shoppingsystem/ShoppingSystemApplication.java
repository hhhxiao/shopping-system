package com.xhy.shoppingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ShoppingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingSystemApplication.class, args);
    }

}
