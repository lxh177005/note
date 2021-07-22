package com.xingxin.test;

import java.util.Arrays;

/**
 * @author liuxh
 * @date 2021/7/22
 */
public class HuiTest {
    public static void main(String[] args) {
        String param = "0AF9C0";
        // 16进制->10进制->转2进制
        String left = Integer.toBinaryString(Integer.parseInt(param.substring(0, 2), 16));
        String right = Integer.toBinaryString(Integer.parseInt(param.substring(2, 6), 16));
        System.out.println("left = " + left);
        System.out.println("right = " + right);
        char[] chars = left.toCharArray();
        char[] newChar = new char[8];
        Arrays.fill(newChar, '0');
        for (int i = chars.length - 1, j = 7; i >= 0; i--, j--) {
            if (j < 0) {
                break;
            }
            newChar[j] = chars[i];
        }
        System.out.println("newLeft = " + String.valueOf(newChar));
        int n = Integer.parseInt(String.valueOf(newChar[0]));
        int e = Integer.parseInt(String.valueOf(newChar[1]));
        System.out.println("n=" + n + " ,e=" + e);
        double result = Math.pow(-1, n) * Math.pow(2, e) * Double.parseDouble(right);
        System.out.println("result = " + result);
    }
}
