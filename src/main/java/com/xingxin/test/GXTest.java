package com.xingxin.test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

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

    }
}
