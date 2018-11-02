package com.zks.spring.security.login.security;

import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/10/30.
 */
public class RamUserCache implements UserCache {

    private Map<String, UserDetails> cache = new ConcurrentHashMap<>(16);

    @Override
    public UserDetails getUserFromCache(String s) {
        return cache.get(s);
    }

    @Override
    public void putUserInCache(UserDetails userDetails) {
        cache.put(userDetails.getUsername(), userDetails);
    }

    @Override
    public void removeUserFromCache(String s) {
        cache.remove(s);
    }
}
