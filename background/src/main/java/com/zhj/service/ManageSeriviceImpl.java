package com.zhj.service;

import com.zhj.dao.ManageDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
