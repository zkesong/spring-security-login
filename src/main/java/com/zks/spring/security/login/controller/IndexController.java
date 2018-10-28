package com.zks.spring.security.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/10/27.
 */
@Controller
public class IndexController {

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
        return "login";
    }
}
