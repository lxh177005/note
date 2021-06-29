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
