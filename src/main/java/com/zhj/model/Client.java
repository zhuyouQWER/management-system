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
    private  Integer province;//省份
    private  String customername; //客户名称
    private  Integer typeid; //用户类型id
    private  Integer traderid;//交易id
    private  Integer agentid;//代理商id
    private  Integer salesmanid;//销售id
    private  String typename;//类型名称(零时使用字段)
    private  String  name;//用户名称(零时使用字段)
    private  String  phone;//用户电话(零时使用字段)
    private  String  rolename;//角色名称(零时使用字段)

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

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }


}
