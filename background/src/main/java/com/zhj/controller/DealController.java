package com.zhj.controller;

import com.zhj.model.Deal;
import com.zhj.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/24 17:01
 * @description：
 * @package ：com.zhj.controller
 * @version:
 */
@Controller
@RequestMapping("Deal")
public class DealController {
    @Autowired
    private DealService dealService;
    //电力交易结算新增，删除
    @RequestMapping("Add")
    @ResponseBody
    public void Add(Deal d){
        if (d.getId()==null){
       dealService.Add(d);
        }else{
            dealService.Update(d);
        }
    }
    //力交易结算删除
    @RequestMapping("Delete")
    @ResponseBody
    public void Delete(Integer id){
        dealService.Delete(id);
    }

}
