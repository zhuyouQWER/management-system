package com.zhj.controller;

import com.zhj.model.Client;
import com.zhj.model.User;
import com.zhj.service.ClientService;
import com.zhj.util.ParamUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:29
 * @description：
 * @package ：com.zhj.controller
 * @version:
 */
@Controller
@RequestMapping("Cilent")
public class CilentController {
    @Autowired
    private ClientService clientService;
    //客户列表查询

    //客户列表新增、修改
    @RequestMapping("Add")
    @ResponseBody
    public void Query(Client c){
        if(c.getId()==null){
       clientService.Add(c);
        }else{
       clientService.Update(c);
        }
    }

  //客户管理删除
    @RequestMapping("Delete")
    @ResponseBody
    public void Delete(Integer id){
      clientService.Delete(id);
    }
    //客户管理批删
    @RequestMapping("BatchDelete")
    @ResponseBody
    public void BatchDelete(String[] id) {
        clientService.BaseDelete(id);
    }



}
