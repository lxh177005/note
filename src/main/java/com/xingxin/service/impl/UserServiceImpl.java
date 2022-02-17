package com.xingxin.service.impl;

import com.xingxin.dao.UserMapper;
import com.xingxin.entity.User;
import com.xingxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuxh
 * @date 2022/2/15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(String name) {
        User user = new User();
        user.setName(name);
        userMapper.insert(user);
    }

    @Override
    public void insertException() {
        User user = new User();
        user.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void required() {
        this.insert("UserService, required()");
        this.insertException();
    }
}
