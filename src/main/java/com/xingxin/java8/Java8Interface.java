package com.xingxin.java8;

import com.rabbitmq.client.UnblockedCallback;

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

class Java8InterfaceTest {
    public static void main(String[] args) {
        // java8之前
        Java8Interface old = new Java8Interface() {
            @Override
            public void hello() {
                System.out.println("java8Interface old hello");
            }
        };
        old.hello();
        old.defaultHello();
        Java8Interface.staticHello();
        String string = old.toString();
        System.out.println("string = " + string);

        // now
        System.out.println("now=================");
        Java8Interface now = () -> System.out.println("java8Interface now hello");
        now.hello();
        now.defaultHello();
        UnblockedCallback staticHello = Java8Interface::staticHello;
        System.out.println("staticHello = " + staticHello);

        // 线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        // lambda表达式写法
        new Thread( () -> System.out.println(Thread.currentThread().getName())).start();
    }
}


