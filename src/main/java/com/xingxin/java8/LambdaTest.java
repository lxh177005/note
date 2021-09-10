package com.xingxin.java8;

/**
 * lambda表达式好处：简化匿名内部类的调用
 * @author liuxh
 * @date 2021/9/10
 */
public class LambdaTest {
    public static void main(String[] args) {
        // 正常情况
        Java8Interface java8Interface = new Java8Interface() {
            @Override
            public void hello() {
                System.out.println("hello java8");
            }
        };
        java8Interface.hello();

        // lambda表达式写法
        Java8Interface java8Lambda = () -> System.out.println("hello lambda");
        java8Lambda.hello();

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
