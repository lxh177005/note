package com.xingxin.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 并行流
 */
public class parallelStream {
    public static void main(String[] args) {
        List<Double> nums = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            double random = Math.random();
            nums.add(random);
        }
        long start = System.currentTimeMillis();
        nums.stream().sorted().collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        nums.parallelStream().sorted().collect(Collectors.toList());
        Long end2 = System.currentTimeMillis();
        System.out.println(end2-end);
    }
}
