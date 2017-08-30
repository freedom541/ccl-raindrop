package com.ccl.querydsl.data.action;

import com.ccl.rain.codegen.AbstractCrudModelActionFactory;
import org.springframework.validation.annotation.Validated;
import com.ccl.querydsl.data.model.Userb;
import com.ccl.querydsl.data.repository.UserbRepository;
import com.ccl.rain.codegen.DataAdminModule;
import org.springframework.beans.factory.annotation.Autowired;
import com.ccl.querydsl.data.entity.EUserb;
import com.ccl.rain.codegen.Label;
import org.springframework.stereotype.Controller;
import com.ccl.rain.codegen.ParentModule;

/**
 * UserbActionFactory is a Codegen action factory type
 */
@ParentModule(DataAdminModule.class)
@Label("Userb数据管理")
@Validated({})
@Controller("UserbDataAdmin")
public class UserbActionFactory extends AbstractCrudModelActionFactory<UserbRepository, Userb, EUserb, Integer> {

    @Autowired
    public UserbActionFactory(UserbRepository userbRepository) {
        super(userbRepository);
    }

}

