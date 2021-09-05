package com.xingxin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * 枚举单例，不仅能避免多线程的同步问题，还能防止java反射和反序列化创建新的对象
 * @author liuxh
 * @date 2021/9/5
 */
@Getter
@AllArgsConstructor
public enum SingletonEnum {
    /**
     * 枚举单例
     */
    INSTANCE;

    public void hello() {
        System.out.println("hello");
    }
}
