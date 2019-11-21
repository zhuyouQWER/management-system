package com.zhj.dao;

import com.zhj.model.Declare;
import com.zhj.model.Users;
import com.zhj.util.ParamUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:51
 * @description：
 * @package ：com.zhj.dao
 * @version:
 */
public interface ManageDao {
    void Add(Declare d);

    void Update(Declare d);

    void Delete(Integer id);

    Integer Total(ParamUtil param);

    List<Declare> Query(@Param("page") Integer page, @Param("rows") Integer rows,@Param("p") ParamUtil param);

    void BatchDelete(String[] id);

    List<Declare> query();

    void add(Declare declare);

    void update(Declare d);

    void Status(String[] id);

    void status(String[] id);

    void statu(String[] id);

    List<Users> QueryUsers();

    List<Declare> QueryDeclare(Integer id);

    Integer queryRegionIdByName(String calculate);

    void saveDeclare(Declare declare);
}
