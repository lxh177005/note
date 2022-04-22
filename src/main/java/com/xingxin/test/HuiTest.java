package com.xingxin.test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 44824000====0B8249=1042
 * 44820000====0B8200=1040
 * 3EA3D70A====7FA3D7=0.32
 * BD75C288====FCF5C3=-0.06
 * 3F266666====40A666=0.65
 * 3F68F5C2====40E8F5=0.91
 * 3E851EB8====7F851E=0.26
 *
 * @author liuxh
 * @date 2021/7/22
 */
public class HuiTest {
    public static void main(String[] args) {

        double param = 0.26;
        Long start1 = System.currentTimeMillis();
        String s = decimalToHex(param);
        Long end1 = System.currentTimeMillis();
        System.out.println("result = " + s + " ,用时：" + (end1 - start1) + "毫秒");

        String param1 = "7F851E";
        Long start = System.currentTimeMillis();
        String x = sciCal(hexToDecimal(param1), 2);
        Long end = System.currentTimeMillis();
        System.out.println("result = " + x + " ,用时：" + (end - start) + "毫秒");

    }

    /**
     * 10进制小数转16进制
     *
     * @param param 10进制小数
     * @return 16进制
     */
    private static String decimalToHex(double param) {
        System.out.println("start decimalToHex param is: " + param);
        // 判断入参
        if (param == 0) {
            return "hahaha";
        }
        // n:正负
        int n = 1;
        if (param < 0) {
            param = Math.abs(param);
            n = -1;
        }
        //  e:指数
        int e = 0;
        do {
            if (param < 0.5) {
                param *= 2;
                e--;
            }
            if (param >= 1) {
                param /= 2;
                e++;
            }
        } while (param < 0.5 || param >= 1);
        String right = Integer.toHexString(Integer.parseInt(decXiao2Bin(param).substring(0, 16), 2));
//        System.out.println("right = " + right);
        // log整数部分取绝对值，转二进制补全6位，然后补码，如果补完结果仍是6位则需要前面拼字符串1，超过6位则无需拼接
        String left = "";
        if (e <= 0) {
            // 补码
            int i = addNumber(String.valueOf(addCharLength(Integer.toBinaryString(Math.abs(e)), 6)), false);
//            System.out.println("i = " + i);
            String before = Integer.toBinaryString(i);
            if (i < Integer.parseInt("1000000", 2)) {
                before = "1" + Integer.toBinaryString(i);
            }
            left = n > 0 ? "0" + before : "1" + before;
        } else {
            left = String.valueOf(addCharLength(Integer.toBinaryString(Math.abs(e)), 8));
        }
        String newLeft = Integer.toHexString(Integer.parseInt(left, 2));
//        System.out.println("newLeft = " + newLeft);
        String result = newLeft + right;
        if (result.length() < 6) {
            return "0" + result.toUpperCase();
        }
        return result.toUpperCase();
    }

    /**
     * 16进制->10进制小数
     *
     * @param param 16进制
     */
    private static double hexToDecimal(String param) {
        System.out.println("start hexToDecimal param is: " + param);
        String left = Integer.toBinaryString(Integer.parseInt(param.substring(0, 2), 16));
        String right = Integer.toBinaryString(Integer.parseInt(param.substring(2, 6), 16));
        double newRight = bin2DecXiao(right);
        char[] newChar = addCharLength(left, 8);
        int n = Integer.parseInt(String.valueOf(newChar[0]));
        int m = Integer.parseInt(String.valueOf(newChar[1]));
        int e = Integer.parseInt(String.valueOf(newChar).substring(1, 8), 2);
        if (m == 1) {
            // 补码
            e = addNumber(String.valueOf(newChar).substring(2, 8), true);
            e *= (-1);
        }
//        System.out.println("n=" + n + " ,m=" + m + " ,e=" + e + " ,right=" + Double.parseDouble(right));
        return Math.pow(-1, n) * Math.pow(2, e) * newRight;
    }

