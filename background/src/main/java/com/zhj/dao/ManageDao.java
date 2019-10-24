package com.zhj.dao;

import com.zhj.model.Declare;

/**
 * @author ： 朱友
 * @date ：Created in 2019/10/22 11:51
 * @description：
 * @package ：com.zhj.dao
 * @version:
 */
public interface ManageDao {
    void Add(Declare d);

    void Update(Declare d);

    void Delete(Integer id);
}
