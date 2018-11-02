package com.zks.spring.security.login.dao.sc;

import com.zks.spring.security.login.model.dto.StudentDto;
import org.apache.ibatis.annotations.Param;

public interface StudentDtoMapper {

    StudentDto getByUsername(@Param("username") String username);
}