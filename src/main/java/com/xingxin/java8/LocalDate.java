package com.xingxin.java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDate {
    public static void main(String[] args) {
        //获取本地日期
        LocalDate localDate = new LocalDate();
        System.out.println("localDate = " + localDate);

        //获取本地日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        //时间格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-HH-dd hh:mm:ss");
        String format = localDateTime.format(dtf);
        System.out.println("format = " + format);


    }
}
