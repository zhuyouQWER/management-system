package com.zhj.dao;

import com.zhj.model.Client;

/**
 * @author ： 朱友
 * @date ：Created in 2019/10/22 11:31
 * @description：
 * @package ：com.zhj.dao
 * @version:
 */
public interface ClientDao {
    void Add(Client c);

    void Update(Client c);

    void Delete(Integer id);

    void BaseDelete(String[] id);
}
