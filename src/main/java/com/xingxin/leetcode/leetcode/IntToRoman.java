package com.xingxin.leetcode.leetcode;

/**
 * @author : mrliu
 * @date : 2021-05-15 13:06
 *
 * no.12
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，
 * 即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
 *
 * 这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 **/
public class IntToRoman {

    public static String intToRoman(int param){
        //关键位置的数字与罗马数字的对应关系
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            String roman = romans[i];
            //看位数属于那个档次的 然后记录对应的罗马数字，并且减去该位，继续下次遍历
            while (param >= num){
                param -= num;
                result.append(roman);
            }
            if (param == 0) {
                break;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(1994));
    }
}
