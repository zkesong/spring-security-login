package com.zks.spring.security.login.service;

import com.zks.spring.security.login.dto.User;
import com.zks.spring.security.login.vo.Response;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Administrator on 2018/10/27.
 */
public interface LoginService {

    Response<UserDetails> login(String username, String password);
}
