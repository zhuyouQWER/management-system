package com.zhj.service;

import com.zhj.dao.ManageDao;
import com.zhj.model.Declare;
import com.zhj.model.Users;
import com.zhj.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void Add(Declare declare) {

        if (declare.getComparison()==1){
            declare.setLastmonth(declare.getType());
            Date da=new Date();
            SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
            String time=sim.format(da);
            declare.setDeclaretime(time);
            if (declare.getStatus()==null){
                declare.setStatus(3);
            }else {
                manageDao.Add(declare);
            }


        }else{
            declare.setSamemoth(declare.getType());
            Date da=new Date();
            SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
            String time=sim.format(da);
            declare.setDeclaretime(time);
            if (declare.getStatus()==null){
                declare.setStatus(3);
            }else {
                manageDao.add(declare);
            }


        }
    }

    @Override
    public void Update(Declare d) {
        if (d.getComparison()==1){
            manageDao.update(d);
        }else{
            manageDao.Update(d);
        }

    }

    @Override
    public void Delete(Integer id) {
        manageDao.Delete(id);
    }

    @Override
    public Map Query(ParamUtil param) {
        Integer total=manageDao.Total(param);
        Integer page=(param.getPage()-1)*param.getSize();
        List<Declare> users=manageDao.Query(page,param.getSize(),param);
        Map ma=new HashMap();
        ma.put("total",total);
        ma.put("data",users);
        return ma;
    }

    @Override
    public void BatchDelete(String[] id) {
        manageDao.BatchDelete(id);
    }

    @Override
    public List<Declare> query() {
        return manageDao.query();
    }

    @Override
    public void Status(String[] id,Integer status) {
        if (status==1){
            manageDao.Status(id);
        }else if(status==2){
            manageDao.status(id);
        }else{
          manageDao.statu(id);
        }

    }

    @Override
    public List<Users> QueryUsers() {
        return manageDao.QueryUsers();
    }

    @Override
    public List<Declare> QueryDeclare(Integer id) {
        return manageDao.QueryDeclare(id);
    }

    @Override
    public Integer queryRegionIdByName(String calculate) {
        return manageDao.queryRegionIdByName(calculate);
    }

    @Override
    public void saveDeclare(Declare declare) {
        manageDao.saveDeclare(declare);
    }

}
