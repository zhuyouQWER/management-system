package com.zhj.controller;

import com.zhj.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:49
 * @description：
 * @package ：com.zhj.controller
 * @version:
 */
@Controller
@RequestMapping("Manage")
public class ManageController {
    @Autowired
    private ManageService manageService;
}
