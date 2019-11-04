package com.zhj.controller;

import com.zhj.model.*;
import com.zhj.service.UserService;
import com.zhj.util.ParamUtil;
import com.zhj.util.TreeUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hslf.record.Sound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
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
    public Map LoginUser(@RequestBody User user, HttpServletRequest request){
       User u = userService.LoginUser(user);
       Map map=new HashMap();
       if (u == null){
           map.put("success","用户名或密码错误");
           map.put("status","500");
           return map;

       }else if(u.getAccountstatus()==2){
           map.put("success","账号未启用");
           map.put("status","201");
           return map;
       }else {
           request.getSession().setAttribute("user",u);
           map.put("status","200");
           map.put("success","登录成功");
           return map;

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

     @RequestMapping("Query")
     @ResponseBody
    public List<Users> Query(Integer id) {
         List<Users> list = userService.Query(id);
         return list;

     }

     //后台用户信息展示
  @RequestMapping("Login")
  @ResponseBody
    public List<User> Login(HttpServletRequest request){
      User user = (User) request.getSession().getAttribute("user");
      return  userService.Login(user.getId());
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

  //公众号登陆
  @RequestMapping("LoginUsers")
  @ResponseBody
    public Map LoginUsers(Users users,HttpServletRequest request){
        Users users1=userService.LoginUsers(users);
        Map map=new HashMap();
       if(users1==null){
           map.put("success","用户名或密码错误");
           map.put("status","500");
         return map;
       }else if(users1.getStatus()==2){
           map.put("success","账号未启用");
           map.put("status","201");
         return map;
       }else {
           request.getSession().setAttribute("users",users1);
           map.put("status","200");
           map.put("success","登录成功");
           return map;
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
    //后台用户批删
    @RequestMapping("BatchDeleteUser")
    @ResponseBody
    public void BatchDeleteUser(String [] id){
        userService.BatchDeleteUser(id);
    }
    //后台角色查询
    @RequestMapping("QueryRole")
    @ResponseBody
    public Map QueryRole(@RequestBody ParamUtil param){
    return  userService.QueryRole(param);
    }
    //后台角色删除
  @RequestMapping("RoleDelete")
  @ResponseBody
  public void RoleDelete(Integer id){
        userService.RoleDelete(id);
  }
  //后台角色批删
    @RequestMapping("RoleBatchDelete")
    @ResponseBody
    public void RoleBatchDelete(String [] id){
         userService.RoleBatchDelete(id);
    }
//角色新增，删除
    @RequestMapping("AddRole")
    @ResponseBody
    public void AddRole(Role role){
        if (role.getId()==null){
            userService.AddRole(role);
        }else{
            userService.UpdateRole(role);
        }
    }
   //查询部门
  @RequestMapping("QueryDepartment")
  @ResponseBody
    public Map QueryDepartment(@RequestBody ParamUtil param){
      return   userService.QueryDepartment(param);

}
  //新增部门,修改部门
    @RequestMapping("AddDepartment")
    @ResponseBody
    public  void AddDepartment(Department department){
      if (department.getId()==null){
          userService.AddDepartment(department);
      }else{
          userService.UpdateDepartment(department);
      }
    }
    //删除部门
    @RequestMapping("DeleteDepartment")
    @ResponseBody
    public void DeleteDepartment(Integer id){
        userService.DeleteDepartment(id);
    }
    //批量删除部门
    @RequestMapping("BatchDeleteDepartment")
    @ResponseBody
   public void  BatchDeleteDepartment(String [] id) {
        userService.BatchDeleteDepartment(id);
    }
    
}
