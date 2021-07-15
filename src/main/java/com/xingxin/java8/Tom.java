package com.xingxin.java8;

import java.util.function.Function;

public class Tom {

    public static void main(String[] args) {
        Person p = () -> System.out.println("hello say()");
        p.say();
        Person p1 = new Person() {
            @Override
            public void say() {
                System.out.println("匿名内部类");
            }
        };
        p1.say();

        Tom.tomSay(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "1111转化了";
            }
        },"jerry");
        //简写
        Tom.tomSay( (str) -> "2222转化了","jerry" );

    }

    //静态方法
    public static void tomSay(Function<String, String> function, String str) {
        String result = function.apply(str);
        System.out.println("result = " + result);
    }
}
