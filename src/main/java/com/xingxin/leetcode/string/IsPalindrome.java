package com.xingxin.leetcode.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liuxh
 * @date 2021/5/29
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        //replaceAll 过滤掉所有非字母数字
        String str = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        return StringUtils.equals(str,StringUtils.reverse(str));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
