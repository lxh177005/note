package com.xingxin.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author liuxh
 * @date 2021/6/21
 */
public class RulesTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "111");
        map.put("bbb", "222");
        map.put("ccc", "333");
        // 不推荐使用
        for (String k : map.keySet()) {
            System.out.println(k + "=" + map.get(k));
        }
        // 推荐
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        // 推荐
        map.forEach( (k, v) -> System.out.println(k + ": " + v));

        System.out.println(Math.random());
        System.out.println(new Random().nextInt());
        System.out.println(new Random().nextInt(100));

        int m = 1 % 2;
        int n = 1/2;
        System.out.println(m + "," + n);

    }
}
