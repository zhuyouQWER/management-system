package com.zhj.dao;

import com.zhj.model.User;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 9:24
 * @description：
 * @package ：com.zhj.dao
 * @version:
 */
public interface UserDao {
    User QueryUser(User user);

    void AddUser(User user);

    void Add(String time);
}
