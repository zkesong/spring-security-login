package com.zks.spring.security.login.model.vo;

import com.alibaba.fastjson.annotation.JSONType;

/**
 * Created by Administrator on 2018/11/1.
 */
@JSONType
public class UserInfo {

    private String username;

    private String identity;

    private String grade;

    private String cls;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", identity='" + identity + '\'' +
                ", grade='" + grade + '\'' +
                ", cls='" + cls + '\'' +
                '}';
    }
}
