package com.ccl.querydsl.data.model;

import javax.validation.constraints.Size;
import com.ccl.rain.codegen.Label;
import java.lang.String;
import javax.validation.constraints.NotNull;
import java.lang.Integer;
import com.ccl.rain.codegen.Domain;

import com.ccl.rain.codegen.AbstractDataModel;

import com.ccl.querydsl.data.entity.EUser;

import com.ccl.rain.codegen.CreateCheck;

import com.ccl.rain.codegen.UpdateCheck;

/**
 * User is a Codegen model type
 */
@Label("User")
@Domain(domainClassName="com.ccl.querydsl.data.entity.EUser")
public class User extends AbstractDataModel<EUser, Integer> {

    @Label("id")
    private Integer id;

    @Label("name")
    @Size(max=255)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
         return String.format("User { id : %s,name : %s }",id,name);
    }

}

