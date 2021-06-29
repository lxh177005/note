package com.xingxin;

import com.xingxin.entity.Cinema;
import com.xingxin.entity.Person;
import com.xingxin.service.TransactionalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuxh
 * @date 2021/6/28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionalServiceTest {

    @Autowired
    private TransactionalService transactionalService;

    @Test
    public void methodATest() {
        transactionalService.methodA();
    }
    @Test
    public void methodBTest() {
        transactionalService.methodB();
    }
}
