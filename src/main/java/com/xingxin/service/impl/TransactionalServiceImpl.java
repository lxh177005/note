package com.xingxin.service.impl;

import com.xingxin.dao.CinemaMapper;
import com.xingxin.dao.PersonMapper;
import com.xingxin.entity.Cinema;
import com.xingxin.entity.Person;
import com.xingxin.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuxh
 * @date 2021/6/28
 */
@Service
public class TransactionalServiceImpl implements TransactionalService {

    @Autowired
    private CinemaMapper cinemaMapper;

    @Autowired
    private PersonMapper personMapper;

    /**
     * 事务的传播机制 7种
     * PROPAGATION_REQUIRED
     * 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
     *
     * PROPAGATION_SUPPORTS
     * 支持当前事务，如果当前没有事务，就以非事务方式执行。
     *
     * PROPAGATION_MANDATORY
     * 使用当前的事务，如果当前没有事务，就抛出异常。
     *
     * PROPAGATION_REQUIRES_NEW
     * 新建事务，如果当前存在事务，把当前事务挂起。
     *
     * PROPAGATION_NOT_SUPPORTED
     * 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
     *
     * PROPAGATION_NEVER
     * 以非事务方式执行，如果当前存在事务，则抛出异常。
     *
     * PROPAGATION_NESTED
     * 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
     */

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    public void methodA() {
        cinemaMapper.insert(new Cinema(10, "iron man", "tony stark", 8.0f));

        methodB();
        throwNewRuntimeException();

    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NEVER)
    public void methodB() {
        personMapper.insert(new Person(10, "test@163.com"));
//        throwNewRuntimeException();
    }

    private void throwNewRuntimeException(){
        throw new RuntimeException("test Exception...");
    }
}
