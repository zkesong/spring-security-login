package com.zks.spring.security.login.security;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.core.SpringSecurityMessageSource;

import java.util.Locale;


/**
 * Created by Administrator on 2018/10/31.
 */
public class SecurityMessageSource extends ResourceBundleMessageSource {
    private SecurityMessageSource() {
        this.setBasename("com.zks.spring.security.login.security.messages");
    }

    public static MessageSourceAccessor getAccessor() {
        return new MessageSourceAccessor(new SecurityMessageSource());
    }

    public static void main(String[] args){
        System.out.println(getAccessor().getMessage("Authentication.usernameNotExists", Locale.CHINA));
    }
}
