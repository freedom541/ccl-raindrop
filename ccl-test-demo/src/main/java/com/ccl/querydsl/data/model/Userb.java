package com.ccl.querydsl.data.model;

import javax.validation.constraints.Size;
import org.joda.time.DateTime;
import com.ccl.rain.codegen.Label;
import java.lang.String;
import javax.validation.constraints.NotNull;
import java.lang.Integer;
import com.ccl.rain.codegen.Domain;

import com.ccl.rain.codegen.AbstractDataModel;

import com.ccl.querydsl.data.entity.EUserb;

import com.ccl.rain.codegen.CreateCheck;

import com.ccl.rain.codegen.UpdateCheck;

/**
 * Userb is a Codegen model type
 */
@Label("Userb")
@Domain(domainClassName="com.ccl.querydsl.data.entity.EUserb")
public class Userb extends AbstractDataModel<EUserb, Integer> {

    @Label("addr")
    @Size(max=128)
    private String addr;

    @Label("createTime")
    private DateTime createTime;

    @Label("id")
    private Integer id;

    @Label("userId")
    @Size(max=64)
    private String userId;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
         return String.format("Userb { addr : %s,createTime : %s,id : %s,userId : %s }",addr,createTime,id,userId);
    }

}

