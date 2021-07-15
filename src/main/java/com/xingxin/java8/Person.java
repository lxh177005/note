package com.xingxin.java8;

//函数式接口：只能有一个未实现的抽象方法和多个默认实现了的方法
@FunctionalInterface
public interface Person {
    void say();
    default void hello(){
        System.out.println("hello java8");
    }
}
