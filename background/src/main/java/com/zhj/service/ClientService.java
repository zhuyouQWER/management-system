package com.zhj.service;

import com.zhj.model.Client;
import com.zhj.util.ParamUtil;

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

    void BaseDelete(String[] id);


}
