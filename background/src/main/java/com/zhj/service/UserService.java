package com.zhj.service;

import com.zhj.model.Jurisdiction;
import com.zhj.model.User;
import com.zhj.model.Users;

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

    Map QueryUser(Integer page, Integer rows, Users u);

    void AddUser(Users u);

    List<Users> Query(Integer id);

    void UpdateUser(Users u);
}
