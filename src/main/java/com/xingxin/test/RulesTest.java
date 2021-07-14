package com.xingxin.test;

import org.noggit.JSONUtil;

import java.util.*;

/**
 * @author liuxh
 * @date 2021/6/21
 */
public class RulesTest {
    public static void main(String[] args) {
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


        List<String> list = new ArrayList<>();
        list.add("0.png");
        list.add("10.png");
        list.add("3.png");
        list.add("4.png");
        list.add("100.png");
        list.sort(Comparator.comparingInt(RulesTest::strToInt));
        list.forEach(System.out::print);

    }
    private static int strToInt(String str) {
        return Integer.parseInt(str.substring(0,str.indexOf(".")));
    }

}
