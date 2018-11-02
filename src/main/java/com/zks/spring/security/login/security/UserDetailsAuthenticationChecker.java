package com.zks.spring.security.login.security;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Administrator on 2018/10/30.
 */
public class UserDetailsAuthenticationChecker {
    /**
     * 在此处验证
     *
     * @param password 密码
     * @return
     */
    public boolean check(UserDetails user, String password) {
        System.out.println("checking...");
        if (!password.equals(user.getPassword())) {
            return false;
        }
        return true;
    }
}
