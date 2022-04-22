package com.xingxin.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : mrliu
 * @date : 2021-05-16 22:37
 *
 * 存在重复元素   LC    4
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 **/
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {11, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate(nums2));
        System.out.println(containsDuplicate(nums3));
        System.out.println("====================");
        System.out.println(containsDuplicate2(nums));
        System.out.println(containsDuplicate2(nums2));
        System.out.println(containsDuplicate2(nums3));
        System.out.println("====================");
        System.out.println(containsDuplicate3(nums));
        System.out.println(containsDuplicate3(nums2));
        System.out.println(containsDuplicate3(nums3));
    }

    //双层for循环 类似于冒泡算法，比较有相同值，就返回false
    //时间复杂度O(N^2) 空间复杂度O(1)
    private static boolean containsDuplicate(int[] nums) {
        boolean result = false;
        if (nums.length >= 2) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) result = true;
                }
            }
        }
        return result;
    }

    //利用map的hash特性，key重复的话，map的size是小于数组的长度的，
    //时间复杂度是O(N) 空间复杂度是O（N）
    private static boolean containsDuplicate2(int[] nums) {
        boolean result = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 0);
        }
        if (map.size() < nums.length) {
            result = true;
        }
        return result;
    }

    //利用stream流，去重，生成新的数组，对原数组进行比较
    //时间复杂度O（n） 空间复杂度O（n） 但是代码优雅呀！！！
    private static boolean containsDuplicate3(int[] nums) {
        return Arrays.stream(nums).distinct().toArray().length < nums.length;
    }
}