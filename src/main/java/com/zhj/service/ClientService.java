package com.zhj.service;

import com.zhj.model.*;
import com.zhj.util.ParamUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:30
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
public interface ClientService {
    void Add(Client c);

    void Update(Client c);

    void Delete(Integer id);

    void BatchDelete(String[] id);


    List<Deal> QueryUsers(String da);




    void AddDeclare(Declare declare,Integer id);

    Map Query(ParamUtil param);

    List<Users> Message(Integer id);

    List<Users> QueryPassword(Integer id);


    Users Password(String oldpassword, Integer id);

    void OldPassword(String password, Integer id);

    List<Deal> More(ParamUtil param,Integer id);

    Map DateTime();

    List<Deal> MoreAndMore(Integer id);

    List<Deal> History(Integer id);


    List<User> Trader();

    List<User> Salesman();

    List<User> Agent();
}
