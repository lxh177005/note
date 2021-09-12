package com.xingxin.reflex;

import com.xingxin.annotation.XingxinName;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射----获取方法注解
 *
 * @author liuxh
 * @date 2021/9/12
 */
public class ReflexTest5 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.xingxin.reflex.ReflexEntity");
        Object instance = aClass.newInstance();

        Method helloMethod = aClass.getDeclaredMethod("hello");
        XingxinName xingxinName = helloMethod.getDeclaredAnnotation(XingxinName.class);
        System.out.println("xingxinName = " + xingxinName);

        Method oldHelloMethod = aClass.getDeclaredMethod("oldHello");
        XingxinName xingxinName1 = oldHelloMethod.getDeclaredAnnotation(XingxinName.class);
        System.out.println("xingxinName1 = " + xingxinName1);

    }
}
