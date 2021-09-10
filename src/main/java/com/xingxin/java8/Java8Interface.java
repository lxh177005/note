package com.xingxin.java8;

/**
 * 函数式接口：只能有一个未实现的抽象方法和多个默认实现了的方法
 */
@FunctionalInterface
public interface Java8Interface {

    void hello();

    default void defaultHello() {
        System.out.println("defaultHello");
    }

    static void staticHello() {
        System.out.println("staticHello");
    }

    /**
     * Object类中的方法可以在函数接口中重写
     * @return
     */
    @Override
    String toString();
}
