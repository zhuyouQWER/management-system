package com.zhj.dao;

import com.zhj.model.Deal;

/**
 * @author ： 朱友
 * @date ：Created in 2019/10/24 17:03
 * @description：
 * @package ：com.zhj.dao
 * @version:
 */
public interface DealDao {
    void Add(Deal d);

    void Update(Deal d);

    void Delete(Integer id);
}
