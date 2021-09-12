package com.xingxin.reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 反射---操作私有方法
 *
 * @author liuxh
 * @date 2021/9/12
 */
public class ReflexTest3 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> reflexClass = Class.forName("com.xingxin.reflex.ReflexEntity");
        Object instance = reflexClass.newInstance();

        // 获取所有方法
        Method[] methods = reflexClass.getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);

        // 获取指定方法
        Method method = reflexClass.getDeclaredMethod("hello");
        // 如果该方法是私有的，记得设置权限
        method.setAccessible(true);
        Object invoke = method.invoke(instance);

        // 反射操作有参方法
        Method sumMethod = reflexClass.getDeclaredMethod("sum", Integer.class, Integer.class);
        sumMethod.setAccessible(true);
        Integer result = (Integer) sumMethod.invoke(instance, 1, 2);
        System.out.println("result = " + result);
    }
}
