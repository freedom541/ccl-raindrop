package com.ccl.querydsl.data.action;

import com.ccl.rain.codegen.AbstractCrudModelActionFactory;
import org.springframework.validation.annotation.Validated;
import com.ccl.querydsl.data.repository.BlogRepository;
import com.ccl.rain.codegen.DataAdminModule;
import org.springframework.beans.factory.annotation.Autowired;
import com.ccl.querydsl.data.model.Blog;
import com.ccl.querydsl.data.entity.EBlog;
import com.ccl.rain.codegen.Label;
import org.springframework.stereotype.Controller;
import com.ccl.rain.codegen.ParentModule;

/**
 * BlogActionFactory is a Codegen action factory type
 */
@ParentModule(DataAdminModule.class)
@Label("Blog数据管理")
@Validated({})
@Controller("BlogDataAdmin")
public class BlogActionFactory extends AbstractCrudModelActionFactory<BlogRepository, Blog, EBlog, Integer> {

    @Autowired
    public BlogActionFactory(BlogRepository blogRepository) {
        super(blogRepository);
    }

}

