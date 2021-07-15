package com.xingxin.java8;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,234,546,23,5,11,1);
        list.stream()
                .map(item -> item * 10)
                .filter(item -> item > 40)
                .sorted((num1, num2) -> num1 - num2)
                .distinct()
//                .reduce((num1, num2) -> num1 + num2)
                .forEach( System.out::println);
    }
}
