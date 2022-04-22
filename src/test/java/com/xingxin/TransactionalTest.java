package com.xingxin;

import com.xingxin.service.TransactionalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuxh
 * @date 2021/6/28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@EnableAspectJAutoProxy(exposeProxy=true)
public class TransactionalTest {

    @Autowired
    private TransactionalService transactionalService;

    /**
     * required 默认传播机制 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。
     */
    @Test
    public void requiredTest() {
        transactionalService.required();
    }
    @Test
    public void requiredMainTest() {
        transactionalService.requiredMain();
    }

}
