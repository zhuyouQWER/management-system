package com.zhj.controller;

import com.zhj.model.Declare;
import com.zhj.model.Users;
import com.zhj.service.ManageService;
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
import java.io.File;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    //申报记录查询
    @RequestMapping("Query")
    @ResponseBody
    public Map Query(@RequestBody ParamUtil param){
        return  manageService.Query(param);
    }
    //申报记录新增,修改
    @RequestMapping("Add")
    @ResponseBody
    public String Add(@RequestBody Declare d){
        if(d.getId()==null ){
            try {
                manageService.Add(d);
                return "1";
            } catch(Exception e){
                e.printStackTrace();
                return "2";
            }
        }else{
            try {
                manageService.Update(d);
                return "1";
            } catch(Exception e){
                e.printStackTrace();
                return "2";
            }
        }
    }
    //申报记录删除
    @RequestMapping("Delete")
    @ResponseBody
    public String Delete(Integer id){

        try {
            manageService.Delete(id);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }
    }
    //申报记录批量删除
    @RequestMapping("BatchDelete")
    @ResponseBody
    public String BatchDelete(String [] id){

        try {
            manageService.BatchDelete(id);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }

    }

    //导出excel方法 （数据库查询数据 使用封装工具类导出）
    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletResponse response, HttpServletRequest request){
        //导出的excel的标题
        String title = "申报记录";  //自定义
        //导出excel的自定义列名
        String[] rowName = {"序号","账号","姓名","电量申报日期","用电日期","申报电量(万千瓦时)","当月正常生产天数","跟上月同比","跟去年相同月同比","企业补充说明","状态"};
        //导出的excel数据  定义list集合
        List<Object[]>  dataList = new ArrayList<Object[]>();

        //查询的数据库的信息
       // Users u = (Users) request.getSession().getAttribute("users");
        List<Declare> list= manageService.query(); //查询

        //循环数据库查到的信息
        for(Declare c:list){
            Object[] obj =new Object[rowName.length];  //new 对象数组
            obj[1]=c.getCalculate();
            obj[2]=c.getName();
            obj[3]=c.getDeclaretime();
            SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
            String format = sim.format(c.getElectrotime());
            String format1 = sim.format(c.getElectrotimeho());
            obj[4]=format+"/"+format1;
            obj[5]=c.getElectro();
            obj[6]=c.getDays();
            if (c.getLastmonth()==null){
                obj[7]="";
            }else if(c.getLastmonth().equals("2")){
                obj[7]="增加5%-15%";
            }else if(c.getLastmonth().equals("3")){
                obj[7]="持平";
            }else if(c.getLastmonth().equals("4")){
                obj[7]="减少15%以上";
            }else if(c.getLastmonth().equals("5")){
                obj[7]="减少5%-15%";
            }else if(c.getLastmonth().equals("1")){
                obj[7]="增加15%以上";
            }


            if (c.getSamemoth()==null){
                obj[8]="";
            }else if(c.getSamemoth().equals("2")){
                obj[8]="增加5%-15%";
            }else if(c.getSamemoth().equals("3")){
                obj[8]="持平";
            }else if(c.getSamemoth().equals("4")){
                obj[8]="减少15%以上,";
            }else if(c.getSamemoth().equals("5")){
                obj[8]="减少5%-15%";
            }else if(c.getSamemoth().equals("1")){
                obj[8]="增加15%以上";
            }
           //obj[7]=c.getLastmonth();
           //obj[8]=c.getSamemoth();

            obj[9]=c.getExplain();
           // obj[10]=c.getStatus();
            if(c.getStatus()==null){
                obj[10]="";
            }else if(c.getStatus()==2){
                obj[10]="未申报";
            }else if(c.getStatus()==3){
                obj[10]="未开始";
            }else if(c.getStatus()==1){
                obj[10]="已申报";
            }

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

  //批量修改状态
    @RequestMapping("Status")
    @ResponseBody
    public String Status(String[] id,Integer status){
        try {
            manageService.Status(id,status);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }

    }
    //申报账户查询
    @RequestMapping("QueryUsers")
    @ResponseBody
    public  List<Users> QueryUsers(){
        List<Users> list=manageService.QueryUsers();
        return  list;
    }
  //申报查询一条
   @RequestMapping("QueryDeclare")
    @ResponseBody
    public List<Declare> QueryDeclare(Integer id) {
       List<Declare> list = manageService.QueryDeclare(id);
       return list;
   }
    //申报资料导入
    @RequestMapping("fileUpload")
    @ResponseBody
    public boolean fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        try {
            String path = request.getSession().getServletContext().getRealPath(File.separator + "upload" + File.separator + file.getOriginalFilename());
            File newFile = new File(path);
            if (newFile.getParentFile().exists() == false) {//判断上级目录是否是目录
                newFile.getParentFile().mkdirs();
            }
            if (newFile.exists()) {
                newFile.delete();
            }
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
            File f = new File(path);
            List<List<Object>> excleDataList = ReadExcel.readExcel(f);
            for (int i = 3; i < excleDataList.size(); i++) {

                Users users = new Users();
                users.setCalculate(excleDataList.get(i).get(1).toString());
                Integer i1 = manageService.queryRegionIdByName(users.getCalculate());

                Declare declare = new Declare();
                declare.setUsersid(i1);
                declare.setDeclaretime(excleDataList.get(i).get(3).toString());
                String s = excleDataList.get(i).get(4).toString();
                String[] a = s.split("/");
                SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
                ParsePosition pos = new ParsePosition(0);
                // String time = sim.format(a[0]);
                //   Date parse = sim.parse(time, pos);
                Date parse = sim.parse(a[0].toString(), pos);
                //  String time1 = sim.format(a[1]);
                // Date parse1 = sim.parse(time1, pos);
                Date parse1 = sim.parse(a[1].toString(), pos);
                declare.setElectrotime(parse);
                declare.setElectrotimeho(parse1);
                declare.setElectro(Integer.parseInt(excleDataList.get(i).get(5).toString()));
                declare.setDays(Integer.parseInt(excleDataList.get(i).get(6).toString()));
                declare.setLastmonth(excleDataList.get(i).get(7).toString());
                declare.setSamemoth(excleDataList.get(i).get(8).toString());
                declare.setExplai(excleDataList.get(i).get(9).toString());
                String s1 = excleDataList.get(i).get(10).toString();
                if (s1 == null) {
                    declare.setStatus(null);
                } else if (s1.equals("已申报")) {
                    declare.setStatus(1);
                } else if (s1.equals("未申报")) {
                    declare.setStatus(2);
                } else if (s1.equals("未开始")) {
                    declare.setStatus(3);
                }

                manageService.saveDeclare(declare);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("导入数据异常！");
        }
        return false;
    }
}
