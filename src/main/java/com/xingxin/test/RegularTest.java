package com.xingxin.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * @author liuxh
 * @date 2021/7/22
 */
public class RegularTest {
    public static void main(String[] args) {
        String str = "ab15faG";
        // 直接匹配
        boolean matches= str.matches("^\\w+$");
        System.out.println("matches = " + matches);

        // 构造相关类匹配
        String reg = "^\\w{3}$";
        Pattern pattern = Pattern.compile(reg);
        Matcher mc = pattern.matcher("abcd");
        boolean matches1 = mc.matches();
        System.out.println("matches1 = " + matches1);
        // 解析数据结构
        while (mc.find()) {
            System.out.println(mc.group());
        }
    }
}
