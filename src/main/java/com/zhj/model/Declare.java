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
    private  String declaretime; //申报日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date electrotime; //用电日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private  Date electrotimeho;//用电日期后面
    private  Integer electro; //申报电量
    private  Integer days; //当月正常生产天数
    private  String lastmonth; //同上月相比
    private  String samemoth; //同去年相同月相比
    private  String explai; //补充说明
    private  Integer status; //状态  1是已申报  2是未申报   3是未开始
    private  Integer usersid;//公众号用户id
    private  Integer comparison;//同上月相比和去年相比的状态  1是同上月相比2是和去年同月相比
    private  String  type;//同比上涨下降类型字段   1是增加15以上 2是增加5-15 3是持平 4是减少15以上  5是减少5-15
    private  String  name;//公众号名称(零时字段)
    private String calculate;//公众号账号(零时字段)
    private  String customername; //客户名称(零时字段)

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }
    public String getExplai() {
        return explai;
    }

    public void setExplai(String explai) {
        this.explai = explai;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getComparison() {
        return comparison;
    }

    public void setComparison(Integer comparison) {
        this.comparison = comparison;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeclaretime() {
        return declaretime;
    }

    public void setDeclaretime(String declaretime) {
        this.declaretime = declaretime;
    }

    public Date getElectrotime() {
        return electrotime;
    }

    public void setElectrotime(Date electrotime) {
        this.electrotime = electrotime;
    }

    public Date getElectrotimeho() {
        return electrotimeho;
    }

    public void setElectrotimeho(Date electrotimeho) {
        this.electrotimeho = electrotimeho;
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
        return explai;
    }

    public void setExplain(String explain) {
        this.explai = explain;
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


}
