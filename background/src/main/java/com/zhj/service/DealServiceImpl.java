package com.zhj.service;

import com.zhj.dao.DealDao;
import com.zhj.model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/24 17:02
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
@Service
public class DealServiceImpl implements DealService{
    @Autowired
    private DealDao dealDao;

    @Override
    public void Add(Deal d) {
        dealDao.Add(d);
    }

    @Override
    public void Update(Deal d) {
    dealDao.Update(d);
    }

    @Override
    public void Delete(Integer id) {
        dealDao.Delete(id);
    }
}
