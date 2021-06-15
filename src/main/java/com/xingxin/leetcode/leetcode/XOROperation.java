package com.xingxin.leetcode.leetcode;
/**
 * no.1486
给你两个整数，n 和 start 。
数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
请返回 nums 中所有元素按位异或（XOR）后得到的结果。

示例 1：
输入：n = 5, start = 0
输出：8
解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
     "^" 为按位异或 XOR 运算符。
示例 2：
输入：n = 4, start = 3
输出：8
解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
示例 3：
输入：n = 1, start = 7
输出：7
示例 4：
输入：n = 10, start = 5
输出：2
提示：
1 <= n <= 1000
0 <= start <= 1000
n == nums.length

 补充：XOR是二进制的异或运算，就是先把int型数字转化为二进制的，然后比较位数，如果两个数字的每个位上值相同，
 则该位的结果为0，反之为1
 例如：2的二进制是10 3的二进制是11  他们个位的结果是1，十位的结果是0 结果就是01 01转化为十进制就是1了

 */
public class XOROperation {

    public static int xorOperation(int n, int start){
        if (n<1 || start<0) return -1;
        int xor = start;
        for (int i = 1; i < n; i++) {
            xor = xor^(start+2*i);
        }
        return xor;
    }

    public static void main(String[] args) {
//        int a = 0;
//        int b = 2;
//        int c = 4;
//        int d = 6;
//        int e = 8;
//        int f = a^b^c^d^e;
//        System.out.println(f);
        System.out.println(xorOperation(1,5));

    }
}
