package com.xingxin.service;

/**
 * @author liuxh
 * @date 2022/2/15
 */
public interface UserService {
    // 测试事务方法
    void insert(String name);
    void insertException();

    void required();
}
