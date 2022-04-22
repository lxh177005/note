package com.xingxin.service.impl;

import com.xingxin.dao.PersonMapper;
import com.xingxin.dao.UserMapper;
import com.xingxin.entity.Person;
import com.xingxin.entity.User;
import com.xingxin.service.TransactionalService;
import com.xingxin.service.UserService;
import com.xingxin.utils.SpringUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuxh
 * @date 2022/2/15
 */
@Service
public class TransactionalServiceImpl implements TransactionalService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PersonMapper personMapper;

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

    /**
     * 事务的传播机制
     * PROPAGATION_REQUIRED 默认的
     * 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。
     *
     * 注意：
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void requiredMain() {
        this.insert("TransactionalService,requiredMain");
        userService.required();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void required() {
        userService.insert("bbbb");
        userService.insertException();
    }
}
