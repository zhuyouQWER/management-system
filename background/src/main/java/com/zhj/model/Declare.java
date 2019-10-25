package com.zhj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/23 9:14
 * @description：申报表
 * @package ：com.zhj.model
 * @version:
 */
public class Declare implements Serializable {
    private static final long serialVersionUID = -5034938057924838369L;
    private  Integer id; //主键
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date declaretime; //申报日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")// 处理从	后端到前端的时间
    private  Date electrotime; //用电日期
    private  Integer electro; //申报电量
    private  Integer days; //当月正常生产天数
    private  String lastmonth; //同上月相比
    private  String samemoth; //同去年相同月相比
    private  String explain; //补充说明
    private  Integer status; //状态  1是已申报  2是未申报   3是未开始
    private  Integer usersid;
    private  String  name;//公众号名称
    private String calculate;//公众号账号
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDeclaretime() {
        return declaretime;
    }

    public void setDeclaretime(Date declaretime) {
        this.declaretime = declaretime;
    }

    public Date getElectrotime() {
        return electrotime;
    }

    public void setElectrotime(Date electrotime) {
        this.electrotime = electrotime;
    }

    public Integer getElectro() {
        return electro;
    }

    public void setElectro(Integer electro) {
        this.electro = electro;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getLastmonth() {
        return lastmonth;
    }

    public void setLastmonth(String lastmonth) {
        this.lastmonth = lastmonth;
    }

    public String getSamemoth() {
        return samemoth;
    }

    public void setSamemoth(String samemoth) {
        this.samemoth = samemoth;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalculate() {
        return calculate;
    }

    public void setCalculate(String calculate) {
        this.calculate = calculate;
    }

    public Integer getUsersid() {
        return usersid;
    }

    public void setUsersid(Integer usersid) {
        this.usersid = usersid;
    }

    @Override
    public String toString() {
        return "Declare{" +
                "id=" + id +
                ", declaretime=" + declaretime +
                ", electrotime=" + electrotime +
                ", electro=" + electro +
                ", days=" + days +
                ", lastmonth='" + lastmonth + '\'' +
                ", samemoth='" + samemoth + '\'' +
                ", explain='" + explain + '\'' +
                ", status=" + status +
                ", usersid=" + usersid +
                ", name='" + name + '\'' +
                ", calculate='" + calculate + '\'' +
                '}';
    }
}
