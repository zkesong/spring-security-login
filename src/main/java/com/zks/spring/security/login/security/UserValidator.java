package com.zks.spring.security.login.security;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/10/27.
 */
@Component
public class UserValidator {

    /**
     * 在此处验证
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public boolean validate(String username, String password) {
        if ("zks".equals(username) && "123456".equals(password)) {
            return true;
        }
        return false;
    }
}
