package com.zhj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 17:59
 * @description：后台系统用户表
 * @package ：com.zhj.model
 * @version:
 */

public class User implements Serializable {
    private static final long serialVersionUID = 8281159851632066509L;
    private  Integer id;//主键
    private  String username; //用户名
    private  String phone;//电话
    private  String password;//密码
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date thistime;//本次登录时间
    private  Date  lasttime;//最后登录时间
    private  String  region;//登陆地址

    public Date getThistime() {
        return thistime;
    }

    public void setThistime(Date thistime) {
        this.thistime = thistime;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", thistime=" + thistime +
                ", lasttime=" + lasttime +
                ", region='" + region + '\'' +
                '}';
    }
}
