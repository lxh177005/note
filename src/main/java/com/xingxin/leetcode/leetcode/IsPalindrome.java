package com.xingxin.leetcode.leetcode;

import org.apache.commons.lang3.StringUtils;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 *  
 * @author liuxh
 * @date 2021/6/29
 */
public class IsPalindrome {

    /**
     *  直接用api
     */
    public static boolean isPalindrome(int n) {
        return String.valueOf(n).equals(StringUtils.reverse(String.valueOf(n)));
    }

    public static boolean isPalindrome1(int n) {
        return String.valueOf(n).equals(reverse(String.valueOf(n).toCharArray()));
    }

    private static String reverse(char[] chars) {
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end --;
        }
        return String.valueOf(chars);
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(101));

        System.out.println(isPalindrome1(121));
        System.out.println(isPalindrome1(-121));
        System.out.println(isPalindrome1(10));
        System.out.println(isPalindrome1(101));
    }
}
