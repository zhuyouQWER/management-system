package com.zhj.service;

import com.zhj.dao.ClientDao;
import com.zhj.model.*;
import com.zhj.util.LikeUtil;
import com.zhj.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    public void BatchDelete(String[] id) {
        clientDao.BatchDelete(id);
    }

    @Override
    public List<Deal> QueryUsers(String da,Integer id) {
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM");
        ParsePosition pos = new ParsePosition(0);
        Date parse = sim.parse(da, pos);
        String format = sim.format(parse);
        String s = LikeUtil.LikeCha(format);
        return clientDao.QueryUsers(s,id);
    }



    @Override
    public void AddDeclare(Declare declare,Integer id) {
         if (declare.getComparison()==1){
           declare.setLastmonth(declare.getType());
             Date da=new Date();
             SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
             String time=sim.format(da);
             declare.setDeclaretime(time);
             declare.setStatus(3);
             declare.setUsersid(id);
           clientDao.AddDeclare(declare);
         }else{
            declare.setSamemoth(declare.getType());
             Date da=new Date();
             SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
             String time=sim.format(da);
            declare.setDeclaretime(time);
            declare.setStatus(3);
             declare.setUsersid(id);
            clientDao.AddDeclar(declare);
         }

    }

    @Override
    public Map Query(ParamUtil param) {
        Integer total=clientDao.Total(param);
        Integer page=(param.getPage()-1)*param.getSize();
        String s = LikeUtil.LikeCha(param.getFirm());
        param.setFirm(s);
        List<Client> users=clientDao.Query(page,param.getSize(),param);
        for (Client c:users){
            if(c.getRegion()==null){

            }
        }
        Map ma=new HashMap();
        ma.put("total",total);
        ma.put("data",users);
        return ma;
    }

    @Override
    public List<Users> Message(Integer id) {

        return clientDao.Message(id);
    }

    @Override
    public List<Users> QueryPassword(Integer id) {
        return clientDao.QueryPassword(id);
    }

    @Override
    public Users Password(String oldpassword, Integer id) {
        return clientDao.Password(oldpassword,id);
    }

    @Override
    public void OldPassword(String password, Integer id) {
        clientDao.OldPassword(password,id);
    }

    @Override
    public List<Deal> More(ParamUtil param,Integer id) {
        SimpleDateFormat sim=new SimpleDateFormat("yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date parse = sim.parse(param.getYear(), pos);
        String format = sim.format(parse);
        String s = LikeUtil.LikeCha(format);
        param.setYear(s);
        return clientDao.More(param,id);
    }

    @Override
    public Map DateTime() {
         String da=clientDao.da();
        String time=clientDao.time();
        String date=clientDao.date();
        String tim=clientDao.tim();
        Map ma=new HashMap();
        ma.put("sbstatartime",da);
        ma.put("sbendtime",time);
        ma.put("ydstatartime",date);
        ma.put("ydendtime",tim);
        return ma;
    }

    @Override
    public List<Deal> MoreAndMore(Integer id) {
        return clientDao.MoreAndMore(id);
    }

    @Override
    public List<Deal> History(Integer id) {
        return clientDao.History(id);
    }

    @Override
    public List<User> Trader() {
        return clientDao.Trader();
    }

    @Override
    public List<User> Salesman() {
        return clientDao.Salesman();
    }

    @Override
    public List<User> Agent() {
        return clientDao.Agent();
    }

    @Override
    public List<Client> QueryClient(Integer id) {
        return clientDao.QueryClient(id);
    }

    @Override
    public List<Region> Linkage() {
        return clientDao.Linkage();
    }

    public int queryRegionIdByName(Region region){
        int i = clientDao.queryRegionIdByName(region);
        return i;
    }

    public int saveClinet(Client client) {
        int i = clientDao.saveClient(client);
        return i;
    }
}
