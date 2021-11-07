package com.xingxin.java8;

import org.apache.commons.collections4.CollectionUtils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LocalDateTest {
    public static void main(String[] args) {
        //获取本地日期
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);

        //获取本地日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        //时间格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = localDateTime.format(dtf);
        System.out.println("format = " + format);

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM");
        String format1 = localDateTime.format(dtf1);
        System.out.println("format1 = " + format1);
        String format2 = dtf1.format(localDate);
        System.out.println("format2 = " + format2);
        LocalDate of = LocalDate.of(2021, 10, 1);
        System.out.println(of);

//        LocalDate parse1 = LocalDate.parse(format1, dtf1);
//        System.out.println("parse = " + parse1);

        String param = "2021-9";
        String[] date = param.split("-");
        LocalDate localDate1 = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), 1);
        // 待生效时间
        LocalDateTime nextLocalDateTime = LocalDateTime.of(localDate1, LocalTime.now());
        LocalDateTime beginTime =nextLocalDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        LocalDateTime endTime = nextLocalDateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX).withNano(0);



        System.out.println("beginTime = " + beginTime);
        System.out.println("endTime = " + endTime);

        System.out.println(beginTime.getYear() + "-" + beginTime.getMonthValue());

        int i = beginTime.compareTo(LocalDateTime.now().with(TemporalAdjusters.firstDayOfNextMonth()).with(LocalTime.MIN));
        System.out.println("i = " + i);

//        System.out.println(String.valueOf(null));
        System.out.println(String.valueOf(""));
        System.out.println(String.valueOf("123"));
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(String.valueOf(stringBuffer));

        String str = "{\"mchAppid\":\"wx4cadd7537c0251a0\",\"mchId\":\"10053801\",\"nonceStr\":\"1631005237840\",\"partnerTradeNo\":\"1435166103012904960\",\"paymentNo\":\"10100100538012109079533700676098\",\"paymentTime\":\"2021-09-07 17:00:38\",\"resultCode\":\"SUCCESS\",\"returnCode\":\"SUCCESS\",\"returnMsg\":\"\",\"xmlString\":\"<xml>\\n<return_code><![CDATA[SUCCESS]]></return_code>\\n<return_msg><![CDATA[]]></return_msg>\\n<mch_appid><![CDATA[wx4cadd7537c0251a0]]></mch_appid>\\n<mchid><![CDATA[10053801]]></mchid>\\n<nonce_str><![CDATA[1631005237840]]></nonce_str>\\n<result_code><![CDATA[SUCCESS]]></result_code>\\n<partner_trade_no><![CDATA[1435166103012904960]]></partner_trade_no>\\n<payment_no><![CDATA[10100100538012109079533700676098]]></payment_no>\\n<payment_time><![CDATA[2021-09-07 17:00:38]]></payment_time>\\n</xml>\"}";
        System.out.println("str = " + str.length());


    }
}
