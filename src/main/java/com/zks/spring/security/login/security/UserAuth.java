package com.zks.spring.security.login.security;

import java.util.List;

/**
 * Created by Administrator on 2018/11/1.
 */
public enum UserAuth {
    ROW_STUDENT("学生"),
    ROW_TEACHER("教师"),
    ROW_ADMIN("管理员");
    private String identity;

    UserAuth(String identity){
        this.identity = identity;
    }

    public static String identities(List<String> auths){
        StringBuilder builder = new StringBuilder("[");
        for (String auth : auths){
            builder.append(valueOf(auth).identity() + ",");
        }
        builder.replace(builder.length() - 1, builder.length(), "]");
        return builder.toString();
    }

    public String identity(){
        return identity;
    }

}
