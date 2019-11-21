package com.zhj.model;

import java.io.Serializable;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/23 9:08
 * @description：客户表
 * @package ：com.zhj.model
 * @version:
 */
public class Client implements Serializable {
    private static final long serialVersionUID = -8796712011181718822L;
    private  Integer id; //主键
    private  Integer province;//省份id
    private  String customername; //客户名称
    private  Integer traderid;//交易id
    private  Integer agentid;//代理商id
    private  Integer salesmanid;//销售id
    private  Integer capitalid;//省关联id
    private  String  trader;//交易员名称(零时使用字段)
    private  String  traderphone;//交易员电话(零时使用字段)
    private  String salesman;//销售(零时使用字段)
    private  String salesmanphone;//销售电话(零时使用字段)
    private  String agent;//代理商(零时使用字段)
    private  String agentphone;//代理商电话(零时使用字段)
    private  String region;//省(零时使用字段)


    public Integer getCapitalid() {
        return capitalid;
    }

    public void setCapitalid(Integer capitalid) {
        this.capitalid = capitalid;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public String getTraderphone() {
        return traderphone;
    }

    public void setTraderphone(String traderphone) {
        this.traderphone = traderphone;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getSalesmanphone() {
        return salesmanphone;
    }

    public void setSalesmanphone(String salesmanphone) {
        this.salesmanphone = salesmanphone;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAgentphone() {
        return agentphone;
    }

    public void setAgentphone(String agentphone) {
        this.agentphone = agentphone;
    }

    public Integer getTraderid() {
        return traderid;
    }

    public void setTraderid(Integer traderid) {
        this.traderid = traderid;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public Integer getSalesmanid() {
        return salesmanid;
    }

    public void setSalesmanid(Integer salesmanid) {
        this.salesmanid = salesmanid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }


}
