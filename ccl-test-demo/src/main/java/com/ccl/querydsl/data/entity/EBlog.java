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
 * EBlog is a Querydsl bean type
 */
@Label("Blog")
public class EBlog extends AbstractIdEntity<Integer> {

    public EBlog() {
    }

    @Label("content")
    @NotNull(groups={CreateCheck.class, UpdateCheck.class})
    @Size(max=16777215)
    private String content;

    @Label("id")
    @NotNull(groups={UpdateCheck.class})
    private Integer id;

    @Label("title")
    @NotNull(groups={CreateCheck.class, UpdateCheck.class})
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
    public void setDefaultValue() {
    }

    @Override
    public String toString() {
         return String.format("EBlog { content : %s,id : %s,title : %s }",content,id,title);
    }

}

