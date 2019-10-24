package com.zhj.dao;

import com.zhj.model.Jurisdiction;
import com.zhj.model.User;
import com.zhj.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 9:24
 * @description：
 * @package ：com.zhj.dao
 * @version:
 */
public interface UserDao {


    void Update(@Param("id") Integer id, @Param("time") String time);

    List<Jurisdiction> Tree(Integer id);

    User LoginUser(User user);


    Integer Total(Users u);

    void AddUser(Users u);

    List<Users> Query(Integer id);

    void UpdateUser(Users u);
}