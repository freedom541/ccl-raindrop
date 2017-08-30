package com.ccl.querydsl.data.model;

import javax.validation.constraints.Size;
import com.ccl.rain.codegen.Label;
import java.lang.String;
import javax.validation.constraints.NotNull;
import java.lang.Integer;
import com.ccl.rain.codegen.Domain;

import com.ccl.rain.codegen.AbstractDataModel;

import com.ccl.querydsl.data.entity.EBlog;

import com.ccl.rain.codegen.CreateCheck;

import com.ccl.rain.codegen.UpdateCheck;

/**
 * Blog is a Codegen model type
 */
@Label("Blog")
@Domain(domainClassName="com.ccl.querydsl.data.entity.EBlog")
public class Blog extends AbstractDataModel<EBlog, Integer> {

    @Label("content")
    @Size(max=16777215)
    private String content;

    @Label("id")
    private Integer id;

    @Label("title")
    @Size(max=200)
    private String title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
         return String.format("Blog { content : %s,id : %s,title : %s }",content,id,title);
    }

}

