package com.zhj.controller;

import com.zhj.model.Client;
import com.zhj.model.Deal;
import com.zhj.model.Region;
import com.zhj.service.DealService;
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
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    //电力交易结算新增，修改
    @RequestMapping("Add")
    @ResponseBody
    public Deal Add(@RequestBody Deal d){


       if (d.getId()==null){
            try {
                dealService.Add(d);
                return  d;
            } catch(Exception e){
                e.printStackTrace();
                return  d;
            }

        }else{
            try {
                dealService.Update(d);
                return  d;
            } catch(Exception e){
                e.printStackTrace();
                return  d;
            }
        }

    }
    //电力交易结算删除
    @RequestMapping("Delete")
    @ResponseBody
    public String Delete(Integer id){

        try {
            dealService.Delete(id);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }
    }
    //电力交易结算批删
    @RequestMapping("BatchDelete")
    @ResponseBody
    public String BatchDelete(String [] id){
        try {
            dealService.BatchDelete(id);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }
    }
    //电力交易结算查询
    @RequestMapping("Query")
    @ResponseBody
    public Map Query(@RequestBody ParamUtil param){
        return  dealService.Query(param);
    }
    //结算资料导入
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

                Client client=new Client();
                client.setCustomername(excleDataList.get(i).get(1).toString());
                int i1 = dealService.queryRegionIdByName(client.getCustomername());
               Deal deal=new Deal();
                deal.setCustomerid(i1);
               /* SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
                ParsePosition pos = new ParsePosition(0);
                Date parse = sim.parse(, pos);*/
                deal.setBalancedate(excleDataList.get(i).get(0).toString());
                Region region=new Region();
                region.setRegion(excleDataList.get(i).get(2).toString());
                int i2=dealService.queryClientByName(region.getRegion());
                deal.setArea(i2);
                deal.setElectric(Double.parseDouble(excleDataList.get(i).get(3).toString()));
                deal.setPractical(Double.parseDouble(excleDataList.get(i).get(4).toString()));
                deal.setPower(Double.parseDouble(excleDataList.get(i).get(5).toString()));
                deal.setDeviationratio(Double.parseDouble(excleDataList.get(i).get(6).toString()));
                deal.setAssess(Double.parseDouble(excleDataList.get(i).get(7).toString()));
                deal.setDeviation(Double.parseDouble(excleDataList.get(i).get(8).toString()));
                deal.setBias(Double.parseDouble(excleDataList.get(i).get(9).toString()));
                deal.setUserfees(Double.parseDouble(excleDataList.get(i).get(10).toString()));
                deal.setCompanyexpense(Double.parseDouble(excleDataList.get(i).get(11).toString()));
                deal.setDiscount(Double.parseDouble(excleDataList.get(i).get(12).toString()));
                deal.setTotaldiscount(Double.parseDouble(excleDataList.get(i).get(13).toString()));
                deal.setRemake(excleDataList.get(i).get(14).toString());

                dealService.saveDeal(deal);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("导入数据异常！");
        }
        return   false;
    }
    //修改查询一条
    @RequestMapping("QueryDeal")
    @ResponseBody
    public List<Deal>QueryDeal(Integer id){
        return dealService.QueryDeal(id);
    }
  //查看客户
    @RequestMapping("QueryClient")
    @ResponseBody
    public  List<Client> QueryClient(){
        return  dealService.QueryClient();
    }

}
