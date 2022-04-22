package com.xingxin.leetcode.leetcode;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 来源：力扣（LeetCode）  704
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liuxh
 * @date 2021/7/3
 */
public class Search {

    /**
     * 遍历数组，存在返回小标，不存在返回-1；
     * 时间复杂度O(N)，空间复杂度O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    private static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分法，时间复杂度O(logN),空间复杂度0(1)
     *
     * @param nums
     * @param target
     * @return
     */
    private static int select(int[] nums, int target) {
        //声明 左、中、右指针
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // 如果目标在二分的前半部分，就把右指针指向mid-1，反之 左指针为mid+1；
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));

        System.out.println(select(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(select(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
