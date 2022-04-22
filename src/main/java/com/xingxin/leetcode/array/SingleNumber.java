package com.xingxin.leetcode.array;

import java.util.Arrays;

/**
 * @author : mrliu
 * @date : 2021-05-17 22:40
 *
 * 只出现一次的数字  LC  5
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 **/
public class SingleNumber {

    //排序，跳跃for循环 比较第1和第2是否相等 第3和第4是否相等。。。
    // 如果不相等，返回，如果相等，则返回数组最后一位
    //时间复杂度O（N^2）空间复杂度O(1)
    private static int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length < 3) return -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /*
     *  C语言异或运算
     *  a ^ 0 = a
     *  a ^ a = 0
     *  a ^ b = 1
     *  总体来说 就是 a ^ a ^ b = b 数组中所有元素的异或结果就是那个落单的元素值
     */
    private static int singleNumber2(int[] nums) {
        int result = 0;
        for (int num : nums) result ^= num;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};
        int[] nums3 = {1, 3, 1, -1, 3};
        int[] nums4 = {-336, 513, -560, -481, -174, 101, -997, 40, -527, -784, -283, -336, 513, -560, -481, -174, 101, -997, 40, -527, -784, -283, 354};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber(nums2));
        System.out.println(singleNumber(nums3));
        System.out.println(singleNumber(nums4));
        System.out.println("=====================");
        System.out.println(singleNumber2(nums));
        System.out.println(singleNumber2(nums2));
        System.out.println(singleNumber2(nums3));
        System.out.println(singleNumber2(nums4));
    }
}
