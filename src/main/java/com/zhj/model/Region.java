package com.zhj.model;

import java.io.Serializable;

/**
 * @author ： 朱福
 * @date ：Created in 2019/11/13 17:04
 * @description：省表
 * @package ：com.zhj.model
 * @version:
 */
public class Region implements Serializable {
    private  Integer id;//主键
    private  String region;//地区名称



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
