package com.ccl.querydsl.data.action;

import com.ccl.rain.codegen.AbstractCrudModelActionFactory;
import com.ccl.querydsl.data.repository.UserRepository;
import org.springframework.validation.annotation.Validated;
import com.ccl.rain.codegen.DataAdminModule;
import org.springframework.beans.factory.annotation.Autowired;
import com.ccl.querydsl.data.entity.EUser;
import com.ccl.rain.codegen.Label;
import org.springframework.stereotype.Controller;
import com.ccl.querydsl.data.model.User;
import com.ccl.rain.codegen.ParentModule;

/**
 * UserActionFactory is a Codegen action factory type
 */
@ParentModule(DataAdminModule.class)
@Label("User数据管理")
@Validated({})
@Controller("UserDataAdmin")
public class UserActionFactory extends AbstractCrudModelActionFactory<UserRepository, User, EUser, Integer> {

    @Autowired
    public UserActionFactory(UserRepository userRepository) {
        super(userRepository);
    }

}

