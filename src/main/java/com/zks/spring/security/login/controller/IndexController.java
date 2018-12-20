package com.zks.spring.security.login.controller;

import com.zks.spring.security.login.service.JmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/27.
 */
@Controller
public class IndexController {

    @Autowired
    private JmService jmService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        System.out.println("请求了首页。。。");
        return "index";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false)String error,  Object model){
        System.out.println("请求登录页。。。");
        if(null != error){
            return "loginFailed";
        }
        jmService.sendMessage(new Date() + " , 进行了登录操作");
        return "login";
    }
}
