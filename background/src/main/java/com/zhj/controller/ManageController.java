package com.zhj.controller;

import com.zhj.model.Declare;
import com.zhj.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:49
 * @description：
 * @package ：com.zhj.controller
 * @version:
 */
@Controller
@RequestMapping("Manage")
public class ManageController {
    @Autowired
    private ManageService manageService;
    //申报记录新增,修改
    @RequestMapping("Add")
    @ResponseBody
    public void Add(Declare d){
        if(d.getId()==null ){
            manageService.Add(d);
        }else{
            manageService.Update(d);
        }
    }
    //申报记录删除
    @RequestMapping("Delete")
    @ResponseBody
    public void Delete(Integer id){
   manageService.Delete(id);
    }

}
