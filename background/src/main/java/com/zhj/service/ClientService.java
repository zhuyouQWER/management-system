package com.zhj.service;

import com.zhj.model.Client;

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

    void BaseDelete(String[] id);
}
