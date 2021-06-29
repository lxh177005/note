package com.xingxin.leetcode.leetcode;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * @author liuxh
 * @date 2021/6/29
 */
public class ConvertToTitle {

    private static String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            char c = (char) (n % 26 + 'A');
            sb.append(c);
            n =n / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println( convertToTitle(1));
        System.out.println( convertToTitle(28));
        System.out.println( convertToTitle(701));
        System.out.println( convertToTitle(2147483647));
        System.out.println( convertToTitle(1778870000));
    }
}
