package com.zhj.service;

import com.zhj.model.User;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 9:22
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
public interface UserService {
    User QueryUser(User user);

    void AddUser(User user);

    void Add(String time);
}
