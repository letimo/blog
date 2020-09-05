package com.irm.blog.service.impl;

import com.irm.blog.dao.UserMapper;
import com.irm.blog.pojo.User;
import com.irm.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sheldor
 * @date 2020/8/14 - 8:50
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String userName, String password) {
        return userMapper.getUserByUserNameAndPassword(userName, password);
    }
}
