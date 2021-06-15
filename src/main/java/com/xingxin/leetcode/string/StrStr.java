package com.xingxin.leetcode.string;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author liuxh
 * @date 2021/5/30
 * 实现 strStr()
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 */
public class StrStr {
    public static int strStr(String haystack, String needle) {
        //indexOf api 满足返回开始下标，不满足返回-1，needle为空，返回0
//        if ("".equals(needle)) {
//            return 0;
//        }
//        if ( !haystack.contains(needle)) {
//            return -1;
//        }
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(strStr(haystack,needle));
        String haystack1 = "aaaaa", needle1 = "bba";
        System.out.println(strStr(haystack1,needle1));
        String haystack2 = "", needle2 = "";
        System.out.println(strStr(haystack2,needle2));

        String result = "{\"reason_code\":\"001\",\"success\":false}\n   ";
        JSONObject jsonObject = JSON.parseObject(result);
        System.out.println("jsonObject = " + jsonObject);

        String s1 = "";

    }
}
