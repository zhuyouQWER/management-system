package com.zhj.service;

import com.zhj.dao.ClientDao;
import com.zhj.model.Client;
import com.zhj.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:30
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public void Add(Client c) {
       clientDao.Add(c);
    }

    @Override
    public void Update(Client c) {
      clientDao.Update(c);
    }

    @Override
    public void Delete(Integer id) {
        clientDao.Delete(id);
    }

    @Override
    public void BaseDelete(String[] id) {
      clientDao.BaseDelete(id);
    }



}
