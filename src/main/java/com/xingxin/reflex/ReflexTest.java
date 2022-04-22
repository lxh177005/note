package com.xingxin.reflex;

/**
 * 反射技术的实现方式
 * 默认执行---无参构造函数
 *
 * @author liuxh
 * @date 2021/9/12
 */
public class ReflexTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        // 反射获取类的信息，两种方式：
        // 1.通过class文件，反编译获取；
        Class<ReflexEntity> class1 = ReflexEntity.class;
        ReflexEntity reflexEntity = class1.newInstance();
        System.out.println("reflexEntity = " + reflexEntity);
        // 2.通过class.forName("xxx")获取。
        Class<?> class2 = Class.forName("com.xingxin.reflex.ReflexEntity");
        // 总结：两种方式获取的class文件是同一个。
        System.out.println(class1 == class2);
        // 3.
        ReflexEntity entity3 = new ReflexEntity();
        Class<? extends ReflexEntity> class3 = entity3.getClass();
        System.out.println(class1 == class3);


        reflexEntity.oldHello();

    }
}
