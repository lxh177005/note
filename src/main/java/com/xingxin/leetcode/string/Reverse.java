package com.xingxin.leetcode.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liuxh
 * @date 2021/5/25
 *
 * 整数反转  LC 2
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 */
public class Reverse {

    //leetcode 无法使用jdk以外的jar包方法
    public static int reverse(int x) {
        //入参如果是int最小值，绝对值就超过int范围了，所以绝对值还是负数，要排除掉这个特殊情况；
        if (x == Integer.MIN_VALUE) return 0;
        Long strReverse = Long.parseLong(StringUtils.reverse(String.valueOf(Math.abs(x))));
        if (strReverse >= Integer.MAX_VALUE) return 0;
        return (int) (x >= 0 ? strReverse : strReverse * (-1));
    }
    public static int reverse2(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        Long strReverse = Long.parseLong(strReverse(String.valueOf(Math.abs(x))));
        if (strReverse > Integer.MAX_VALUE) return 0;
        return (int) (x >= 0 ? strReverse : strReverse * (-1));
    }
    private static String strReverse(String str){
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length-1;
        while (start < end ){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(1534236469));
        System.out.println(reverse(-2147483648));
        System.out.println(reverse(Integer.MAX_VALUE));

        System.out.println("================");
        System.out.println(reverse2(123));
        System.out.println(reverse2(-123));
        System.out.println(reverse2(120));
        System.out.println(reverse2(0));
        System.out.println(reverse2(1534236469));
        System.out.println(reverse2(-2147483648));
        System.out.println(reverse2(Integer.MAX_VALUE));

    }
}
