package com.xingxin.leetcode.array;

import java.util.Arrays;

/**
 * @author liuxh
 * @date 2021/5/22
 *
 * 移动零  LC  8
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes {
    //比较笨重
    public static void moveZeroes1(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] ==0){
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    //利用stream流过滤掉元素值等于0的元素，然后new同长度的新数组，然后copy过滤后的数组
    public static int[] moveZeroes(int[] nums){
        int[] ints = Arrays.stream(nums).filter(num -> num != 0).toArray();
        int[] result = new int[nums.length];
        System.arraycopy(ints,0,result,0,ints.length);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 0,1,0,3,12 };
        int[] nums1 = {4,2,4,0,0,3,0,5,1,0};
//        int[] ints = moveZeroes(nums);
//        int[] ints1 = moveZeroes(nums1);
//        System.out.println(Arrays.toString(ints));
//        System.out.println(Arrays.toString(ints1));

        moveZeroes1(nums);
        moveZeroes1(nums1);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums1));
    }
}
