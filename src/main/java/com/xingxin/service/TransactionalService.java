package com.xingxin.service;

/**
 * @author liuxh
 * @date 2022/2/15
 */
public interface TransactionalService {
    // 测试事务方法
    void insert(String name);
    void insertException();

    // 默认事务传播等级
    void requiredMain();
    void required();

}
