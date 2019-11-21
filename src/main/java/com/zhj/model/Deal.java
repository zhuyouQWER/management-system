package com.zhj.model;

import java.io.Serializable;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/24 17:07
 * @description：电力交易结算表
 * @package ：com.zhj.model
 * @version:
 */
public class Deal implements Serializable {
    private static final long serialVersionUID = 1562364526537211258L;
    private Integer id;//主键
    private String balancedate;//结算日期
    private Integer customerid;//客户关联id
    private double electric;//交易电量
    private double practical;//实际交易电量
    private double power;//偏差电量
    private double deviationratio;//偏差率
    private double assess;//考核执行偏差
    private double deviation;//偏差考核费用
    private double userfees;//用户偏差考核费用
    private double companyexpense;//代理公司考核费用
    private double discount;//优惠金额
    private double totaldiscount;//合计优惠金额
    private String remake;//备注
    private  double bias;//允许偏差电量
    private  Integer area;//地区关联id
    private  Integer declareid;//申报id
    private  String electro;//申报电量(零时字段)
    private  Integer userid;//公众号用户id(零时字段)
    private  String  customername;//客户名称(零时字段)
    private  String region;//地区;

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDeclareid() {
        return declareid;
    }

    public void setDeclareid(Integer declareid) {
        this.declareid = declareid;
    }

    public String getElectro() {
        return electro;
    }

    public void setElectro(String electro) {
        this.electro = electro;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBalancedate() {
        return balancedate;
    }

    public void setBalancedate(String balancedate) {
        this.balancedate = balancedate;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public double getElectric() {
        return electric;
    }

    public void setElectric(double electric) {
        this.electric = electric;
    }

    public double getPractical() {
        return practical;
    }

    public void setPractical(double practical) {
        this.practical = practical;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getDeviationratio() {
        return deviationratio;
    }

    public void setDeviationratio(double deviationratio) {
        this.deviationratio = deviationratio;
    }

    public double getAssess() {
        return assess;
    }

    public void setAssess(double assess) {
        this.assess = assess;
    }

    public double getDeviation() {
        return deviation;
    }

    public void setDeviation(double deviation) {
        this.deviation = deviation;
    }

    public double getUserfees() {
        return userfees;
    }

    public void setUserfees(double userfees) {
        this.userfees = userfees;
    }

    public double getCompanyexpense() {
        return companyexpense;
    }

    public void setCompanyexpense(double companyexpense) {
        this.companyexpense = companyexpense;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotaldiscount() {
        return totaldiscount;
    }

    public void setTotaldiscount(double totaldiscount) {
        this.totaldiscount = totaldiscount;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }


}
