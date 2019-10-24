package com.zhj.service;

import com.zhj.model.Declare;

/**
 * @author ： 朱友
 * @date ：Created in 2019/10/22 11:50
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
public interface ManageService {
    void Add(Declare d);

    void Update(Declare d);

    void Delete(Integer id);
}
