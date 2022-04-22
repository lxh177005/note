package com.xingxin.test;

import com.xingxin.entity.Person;
import org.apache.commons.lang3.ObjectUtils;
import org.noggit.JSONUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuxh
 * @date 2021/6/21
 */
public class RulesTest {
    public static void main(String[] args) throws ParseException {
//        Map<String, String> map = new HashMap<>();
//        map.put("aaa", "111");
//        map.put("bbb", "222");
//        map.put("ccc", "333");
//        // 不推荐使用
//        for (String k : map.keySet()) {
//            System.out.println(k + "=" + map.get(k));
//        }
//        // 推荐
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + "-" + entry.getValue());
//        }
//        // 推荐
//        map.forEach( (k, v) -> System.out.println(k + ": " + v));
//
//        System.out.println(Math.random());
//        System.out.println(new Random().nextInt());
//        System.out.println(new Random().nextInt(100));
//
//        int m = 1 % 2;
//        int n = 1/2;
//        System.out.println(m + "," + n);


//        List<String> list = new ArrayList<>();
//        list.add("0.png");
//        list.add("10.png");
//        list.add("3.png");
//        list.add("4.png");
//        list.add("100.png");
//        list.sort(Comparator.comparingInt(RulesTest::strToInt));
//        list.forEach(System.out::print);


//        String str1 = "-A-_sdg123";
//        System.out.println(str1.matches("^[0-9a-zA-Z_-]+$"));



//        String s = Integer.toHexString(16);
//        System.out.println("s = " + s);
//
//        int i = Integer.parseInt(s, 16);
//        System.out.println("i = " + i);
//
//
//        // 没搞明白 OXH 和 FXH
//        String pic = "62C204";
//        String str = pic.replaceAll(" ", "");
//        double result  = (Integer.parseInt(str.substring(0, 4), 16) / 32768.0)
//                * Math.pow(2, Integer.parseInt(str.substring(4, 6), 16));
//        System.out.println("result = " + result);

//        Person person = new Person();
//        System.out.println(person == null);
//        System.out.println(ObjectUtils.isEmpty(person));
//        Person person1 = null;
//        System.out.println(ObjectUtils.isEmpty(person1));
//
//        String strTime = "2020-02-02 02:00:00";
//
//        // str to date  (throw exception)
//        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strTime);
//        System.out.println("parse = " + parse);
//        // str to date
//        LocalDateTime localDateTime = LocalDateTime.parse(strTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        Date from = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//        System.out.println("from = " + from);

        String fileds = "\n" +
                "seller_nick\n" +
                "payment\n" +
                "receiver_name\n" +
                "receiver_state\n" +
                "receiver_address\n" +
                "receiver_zip\n" +
                "receiver_mobile\n" +
                "receiver_phone\n" +
                "consign_time\n" +
                "received_payment\n" +
                "promotion_details\n" +
                "promotion_details\n" +
                "promotion_details\n" +
                "promotion_details\n" +
                "promotion_details\n" +
                "promotion_details\n" +
                "promotion_details\n" +
                "promotion_details\n" +
                "promotion_details\n" +
                "paid_coupon_fee\n" +
                "tid\n" +
                "num\n" +
                "num_iid\n" +
                "status\n" +
                "title\n" +
                "type\n" +
                "price\n" +
                "discount_fee\n" +
                "total_fee\n" +
                "created\n" +
                "pay_time\n" +
                "modified\n" +
                "end_time\n" +
                "buyer_message\n" +
                "buyer_memo\n" +
                "seller_memo\n" +
                "buyer_nick\n" +
                "step_trade_status\n" +
                "step_paid_fee\n" +
                "mark_desc\n" +
                "adjust_fee\n" +
                "trade_from\n" +
                "service_orders\n" +
                "buyer_rate\n" +
                "receiver_city\n" +
                "receiver_district\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n" +
                "orders\n";

        String s = fileds.replaceAll("\n", ",");
        System.out.println("s = " + s);



    }

    private static int strToInt(String str) {
        return Integer.parseInt(str.substring(0,str.indexOf(".")));
    }

}
