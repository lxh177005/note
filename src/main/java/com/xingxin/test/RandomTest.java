package com.xingxin.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author liuxh
 * @date 2021/10/29
 */
public class RandomTest {
    public static void main(String[] args) {
        double random = Math.random();

        List<Integer> red = new ArrayList<>(6);
        Random rand = new Random();
        while (red.size() < 6) {
            int nextInt = rand.nextInt(32) + 1;
            if (!red.contains(nextInt)) {
                red.add(nextInt);
            }
        }
        List<Integer> result = red.stream().sorted().collect(Collectors.toList());
        result.add(rand.nextInt(16) + 1);
        result.forEach( r -> System.out.print(r + " "));

        System.out.println("===================");
        for (int i = 0; i < 10; i++) {
            int r = rand.nextInt(2) + 2;
            System.out.println(i +  ": r = " + r);
        }

    }
}
