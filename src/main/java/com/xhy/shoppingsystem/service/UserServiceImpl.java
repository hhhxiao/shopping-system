package com.xhy.shoppingsystem.service;

import com.xhy.shoppingsystem.mapper.UserMapper;
import com.xhy.shoppingsystem.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service("UserService")
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;


    @Override
    public User selectUserByEmailAndPassword(String email, String password) {
        return userMapper.selectUserByEmailAndPassword(email,password);
    }

    @Override
    public void registerPlainUser(String email, String password) {
        userMapper.registerPlainUser(email,password);
    }


}
