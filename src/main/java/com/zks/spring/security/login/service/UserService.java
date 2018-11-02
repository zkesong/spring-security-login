package com.zks.spring.security.login.service;

import com.zks.spring.security.login.model.vo.Response;
import com.zks.spring.security.login.model.vo.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * Created by Administrator on 2018/10/27.
 */
public interface UserService {

    List<GrantedAuthority> getAuthoritiesByUsername(String username);

    User getUserByUsername(String username);

    Response<UserInfo> getUserInfoByUsername(String username);
}
