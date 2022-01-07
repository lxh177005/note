package com.xingxin.java8;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTest {
    public static void main(String[] args) {

        // LocalDateTime dateTime = LocalDateTime.of(now.plusDays(-i), signNotifyTemplate.getSignSendTime().toLocalTime());
        // Date createTime = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

        LocalDate now1 = LocalDate.now();
        System.out.println("now1 = " + now1);
        LocalDate localDate2 = now1.plusDays(-1);
        System.out.println("localDate2 = " + localDate2);

        String state = "service_id_111";

        String service_id_ = StringUtils.substringAfter(state, "service_id_");
        System.out.println("service_id_ = " + Integer.parseInt(service_id_));

        String ss = "";
        String sss = null;
        String string = JSON.toJSONString(ss);
        System.out.println("string = " + string);
        String string1 = JSON.toJSONString(sss);
        System.out.println("string1 = " + string1);

        System.out.println("=====");


        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);
        boolean before = now.isBefore(tomorrow);
        System.out.println("before = " + before);
        boolean before1 = tomorrow.isBefore(now);
        System.out.println("before1 = " + before1);
        boolean after = now.isAfter(tomorrow);
        System.out.println("after = " + after);
        boolean after1 = tomorrow.isAfter(now);
        System.out.println("after1 = " + after1);


        LocalDateTime localDateTime1 = now.plusDays(10);
        long l = localDateTime1.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("l = " + l);
        long l1 = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("l1 = " + l1);

        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneId.systemDefault());
        System.out.println("localDateTime2 = " + localDateTime2);
        LocalDateTime localDateTime3 = LocalDateTime.ofInstant(Instant.ofEpochMilli(l1), ZoneId.systemDefault());
        System.out.println("localDateTime3 = " + localDateTime3);
        LocalDateTime l10 = LocalDateTime.ofInstant(Instant.ofEpochMilli(1640880000000L), ZoneId.systemDefault());
        System.out.println("l10 = " + l10);

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
        LocalDateTime beginTime = nextLocalDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
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
