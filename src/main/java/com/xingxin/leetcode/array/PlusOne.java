package com.xingxin.leetcode.array;

import java.util.Arrays;


/**
 * @author liuxh
 * @date 2021/5/21
 *
 *  加一  LC  7
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 */

public class PlusOne {

    //官方
    public static int[] plusOne1(int[] nums){
        for (int i = nums.length-1; i >= 0; i--) {
           //判断该位是不是9， 如果是9 则置为0，反之+1
            if (nums[i] == 9){
                nums[i] = 0;
            }else{
                nums[i] ++;
                return nums;
            }
        }
        //如果遍历到数组的第一位，还是9的话，此时就要对数组的总长度+1，
        // 因为数组new出来元素默认值是0,并将首位置为1
        nums = new int[nums.length+1];
        nums[0] =1 ;
        return nums;
    }
    //官方
    public static int[] plusOne2(int[] nums){
        for (int i = nums.length-1; i >= 0; i--) {
            //获取数组最后一位元素，并+1，
            nums[i] ++;
            //对最后一位取模运算 10%10=0 防止出现最后一位是10
            nums[i] = nums[i] %10;
            //如果最后一位不是0 说明没有进位，直接返回
            //如果最后一位是0，说明要进位了，对倒数第2位也做++，如此for循环
            if (nums[i] != 0){
                return nums;
            }
        }
        int[] ints = new int[nums.length+1];
        ints[0] = 1;
        return ints;
    }

    public static int[] plusOne(int[] nums) {
        //数组最后一位的下标；
        int index = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            nums[index - i]++;
            nums[index - i] = nums[index - i] % 10;
            if (nums[index - i] != 0) {
                return nums;
            }
        }
        int[] ints = new int[nums.length + 1];
        ints[0] = 1;
        return ints;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] nums1 = {4,3,2,1};
        int[] nums2 = {9};
        int[] nums3 = {2,9,9};
        System.out.println(Arrays.toString(plusOne(nums)));
        System.out.println(Arrays.toString(plusOne(nums1)));
        System.out.println(Arrays.toString(plusOne(nums2)));
        System.out.println(Arrays.toString(plusOne(nums3)));
        System.out.println("=======");
        System.out.println(Arrays.toString(plusOne1(nums)));
        System.out.println(Arrays.toString(plusOne1(nums1)));
        System.out.println(Arrays.toString(plusOne1(nums2)));
        System.out.println(Arrays.toString(plusOne1(nums3)));
        System.out.println("=======");
        System.out.println(Arrays.toString(plusOne2(nums)));
        System.out.println(Arrays.toString(plusOne2(nums1)));
        System.out.println(Arrays.toString(plusOne2(nums2)));
        System.out.println(Arrays.toString(plusOne2(nums3)));
        System.out.println("=======");
    }
}
