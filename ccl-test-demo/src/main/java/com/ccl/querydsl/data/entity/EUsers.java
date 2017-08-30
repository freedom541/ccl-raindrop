package com.ccl.querydsl.data.entity;

import com.ccl.rain.codegen.AbstractIdEntity;

import com.ccl.rain.codegen.CreateCheck;

import com.ccl.rain.codegen.UpdateCheck;

import javax.validation.constraints.Size;
import java.lang.Boolean;
import com.ccl.rain.codegen.Label;
import java.lang.String;
import javax.validation.constraints.NotNull;
import java.lang.Integer;

/**
 * EUsers is a Querydsl bean type
 */
@Label("Users")
public class EUsers extends AbstractIdEntity<Integer> {

    public EUsers() {
        this.available = true;
    }

    @Label("available")
    private Boolean available;

    @Label("email")
    @Size(max=45)
    private String email;

    @Label("gender")
    @Size(max=2)
    private String gender;

    @Label("id")
    @NotNull(groups={UpdateCheck.class})
    private Integer id;

    @Label("password")
    @NotNull(groups={CreateCheck.class, UpdateCheck.class})
    @Size(max=20)
    private String password;

    @Label("qq")
    @Size(max=15)
    private String qq;

    @Label("username")
    @NotNull(groups={CreateCheck.class, UpdateCheck.class})
    @Size(max=15)
    private String username;

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setDefaultValue() {
        if(null==available){
           this.available = true;
        }
    }

    @Override
    public String toString() {
         return String.format("EUsers { available : %s,email : %s,gender : %s,id : %s,password : %s,qq : %s,username : %s }",available,email,gender,id,password,qq,username);
    }

}

