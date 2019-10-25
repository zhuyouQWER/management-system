package com.zhj.service;

import com.zhj.model.Jurisdiction;
import com.zhj.model.User;
import com.zhj.model.Users;
import com.zhj.util.ParamUtil;

import java.util.List;
import java.util.Map;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 9:22
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
public interface UserService {

    void Update(Integer id);

    List<Jurisdiction> Tree(Integer id);

    User LoginUser(User user);

    void AddUser(Users u);

    List<Users> Query(Integer id);

    void UpdateUser(Users u);

    List<Users> Login(Integer id);

    Users LoginUsers(Users users);

    Map QueryUser(ParamUtil param);

    Map Users(ParamUtil param);

    void add(User u);

    void update(User u);

    void delete(Integer id);

    void Delete(Integer id);

    void BatchDelete(String[] id);

    Map QueryRole(ParamUtil param);
}
