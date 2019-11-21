package com.zhj.controller;

import com.zhj.model.*;
import com.zhj.service.ClientService;
import com.zhj.util.ExportExcel;
import com.zhj.util.ParamUtil;
import com.zhj.util.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
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
@RequestMapping("Client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    //客户列表查询//
    @RequestMapping("Query")
    @ResponseBody
    public Map Query(@RequestBody ParamUtil param){
       return clientService.Query(param);
    }
    //客户列表新增、修改
    @RequestMapping("Add")
    @ResponseBody
    public String Query(@RequestBody Client c){
        System.out.println("=========="+c);
        if(c.getId()==null){
            try {
                clientService.Add(c);
                return "1";
            } catch(Exception e){
                e.printStackTrace();
                return "2";
            }
        }else{
            try {
                clientService.Update(c);
                return "1";
            } catch(Exception e){
                e.printStackTrace();
                return "2";
            }

        }
    }
  //客户管理删除
    @RequestMapping("Delete")
    @ResponseBody
    public String Delete(Integer id){

        try {
            clientService.Delete(id);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }
    }
    //客户管理批删
    @RequestMapping("BatchDelete")
    @ResponseBody
    public String BatchDelete(@RequestParam String[] id) {
        try {
            clientService.BatchDelete(id);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }

    }
    //公众号结算查询
    @RequestMapping("QueryUsers")
    @ResponseBody
    public List<Deal> QueryUsers(@RequestBody ParamUtil param,HttpSession session){
        Users users = (Users) session.getAttribute("users");
        return  clientService.QueryUsers(param.getTime(),users.getId());
    }
    //公众号修改密码
    @RequestMapping("Password")
    @ResponseBody
    public  String Password(@RequestBody ParamUtil param,HttpServletRequest request){
            Users users = (Users) request.getSession().getAttribute("users");

            Users  u=clientService.Password(param.getOldpassword(),users.getId());
             if (u==null){
               return "1";
             }else {
                 clientService.OldPassword(param.getPassword(),u.getId());
                 return "2";
             }



    }
    //导出excel方法 （数据库查询数据 使用封装工具类导出）
    @RequestMapping("exportExcel")
    public void exportExcel(String date,HttpServletResponse response,HttpSession session){
        System.out.println(date+"111111111111111111111");

        //导出的excel的标题
        String title = "电力结算优惠单";  //自定义
        //导出excel的自定义列名
        String[] rowName = {"序号","交易电量","实际用电量","偏差电量","偏差率","允许偏差电量(-2%、+6%)","考核执行偏差","偏差考核费用","用户偏差考核费用","代理售电公司考核费用","优惠金额","合计优惠金额","备注"};
        //导出的excel数据  定义list集合
        List<Object[]>  dataList = new ArrayList<Object[]>();
        Users users = (Users) session.getAttribute("users");
        //查询的数据库的信息
        List<Deal> list= clientService.QueryUsers(date,users.getId()); //查询

        //循环数据库查到的信息
        for(Deal c:list){
            Object[] obj =new Object[rowName.length];  //new 对象数组
            obj[1]=c.getElectric();
            obj[2]=c.getPractical();
            obj[3]=c.getPower();
            obj[4]=c.getDeviationratio();
            obj[5]=c.getBias();
            obj[6]=c.getAssess();
            obj[7]=c.getDeviation();
            obj[8]=c.getUserfees();
            obj[9]=c.getCompanyexpense();
            obj[10]=c.getDiscount();
            obj[11]=c.getTotaldiscount();
            obj[12]=c.getRemake();

            dataList.add(obj);  //将数组对象 放入定义的list里
        }

        //调用工具类ExportExcel  传入4个固定参数title,rowName,dataList,response  导出
        ExportExcel exportExcel =new ExportExcel(title,rowName,dataList,response);
        try {
            exportExcel.export();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
  //公众号电力申报新增
    @RequestMapping("AddDeclare")
    @ResponseBody
    public String AddDeclare(@RequestBody Declare declare,HttpSession session){
        try {
            Users users = (Users) session.getAttribute("users");
            clientService.AddDeclare(declare,users.getId());
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }
    }
    //公众号用户信息
    @RequestMapping("Message")
    @ResponseBody
    public List<Users> Message(HttpSession session){
        Users users = (Users) session.getAttribute("users");
        return clientService.Message(users.getId());

    }
  //密码查询
    @RequestMapping("QueryPassword")
    @ResponseBody
    public List<Users> QueryPassword(HttpSession session) {
        Users us = (Users) session.getAttribute("users");
        return clientService.QueryPassword(us.getId());
    }
    //历史更多查询
    @RequestMapping("More")
    @ResponseBody
    public  List<Deal> More(@RequestBody ParamUtil param,HttpSession Session){
        Users users = (Users) Session.getAttribute("users");
        return clientService.More(param,users.getId());
    }
    //最近2个小时
    @RequestMapping("MoreAndMore")
    @ResponseBody
    public  List<Deal> MoreAndMore(HttpSession Session){
        Users users = (Users) Session.getAttribute("users");
        return clientService.MoreAndMore(users.getId());
    }
    //历史更多
    @RequestMapping("History")
    @ResponseBody
     public  List<Deal> History(HttpSession Session){
        Users users = (Users) Session.getAttribute("users");
        return clientService.History(users.getId());
    }

    //公众号申报时间
    @RequestMapping("DateTime")
    @ResponseBody
    public Map DateTime() {
        return clientService.DateTime();
    }
    //交易员查询
    @RequestMapping("Trader")
    @ResponseBody
    public List<User> Trader(){
        List<User> list =clientService.Trader();
        return list;
    }
    //销售员查询
    @RequestMapping("Salesman")
    @ResponseBody
    public List<User> Salesman(){
        List<User> list =clientService.Salesman();
        return list;
    }
    //代理商查询
    @RequestMapping("Agent")
    @ResponseBody
    public List<User> Agent() {
        List<User> list = clientService.Agent();
        return list;
    }
    //客户查询一条
    @RequestMapping("QueryClient")
    @ResponseBody
    public List<Client> QueryClient(@RequestParam Integer id){

            List<Client> list=clientService.QueryClient(id);
            return list;
    }
   //省查询
    @RequestMapping("Linkage")
    @ResponseBody
    public List<Region> Linkage(){
        List<Region> list=clientService.Linkage();
        return  list;
    }
   //客户资料导入
    @RequestMapping("fileUpload")
    @ResponseBody
    public boolean  fileUpload(@RequestParam("file") CommonsMultipartFile file , HttpServletRequest request) throws IOException {
        try {
            String path =request.getSession().getServletContext().getRealPath(File.separator+"upload"+File.separator+file.getOriginalFilename());
            File newFile=new File(path);
            if(newFile.getParentFile().exists() == false){//判断上级目录是否是目录
                newFile.getParentFile().mkdirs();
            }
            if(newFile.exists()){
                newFile.delete();
            }
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
            File f = new File(path);
            List<List<Object>> excleDataList= ReadExcel.readExcel(f);
            for(int i=1;i<excleDataList.size();i++){

                Region region = new Region();
                region.setRegion(excleDataList.get(i).get(0).toString());
                int i1 = clientService.queryRegionIdByName(region);
                Client client = new Client();
                client.setCapitalid(i1);
                client.setCustomername(excleDataList.get(i).get(1).toString());
                int count = clientService.saveClinet(client);
                Users users=new Users();

            }
            return true;
        } catch (Exception e) {
              e.printStackTrace();
            System.out.println("导入数据异常！");
        }
        return   false;
        

    }

}
  