package com.xingxin.test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author liuxh
 * @date 2021/9/13
 */
public class GXTest {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().split("-")[0];
        System.out.println("uuid = " + uuid);


        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tom = now.plusDays(1);
        int i = tom.compareTo(now);
        System.out.println("i = " + i);
        long l = ChronoUnit.SECONDS.between(now, tom);
        System.out.println("l = " + l);

        System.out.println("true".equals(""));

        int a =199;
        System.out.println(a/100);


        ArrayList<Long> longs = new ArrayList<>();
        longs.add(1L);
        longs.add(2L);
        longs.add(3L);
        System.out.println("longs = " + longs);

        String collect = longs.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println("collect = " + collect);

        List<String> strings = longs.stream().map(String::valueOf).collect(Collectors.toList());
        String join = String.join(",", strings);
        System.out.println("join = " + join);

        String join1 = String.join(".", new ArrayList<>());
        System.out.println("join1 = " + join1);


    }
}