    /**
     * 补全字符串长度
     *
     * @param left   要补全的字符串
     * @param length 要补全的长度
     * @return char数组
     */
    private static char[] addCharLength(String left, Integer length) {
        char[] chars = left.toCharArray();
        char[] newChar = new char[length];
        Arrays.fill(newChar, '0');
        for (int i = chars.length - 1, j = length - 1; i >= 0; i--, j--) {
            if (j < 0) {
                break;
            }
            newChar[j] = chars[i];
        }
//        System.out.println("newLeft = " + String.valueOf(newChar));
        return newChar;
    }

    /**
     * 二进制小数转十进制
     */
    public static double bin2DecXiao(String binXStr) {
        double decX = 0.0;
        //位数
        int k = 0;
        for (int i = 0; i < binXStr.length(); i++) {
            int exp = binXStr.charAt(i) - '0';
            exp = -(i + 1) * exp;
            if (exp != 0) {
                decX += Math.pow(2, exp);
            }
        }
        return decX;
    }

    /**
     * 将十进制小数转化为二进制
     */
    public static String decXiao2Bin(double x) {
        //精确位数
        int accurate = 100;
        int[] binX = new int[accurate];
        String binXSB = "";
        double x1 = x;
        double x2 = 0;
        for (int i = 0; i < binX.length; i++) {
            x2 = x1 + x1;
            x1 = Math.floor(x2);
            binX[i] = (int) x1;
            x1 = x2 - x1;
            binXSB += Integer.toString(binX[i]);
        }
        String binXStr = binXSB.toString();
        return binXStr;
    }

    /**
     * 补码
     *
     * @param str 需要补码的二进制数字
     * @param b   是否需要截取保证6位长度
     * @return 补码之后的二进制数字
     */
    private static Integer addNumber(String str, Boolean b) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (chars[i] == '0') ? '1' : '0';
        }
        String s = addOne(String.valueOf(chars), "1");
//        System.out.println("补码之后的结果 = " + s);
        if (b) {
            return Integer.parseInt(s.substring(s.length() - 6), 2);
        }
        return Integer.parseInt(s, 2);
    }

    public static String addOne(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        //进位
        int pre = 0;
        //存储进位和另两个位的和
        int sum = 0;

        while (a.length() != b.length()) {
            //将两个二进制的数位数补齐,在短的前面添0
            if (a.length() > b.length()) {
                b = "0" + b;
            } else {
                a = "0" + a;
            }
        }
        for (int i = a.length() - 1; i >= 0; i--) {
            x = a.charAt(i) - '0';
            y = b.charAt(i) - '0';
            //从低位做加法
            sum = x + y + pre;
            if (sum >= 2) {
                //进位
                pre = 1;
                sb.append(sum - 2);
            } else {
                pre = 0;
                sb.append(sum);
            }
        }
        if (pre == 1) {
            sb.append("1");
        }
        //翻转返回
        return sb.reverse().toString();
    }

    /**
     * @param value 需要科学计算的数据
     * @param digit 保留的小数位
     * @return 功能：四舍六入五成双计算法
     */
    public static String sciCal(double value, int digit) {
        String result = "-999";
        try {
            double ratio = Math.pow(10, digit);
            double _num = value * ratio;
            double mod = _num % 1;
            double integer = Math.floor(_num);
            double returnNum;
            if (mod > 0.5) {
                returnNum = (integer + 1) / ratio;
            } else if (mod < 0.5) {
                returnNum = integer / ratio;
            } else {
                returnNum = (integer % 2 == 0 ? integer : integer + 1) / ratio;
            }
            BigDecimal bg = new BigDecimal(returnNum);
            result = bg.setScale((int) digit, BigDecimal.ROUND_HALF_UP).toString();
        } catch (RuntimeException e) {
            throw e;
        }
        return result;
    }
}
