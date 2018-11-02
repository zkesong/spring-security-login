package com.zks.spring.security.login.service.impl;

import com.zks.spring.security.login.components.consts.ResponseCode;
import com.zks.spring.security.login.dao.sc.StudentDtoMapper;
import com.zks.spring.security.login.model.dto.StudentDto;
import com.zks.spring.security.login.model.vo.Response;
import com.zks.spring.security.login.model.vo.UserInfo;
import com.zks.spring.security.login.security.UserAuth;
import com.zks.spring.security.login.service.UserService;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/27.
 */
public class UserServiceImpl implements UserService{

    private StudentDtoMapper studentDtoMapper;

    @Override
    public List<GrantedAuthority> getAuthoritiesByUsername(String username) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(username == null){
            return authorities;
        }
        if(username.startsWith("z")){
            authorities.add(new SimpleGrantedAuthority("ROLE_LOW"));
        }
        if(username.startsWith("l")){
            authorities.add(new SimpleGrantedAuthority("ROLE_HIGH"));
        }
        return authorities;
    }

    @Override
    public User getUserByUsername(String username) {
        if("".equals(username)){
            throw new AuthenticationServiceException("username must not be ''");
        }
        List<GrantedAuthority> authorities = getAuthoritiesByUsername(username);
        User user = new User(username, "", authorities);
        if("zks".equals(username)){
            user = new User("zks", "123", authorities);
        }
        if("lzj".equals(username)){
            user = new User("lzj", "456", authorities);
        }
        return user;
    }

    @Override
    public Response<UserInfo> getUserInfoByUsername(String username) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        StudentDto studentDto = studentDtoMapper.getByUsername(username);
        if(studentDto == null){
            return new Response<>(userInfo, "抱歉，暂无此用户信息", ResponseCode.NOT_FOUND);
        }
        userInfo.setGrade(studentDto.getGrade());
        userInfo.setCls(studentDto.getCls());
        userInfo.setIdentity(UserAuth.identities(studentDto.getAuthorties()));
        return new Response<>(userInfo, "ok", ResponseCode.OK);
    }

    public void setStudentDtoMapper(StudentDtoMapper studentDtoMapper) {
        this.studentDtoMapper = studentDtoMapper;
    }
}
