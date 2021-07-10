package com.xingxin.leetcode.leetcode;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，
 * 要求也按 非递减顺序 排序。
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * @author liuxh
 * @date 2021/7/10
 */
public class SortedSquares {

    /**
     * 时间复杂度O(nlogn),空间复杂度O(N)
     */
    private static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        // 遍历数组,平方运算,添加到新的数组里,然后排序
        for (int i = 0; i < nums.length; i++) {
            result[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(result);
        return result;
    }

    /**
     * 双指针
     * 思路：升序的数组，第一位的平方和最后一位的平方比较来决定放最后的位置，从最大往最小set新数组中
     * 时间复杂度 0(n) 空间复杂度0(n) 比上边的方法要优秀
     */
    private static int[] sortedTwoPrint(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        int[] result = new int[nums.length];
        while (left <= right) {
            // 如果第一位平方之后的值大于最后一位，把第一位的值加入新数组的最后一位，即最大值，然后左指针后移
            if (Math.pow(nums[left], 2) > Math.pow(nums[right], 2)) {
                result[index] = (int) Math.pow(nums[left], 2);
                left++;
            } else {
                // 反之，原数组的最后一位是最大值，然后右指针前移，
                result[index] = (int) Math.pow(nums[right], 2);
                right--;
            }
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(sortedTwoPrint(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedTwoPrint(new int[]{-7, -3, 2, 3, 11})));

    }
}
