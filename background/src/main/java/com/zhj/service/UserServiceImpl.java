package com.zhj.service;

import com.zhj.dao.UserDao;
import com.zhj.model.Jurisdiction;
import com.zhj.model.Role;
import com.zhj.model.User;
import com.zhj.model.Users;
import com.zhj.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

    @Override
    public List<Users> Login(Integer id) {
        return userDao.Login(id);
    }

    @Override
    public Users LoginUsers(Users users) {
        return userDao.LoginUsers(users);
    }

    @Override
    public Map QueryUser(ParamUtil param) {
        Integer total=userDao.Total(param);
        Integer page=(param.getPage()-1)*param.getRows();
        List<Users> users=userDao.QueryUser(page,param.getRows(),param);
        Map ma=new HashMap();
        ma.put("total",total);
        ma.put("rows",users);
        return ma;
    }

    @Override
    public Map Users(ParamUtil param) {
        Integer total=userDao.total(param);
        Integer page=(param.getPage()-1)*param.getRows();
        List<User> users=userDao.query(page,param.getRows(),param);
        Map ma=new HashMap();
        ma.put("total",total);
        ma.put("rows",users);
        return ma;
    }

    @Override
    public void add(User u) {
        userDao.add(u);
    }

    @Override
    public void update(User u) {
     userDao.update(u);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void Delete(Integer id) {
        userDao.Delete(id);
    }

    @Override
    public void BatchDelete(String[] id) {
        userDao.BatchDelete(id);
    }

    @Override
    public Map QueryRole(ParamUtil param) {
        Integer total=userDao.rtotal(param);
        Integer page=(param.getPage()-1)*param.getRows();
        List<Role> users=userDao.QueryRole(page,param.getRows());
        Map ma=new HashMap();
        ma.put("total",total);
        ma.put("rows",users);
        return ma;
    }
}
