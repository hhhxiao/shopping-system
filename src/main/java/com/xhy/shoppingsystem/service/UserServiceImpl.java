package com.xhy.shoppingsystem.service;

import com.xhy.shoppingsystem.mapper.UserMapper;
import com.xhy.shoppingsystem.pojo.Item;
import com.xhy.shoppingsystem.pojo.SoldRecord;
import com.xhy.shoppingsystem.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


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

    @Override
    public Set<Item> getAllItem() {
        return userMapper.getAllItem();
    }

    @Override
    public Set<Item> selectItemsByName(String name) {
        return userMapper.selectItemsByName(name);
    }

    @Override
    public Set<SoldRecord> getAllSoldRecord(String email) {
        return userMapper.getAllSoldRecord(email);
    }


}
