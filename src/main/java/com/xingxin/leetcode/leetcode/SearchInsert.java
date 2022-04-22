package com.xingxin.leetcode.leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）  35
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liuxh
 * @date 2021/7/4
 */
public class SearchInsert {
    /**
     * 对于小数据量的情况，直接遍历不仅简单还直观，速度也可以，
     * 时间复杂度O(N) 空间复杂度0(1)
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
    /**
     * 大数据量的话，可以考虑二分,
     * 时间复杂度O(logN) 空间复杂度0(1)
     */
    public static int searchInsertByTwoBranch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 如果目标在中位处，直接返回下标
            if (target == nums[mid]) {
                return mid;
            }
            // 如果目标在二分的前半部分,right下标置为mid-1，反之，left下标置为mid+1
            if (target < nums[mid]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));
        System.out.println("-----------------");
        System.out.println(searchInsertByTwoBranch(nums, 5));
        System.out.println(searchInsertByTwoBranch(nums, 2));
        System.out.println(searchInsertByTwoBranch(nums, 7));
        System.out.println(searchInsertByTwoBranch(nums, 0));
    }
}
