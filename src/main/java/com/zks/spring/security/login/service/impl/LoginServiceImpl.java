package com.zks.spring.security.login.service.impl;

import com.zks.spring.security.login.constants.ErrorCode;
import com.zks.spring.security.login.dto.User;
import com.zks.spring.security.login.security.UserDetailsImpl;
import com.zks.spring.security.login.security.UserValidator;
import com.zks.spring.security.login.service.LoginService;
import com.zks.spring.security.login.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/27.
 */
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserValidator userValidator;

    @Override
    public Response<UserDetails> login(String username, String password) {
        if(!userValidator.validate(username, password)){
           return new Response<>(null, "登录信息错误！", ErrorCode.NOT_FOUND);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        UserDetails userDetails = new UserDetailsImpl(username, password, authorities);
        return new Response<>(userDetails, "登录成功!", ErrorCode.OK);
    }
}
