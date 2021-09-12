package com.xingxin.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射--有参构造函数
 *
 * @author liuxh
 * @date 2021/9/12
 */
public class ReflexTest2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> entityClass = Class.forName("com.xingxin.reflex.ReflexEntity");
        Constructor<?> declaredConstructor = entityClass.getDeclaredConstructor(String.class, Integer.class);
        // 如果有参构造函数是私有的，那么需要设置权限即可
        declaredConstructor.setAccessible(true);
        ReflexEntity reflex = (ReflexEntity) declaredConstructor.newInstance("zhangsan", 2);
        System.out.println("reflex = " + reflex);
    }
}
