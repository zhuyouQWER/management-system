package com.zhj.controller;

import com.zhj.model.Jurisdiction;
import com.zhj.model.User;
import com.zhj.model.Users;
import com.zhj.service.UserService;
import com.zhj.util.ParamUtil;
import com.zhj.util.TreeUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("LoginUser")
    @ResponseBody
    public String LoginUser(User user, HttpServletRequest request){
       User u = userService.LoginUser(user);
       if (u == null){
          return  "1";
       }else if(u.getAccountstatus()==2){
           return  "2";

       }else {
           request.getSession().setAttribute("user",u);
           return "3";
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
    public Map QueryUser(@RequestBody ParamUtil param){
        return userService.QueryUser(param);
     }

     //公众号新增，修改
     @RequestMapping("AddUser")
     @ResponseBody
    public void AddUser(Users u){
        if(u.getId()==null){
            userService.AddUser(u);
            userService.Update(u.getId());
        }else{
            userService.UpdateUser(u);
        }

     }
     //公众号查一条回显
     @RequestMapping("Query")
     @ResponseBody
    public List<Users> Query(Integer id) {
         List<Users> list = userService.Query(id);
         return list;

     }

     //用户信息展示
  @RequestMapping("Login")
    @ResponseBody
    public List<Users> Login(Integer id){
        return  userService.Login(id);
  }


  //公众号登陆
  @RequestMapping("LoginUsers")
    @ResponseBody
    public String LoginUsers(Users users,HttpServletRequest request){
        Users users1=userService.LoginUsers(users);
       if(users1==null){
         return "1";
       }else if(users1.getAccountstatus()==2){
         return "2";
       }else {
           request.getSession().setAttribute("users",users1);
           return "3";
       }
  }
  //查询后台用户
    @RequestMapping("Users")
    @ResponseBody
    public Map Users(@RequestBody ParamUtil param){
     return  userService.Users(param);
    }
   //后台用户新增,修改
    @RequestMapping("add")
    @ResponseBody
    public void add(User u){
        if (u.getId()==null){
            userService.add(u);
        }else {
            userService.update(u);
        }

    }
    //后台用户删除
    @RequestMapping("delete")
    @ResponseBody
    public void delete(Integer id){
         userService.delete(id);
    }
    //公众号用户删除
    @RequestMapping("Delete")
    @ResponseBody
    public void Delete(Integer id){
         userService.Delete(id);
    }
    //公众号用户批量删除
    @RequestMapping("BatchDelete")
    @ResponseBody
    public  void BatchDelete(String [] id){
     userService.BatchDelete(id);
    }
    //后台角色查询
    @RequestMapping("QueryRole")
    @ResponseBody
    public Map QueryRole(@RequestBody ParamUtil param){
    return  userService.QueryRole(param);
    }
    
}
