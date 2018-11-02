package com.zks.spring.security.login.security;

import com.zks.spring.security.login.service.UserService;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Administrator on 2018/10/27.
 */
public class UserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private UserService userService;

    private UserDetailsAuthenticationChecker checker;

    protected final UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken token)
            throws AuthenticationException {
        System.out.println("retrieve user...");
        return userService.getUserByUsername(username);
    }

    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken token)
            throws AuthenticationException {
        System.out.println("additionalAuthenticationChecks");
        if(!checker.check(userDetails, (String) token.getCredentials())){
            throw new AuthenticationServiceException("username or password invalid");
        }
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setChecker(UserDetailsAuthenticationChecker checker) {
        this.checker = checker;
    }
}
