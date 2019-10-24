package com.zhj.service;

import com.zhj.dao.ManageDao;
import com.zhj.model.Declare;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:51
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
@Service
public class ManageSeriviceImpl implements ManageService {
    @Autowired
    private ManageDao manageDao;

    @Override
    public void Add(Declare d) {
        manageDao.Add(d);
    }

    @Override
    public void Update(Declare d) {
       manageDao.Update(d);
    }

    @Override
    public void Delete(Integer id) {
        manageDao.Delete(id);
    }

}
