package com.zks.spring.security.login.model.dto;

import javax.persistence.*;
import java.util.List;

@Table(name = "tb_student")
public class StudentDto {
    private Integer id;

    private String name;

    private String password;

    private String grade;

    private String cls;

    private List<String> authorties;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public List<String> getAuthorties() {
        return authorties;
    }

    public void setAuthorities(List<String> authorties) {
        this.authorties = authorties;
    }
}