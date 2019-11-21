package com.zhj.service;

import com.zhj.model.Client;
import com.zhj.model.Deal;
import com.zhj.util.ParamUtil;

import java.util.List;
import java.util.Map;

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

    void BatchDelete(String[] id);


    Map Query(ParamUtil param);

    int queryRegionIdByName(String customername);

    int queryClientByName(String region);

    void saveDeal(Deal deal);

    List<Deal> QueryDeal(Integer id);

    List<Client> QueryClient();
}
