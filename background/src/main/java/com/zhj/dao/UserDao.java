package com.zhj.dao;

import com.zhj.model.Jurisdiction;
import com.zhj.model.Role;
import com.zhj.model.User;
import com.zhj.model.Users;
import com.zhj.util.ParamUtil;
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
    

    void AddUser(Users u);

    List<Users> Query(Integer id);

    void UpdateUser(Users u);

    List<Users> Login(Integer id);

    Users LoginUsers(Users users);

    Integer Total(ParamUtil param);

    List<Users> QueryUser(@Param("page") Integer page, @Param("rows") Integer rows, @Param("p") ParamUtil param);

    Integer total(ParamUtil param);


    List<User> query(@Param("page") Integer page, @Param("rows") Integer rows, @Param("p") ParamUtil param);

    void add(User u);

    void update(User u);

    void delete(Integer id);

    void Delete(Integer id);

    void BatchDelete(String[] id);

    Integer rtotal(ParamUtil param);

    List<Role> QueryRole(@Param("page") Integer page, @Param("rows") Integer rows);
}