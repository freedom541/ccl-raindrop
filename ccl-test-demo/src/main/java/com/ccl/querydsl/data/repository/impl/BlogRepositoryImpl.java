package com.ccl.querydsl.data.repository.impl;

import com.ccl.rain.codegen.AbstractModelQueryAndBatchUpdateRepository;

import com.ccl.querydsl.data.entity.EBlog;

import com.ccl.querydsl.data.model.Blog;

import com.ccl.querydsl.data.repository.BlogRepository;

import org.springframework.validation.annotation.Validated;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.ccl.rain.codegen.Label;
import org.springframework.stereotype.Repository;

/**
 * BlogRepositoryImpl is a Querydsl repository implement type
 */
@Label("Blog存储实现")
@Validated({})
@Repository("blogRepository")
public class BlogRepositoryImpl extends AbstractModelQueryAndBatchUpdateRepository<EBlog, Integer, Blog> implements BlogRepository {

    @Autowired
    public BlogRepositoryImpl(DataSource dataSource) {
    	super(dataSource);
    }
    
}

