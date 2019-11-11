package com.zhj.dao;

import com.zhj.model.*;
import com.zhj.util.ParamUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:31
 * @description：
 * @package ：com.zhj.dao
 * @version:
 */
public interface ClientDao {
    void Add(Client c);

    void Update(Client c);

    void Delete(Integer id);

    void BatchDelete(String[] id);

    List<Deal> QueryUsers(@Param("s") String s);

    Users Password(@Param("oldpassword") String oldpassword, @Param("id") Integer id);

    void AddDeclare( Declare declare);

    void AddDeclar(Declare declare);

    Integer Total(ParamUtil param);

    List<Client> Query(@Param("page") Integer page, @Param("size") Integer size,@Param("p")ParamUtil param);

    List<Users> Message(Integer id);

    List<Users> QueryPassword(Integer id);

    void OldPassword(@Param("password") String password,@Param("id") Integer id);

    List<Deal> More(@Param("p") ParamUtil param,@Param("id") Integer id);

    String da();

    String time();

    String date();

    String tim();

    List<Deal> MoreAndMore(Integer id);

    List<Deal> History(Integer id);


    List<User> Trader();

    List<User> Salesman();

    List<User> Agent();
}
