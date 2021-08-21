package com.xingxin.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

/**
 * @author liuxh
 * @date 2021/8/14
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().withNano(0);
        System.out.println("now = " + now);
        System.out.println(now.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX).withNano(0));
        LocalDateTime with = now.with(TemporalAdjusters.firstDayOfNextMonth()).with(LocalTime.MIN);
        System.out.println("with = " + with);
        System.out.println(with.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX).withNano(0));


        LocalDateTime beginTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX).withNano(0);

        System.out.println("beginTime = " + beginTime);
        System.out.println("endTime = " + endTime);

        DayOfWeek dayOfWeek = endTime.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);
        System.out.println(dayOfWeek.toString());
        System.out.println(dayOfWeek.getValue());

        int dayOfMonth = endTime.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);
        int dayOfMonth1 = beginTime.getDayOfMonth();
        System.out.println("dayOfMonth1 = " + dayOfMonth1);
        LocalDateTime tomorrow = beginTime.plusDays(1);
        System.out.println("tomorrow = " + tomorrow);

        int i = beginTime.getMonth().maxLength();
        System.out.println("i = " + i);

        LocalDate firstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate nextDay = firstDay.plusDays(1);
        int maxLength = firstDay.getMonth().maxLength();
        System.out.println("firstDay = " + firstDay);
        System.out.println("nextDay = " + nextDay);
        System.out.println("maxLength = " + maxLength);

        LocalDate of = LocalDate.of(2021, 2, 2);
        int i1 = of.getMonth().maxLength();
        System.out.println("i1 = " + i1);
        System.out.println("of = " + of);

        String s = beginTime.getMonth().getValue() + "/" + beginTime.getDayOfMonth();
        System.out.println("s = " + s);
        System.out.println(of.getMonth().getValue() + "/" +of.getDayOfMonth());
    }
}
