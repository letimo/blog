package com.irm.blog.service;

import com.irm.blog.pojo.User;

/**
 * @author Sheldor
 * @date 2020/8/14 - 8:49
 */
public interface UserService {

    public User checkUser(String userName, String password);
}
