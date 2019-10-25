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
    public User login(User user) {
        return userMapper.selectUserByEmail(user.getUserEmail());
    }

    @Override
    public boolean register(User user) {
        //用户存在就注册失败
        User u = userMapper.selectUserByEmail(user.getUserEmail());
        if (u == null) {
            user.setUserType(1);
            //用户不存在表示注册成功(这里默认主键不重复的时候就插入成功了,其实不应该这么写)
            userMapper.addUser(user);
            return true;
        }
        return false;
    }

}
