package com.xingxin.leetcode.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * no.1
 *
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值
 * 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //大神解法,利用hash表，k存数值，v存索引，
    //判断map是否包含目标值减去遍历的k的k值，如果存在返回下标即可，不存在继续添加
    public static int[] twoSum1(int[] nums, int target){
        if (nums == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //存在则返回
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }
            //不存在则添加
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 5,5, 11};
        int target = 10;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSum1(nums, target)));
    }
}
