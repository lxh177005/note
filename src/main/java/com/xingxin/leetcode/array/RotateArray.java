package com.xingxin.leetcode.array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author : mrliu
 * @date : 2021-05-16 16:36
 *
 * 旋转数组  LC   3
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *  
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 **/
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2};
//        rotate1(nums,3);
//        rotate2(nums,3);
        rotate3(nums,2);
        System.out.println(Arrays.toString(nums));
    }
    //利用Arrays包下的copy方法
    private static void rotate1(int[] nums, int k){
        int[] ints1 = Arrays.copyOfRange(nums, k+1, nums.length);
        int[] ints2 = Arrays.copyOfRange(nums, 0, k+1);
        int[] result = ArrayUtils.addAll(ints1, ints2);
        System.arraycopy(result,0,nums,0,nums.length);
    }
    //new 新数组 然后遍历赋值给新数组 最后copy到原数组
    private static void rotate2(int[] nums, int k){
        int n = nums.length;
        int[] result  = new int[n];
        for (int i = 0; i < n; i++) {
            result[(i+k)%n] = nums[i];
        }
        System.arraycopy(result,0,nums,0,n);
    }

    /*
     *  整体反转 然后再次分别反转
     *  1,2,3,4,5,6,7
     *  7,6,5,4,3,2,1
     *  5,6,7,1,2,3,4
     * 时间复杂度 o(n) 空间复杂度O（1）
     */
    private static void rotate3(int[] nums, int k){
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }
    private static void reverse(int[] nums, int start, int end){
        while (start < end) {
            //不开辟新空间的情况下，交换位置
            nums[start] = nums[start] + nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start] = nums[start] - nums[end];
            start++;
            end--;
        }
    }
}
