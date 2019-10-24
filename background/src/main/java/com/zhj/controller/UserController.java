package com.zhj.controller;

import com.zhj.model.Jurisdiction;
import com.zhj.model.User;
import com.zhj.model.Users;
import com.zhj.service.UserService;
import com.zhj.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    //后台登录
    @RequestMapping("LohginUser")
    @ResponseBody
    public String LoginUser(User user, HttpServletRequest request){
       User u = userService.LoginUser(user);
       if (u == null){
          return  "1";
       }else {
           userService.Update(u.getId());
           request.getSession().setAttribute("user",u);
           return "2";
       }
  }
   // 权限菜单查询
     @RequestMapping("Tree")
     @ResponseBody
    public List<Jurisdiction> Tree(HttpServletRequest request) {
         User user = (User) request.getSession().getAttribute("user");
         List<Jurisdiction> list = new ArrayList<Jurisdiction>();
         list = userService.Tree(user.getId());
         list = TreeUtil.getFatherNode(list);
         return list;
     }
     //公众号用户查询
     @RequestMapping("QueryUser")
     @ResponseBody
    public Map QueryUser(Integer page,Integer rows,Users u){
        return userService.QueryUser(page,rows,u);
     }
     //公众号新增，修改
     @RequestMapping("AddUser")
     @ResponseBody
    public void AddUser(Users u){
        if(u.getId()==null){
            userService.AddUser(u);
        }else{
            userService.UpdateUser(u);
        }

     }
     //公众号查一条回显
     @RequestMapping("Query")
     @ResponseBody
    public List<Users> Query(Integer id){
       List<Users> list=userService.Query(id);
        return list;
     }
      
}
