package com.xingxin.leetcode.string;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author liuxh
 * @date 2021/6/5
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a, b) -> a.length() - b.length());
        String s1 = strs[0];
        String result = "";
        if (s1.length() == 0) {
            return result;
        }
        int index = 0;
        while (index < s1.length()) {
            for (int i = 1; i < strs.length; i++) {
                if (s1.charAt(index) != strs[i].charAt(index)) {
                    return s1.substring(0, index);
                }
            }
            index++;
        }
        return s1;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(StringUtils.isEmpty( longestCommonPrefix(new String[]{"dog","racecar","car"}) ));
        System.out.println(longestCommonPrefix(new String[]{"ab","a"}));
        System.out.println(longestCommonPrefix(new String[]{""}));
    }
}
