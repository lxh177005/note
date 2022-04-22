package com.xingxin.leetcode.string;

/**
 * @author liuxh
 * @date 2021/5/23
 *
 * 反转字符串  LC  1
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
public class ReverseString {

    public static char[] reverseString(char[] chars){
        int start = 0;
        int end = chars.length-1;
        while (start < end) {
            //交换位置
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return chars;
    }

    public static void main(String[] args) {
        char[] chars = "hello".toCharArray();
        System.out.println(reverseString(chars));

        String s = "{\"category\":[\"其它\"],\"classification\":[\"女装__少淑女装\",\"女装__中淑女装\",\"女装__大淑女装\",\"女装__快时尚女装\",\"女装__时尚休闲装\",\"女装__户外运动装\",\"男装__时尚休闲装\",\"男装__青春休闲装\",\"男装__户外运动装\",\"男装__商务休闲装\",\"Women's Wear__Young ladies\",\"Women's Wear__Mid-Lady Women\",\"Women's Wear__Lady dress\",\"Women's Wear__Fast fashion women's clothing\",\"Women's Wear__Fashion casual wear\",\"Women's Wear__Outdoor sportswear\",\"Men's Wear__Fashion casual wear\",\"Men's Wear__Youth casual wear\",\"Men's Wear__Outdoor sportswear\",\"Men's Wear__Business casual wear\"],\"linkType\":\"square\",\"market_clothing\":[\"女装__连衣裙\",\"女装__半身裙\",\"女装__衬衫\",\"女装__卫衣\",\"女装__T恤\",\"女装__上衣\",\"女装__裤子\",\"女装__大衣\",\"女装__羽绒服\",\"女装__派克服\",\"女装__夹克\",\"女装__西装\",\"女装__运动装\",\"女装__防晒服\",\"男装__裤子\",\"男装__连体裤\",\"男装__防晒服\",\"男装__羽绒服\",\"男装__派克服\",\"男装__大衣\",\"男装__夹克\",\"Women's Wear__dresses\",\"Women's Wear__skirts\",\"Women's Wear__shirts\",\"Women's Wear__sweaters\",\"Women's Wear__t-shirts\",\"Women's Wear__coats\",\"Women's Wear__pants\",\"Women's Wear__Overcoat\",\"Women's Wear__downjackets\",\"Women's Wear__pies\",\"Women's Wear__jackets\",\"Women's Wear__suits\",\"Women's Wear__sports suits\",\"Women's Wear__sun protection clothing\",\"Men's Wear__pants\",\"Men's Wear__jumpsuits\",\"Men's Wear__sun protection clothing\",\"Men's Wear__downjackets\",\"Men's Wear__pies\",\"Men's Wear__Overcoat\",\"Men's Wear__jackets\"],\"market_fabric\":[\"棉布\",\"麻布\",\"涤布\",\"人棉\",\"毛纺\",\"针织\",\"丝绸\",\"铜氨丝\"],\"tech\":[\"数码花型\"],\"version\":1}";
    }
}
