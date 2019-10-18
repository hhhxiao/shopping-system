package com.xhy.shoppingsystem.service;

import com.xhy.shoppingsystem.mapper.UserMapper;
import com.xhy.shoppingsystem.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public User queueUSerByID(Integer id) {
        System.out.println(userMapper.queueUserByID(id));
        return this.userMapper.queueUserByID(id);
    }
}
