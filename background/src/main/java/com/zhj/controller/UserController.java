package com.zhj.controller;

import com.zhj.model.User;
import com.zhj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 9:17
 * @description：
 * @package ：com.zhj.controller
 * @version:
 */
@Controller
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("QueryUser")
    @ResponseBody
    public String QueryUser(User user, HttpServletRequest request){
       User u = userService.QueryUser(user);
       if (u == null){
          return  "1";
       }else {
           Date dd = new Date();
           //格式化
           SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           String time=sim.format(dd);
            userService.Add(time);
           request.getSession().setAttribute("user",u);
           return "2";
       }
  }
    @RequestMapping("AddUser")
    @ResponseBody
    public void AddUser(User user){
         userService.AddUser(user);
    }

}
