package com.zhj.service;

import com.zhj.dao.DealDao;
import com.zhj.model.Client;
import com.zhj.model.Deal;
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
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date parse = sim.parse(d.getBalancedate(), pos);
        String format = sim.format(parse);
        d.setBalancedate(format);
        dealDao.Update(d);
    }

    @Override
    public void Delete(Integer id) {
        dealDao.Delete(id);
    }

    @Override
    public void BatchDelete(String[] id) {
        dealDao.BatchDelete(id);
    }

    @Override
    public Map Query(ParamUtil param) {
        Integer total=dealDao.Total(param);
        Integer page=(param.getPage()-1)*param.getSize();
        String s = LikeUtil.LikeCha(param.getCustomername());
        param.setCustomername(s);
       /* SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date parse = sim.parse(param.getDatetime(), pos);
        String format = sim.format(parse);
        param.setDatetime(format);*/
        List<Deal> users=dealDao.Query(page,param.getSize(),param);
        Map ma=new HashMap();
        ma.put("total",total);
        ma.put("data",users);
        return ma;
    }

    @Override
    public int queryRegionIdByName(String customername) {
        return dealDao.queryRegionIdByName(customername);
    }

    @Override
    public int queryClientByName(String region) {
        return dealDao.queryClientByName(region);
    }

    @Override
    public void saveDeal(Deal deal) {
        dealDao.saveDeal(deal);
    }

    @Override
    public List<Deal> QueryDeal(Integer id) {
        return dealDao.QueryDeal(id);
    }

    @Override
    public List<Client> QueryClient() {

        return dealDao.QueryClient();
    }
}
