package com.xingxin.reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 反射----越过泛型检查
 *
 * 泛型只在编译时限制。。。
 *
 * @author liuxh
 * @date 2021/9/12
 */
public class ReflexTest4 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.forEach(System.out::println);

        Method method = list.getClass().getDeclaredMethod("add", Object.class);
        method.invoke(list, 1);
        for (Object o : list) {
            System.out.println(o);
        }

        // java8 遍历时会报错
        list.forEach(System.out::println);

    }
}
