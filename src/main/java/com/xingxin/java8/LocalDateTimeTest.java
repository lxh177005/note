package com.xingxin.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author liuxh
 * @date 2021/8/14
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        // 当前时间 2022-02-17T10:02:46
        LocalDateTime now = LocalDateTime.now().withNano(0);
        System.out.println("now = " + now);

        //时间格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now.format(dtf);
        System.out.println("format = " + format);
        // 字符串转LocalDate
        LocalDateTime localDateTime = LocalDateTime.parse(format, dtf);
        System.out.println("localDateTime = " + localDateTime);


        // 当前时间毫秒值
        long epochMilli = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("epochMilli = " + epochMilli);
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        // 毫秒值转日期
        LocalDateTime epochMilliLocalDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault());
        System.out.println("epochMilliLocalDateTime = " + epochMilliLocalDateTime);

        // 当月第一天第一秒 2022-02-01T00:00
        LocalDateTime firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN).withNano(0);
        System.out.println("firstDayOfMonth = " + firstDayOfMonth);
        // 当月最后一天最后一秒 2022-02-28T23:59:59
        LocalDateTime lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX).withNano(0);
        System.out.println("lastDayOfMonth = " + lastDayOfMonth);

        // 下个月第一天第一秒   2022-03-01T00:00
        LocalDateTime firstDayOfNextMonth = now.with(TemporalAdjusters.firstDayOfNextMonth()).with(LocalTime.MIN);
        System.out.println("firstDayOfNextMonth = " + firstDayOfNextMonth);
        // 下个月最后一天最后一秒 2022-03-31T23:59:59
        LocalDateTime lastDayOfNextMonth = firstDayOfNextMonth.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX).withNano(0);
        System.out.println("lastDayOfNextMonth = " +lastDayOfNextMonth);

        // dayOfWeek
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);
        System.out.println(dayOfWeek.toString());
        System.out.println(dayOfWeek.getValue());

        // dayOfMonth
        int dayOfMonth = now.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);
        int maxLength = now.getMonth().maxLength();
        System.out.println("maxLength = " + maxLength);

        // 加减几天后的时间
        LocalDateTime tomorrow = now.plusDays(1);
        System.out.println("tomorrow = " + tomorrow);
        LocalDateTime yesterday = now.plusDays(-1);
        System.out.println("yesterday = " + yesterday);

        // 日期比较
        boolean before = yesterday.isBefore(tomorrow);
        System.out.println("before = " + before);
        boolean after = tomorrow.isAfter(yesterday);
        System.out.println("after = " + after);


        LocalDate localDate20210202 = LocalDate.of(2021, 2, 2);
        System.out.println("localDate20210202 = " + localDate20210202);
    }
}
