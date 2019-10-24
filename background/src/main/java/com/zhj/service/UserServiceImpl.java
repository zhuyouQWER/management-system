package com.zhj.service;

import com.zhj.dao.UserDao;
import com.zhj.model.Jurisdiction;
import com.zhj.model.User;
import com.zhj.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public void Update(Integer id) {
        Date da=new Date();
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sim.format(da);
        userDao.Update(id,time);

    }

    @Override
    public List<Jurisdiction> Tree(Integer id) {
        return userDao.Tree(id);
    }

    @Override
    public User LoginUser(User user) {
        return userDao.LoginUser(user);
    }

    @Override
    public Map QueryUser(Integer page, Integer rows, Users u) {
        Integer total=userDao.Total(u);

        return null;
    }

    @Override
    public void AddUser(Users u) {
        userDao.AddUser(u);
    }

    @Override
    public List<Users> Query(Integer id) {
        return userDao.Query(id);
    }

    @Override
    public void UpdateUser(Users u) {
        userDao.UpdateUser(u);
    }
}
