package com.zhj.service;

import com.zhj.dao.UserDao;
import com.zhj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 9:23
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User QueryUser(User user) {

        return userDao.QueryUser(user);
    }

    @Override
    public void AddUser(User user) {
          userDao.AddUser(user);
    }

    @Override
    public void Add(String time) {
        userDao.Add(time);
    }
}
