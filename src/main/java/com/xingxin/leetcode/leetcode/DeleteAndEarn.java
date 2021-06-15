package com.xingxin.leetcode.leetcode;

/**
 * no.740
 * <p>
 * 给你一个整数数组nums,你可以对它进行一些操作。
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，
 * 你必须删除每个等于nums[i] - 1或nums[i] + 1的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例2：
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 */
public class DeleteAndEarn {

    public static int deleteAndEarn(int[] nums) {
        if (nums == null) return -1;

        return 0;
    }
}
