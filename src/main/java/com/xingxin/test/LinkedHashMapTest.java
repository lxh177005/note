package com.xingxin.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liuxh
 * @date 2021/7/18
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "aaa");
        map.put("2", "bbb");
        map.put("3", "ccc");
        map.forEach((k, v) -> System.out.print(k + ":" + v));
        map.get("2");
        map.forEach((k, v) -> System.out.print(k + ":" + v));
        map.get("3");
        map.forEach((k, v) -> System.out.print(k + ":" + v));

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aaa", null);
        hashMap.put("bbb", null);
        hashMap.forEach((k, v) -> System.out.print(k + ":" + v));
    }
}
