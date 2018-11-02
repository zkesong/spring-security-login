package com.zks.spring.security.login.controller;

import com.zks.spring.security.login.model.vo.Response;
import com.zks.spring.security.login.model.vo.UserInfo;
import com.zks.spring.security.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/11/1.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public Response<UserInfo> getUserInfo(@RequestParam("name")String username){
        return userService.getUserInfoByUsername(username);
    }
}
