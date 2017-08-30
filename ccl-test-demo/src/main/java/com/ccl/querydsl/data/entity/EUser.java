package com.ccl.querydsl.data.entity;

import com.ccl.rain.codegen.AbstractIdEntity;

import com.ccl.rain.codegen.CreateCheck;

import com.ccl.rain.codegen.UpdateCheck;

import javax.validation.constraints.Size;
import com.ccl.rain.codegen.Label;
import java.lang.String;
import javax.validation.constraints.NotNull;
import java.lang.Integer;

/**
 * EUser is a Querydsl bean type
 */
@Label("User")
public class EUser extends AbstractIdEntity<Integer> {

    public EUser() {
    }

    @Label("id")
    @NotNull(groups={UpdateCheck.class})
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
    public void setDefaultValue() {
    }

    @Override
    public String toString() {
         return String.format("EUser { id : %s,name : %s }",id,name);
    }

}

