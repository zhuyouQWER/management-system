package com.zhj.service;

import com.zhj.model.Deal;

/**
 * @author ： 朱友
 * @date ：Created in 2019/10/24 17:02
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
public interface DealService {
    void Add(Deal d);

    void Update(Deal d);

    void Delete(Integer id);
}
