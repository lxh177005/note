package com.xingxin.leetcode.leetcode;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 *  
 * 示例 1：
 *
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * 示例 2：
 *
 * 输入：n = 1, bad = 1
 * 输出：1
 *
 * 来源：力扣（LeetCode） 278
 * 链接：https://leetcode-cn.com/problems/first-bad-version
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liuxh
 * @date 2021/7/4
 */
public class Solution {
    // 假设 版本3 以后都是错误的版本
    public static boolean isBadVersion(int version) {
        return version >= 4;
    }

    public static int firstBadVersion(int n) {
        int left = 0;
        int mid = 0;
        int right = n;
        while (left <= right) {
            System.out.println("start....");
            mid = left + (right - left) / 2;
            // 二分中间值 恰好是第一个错误的版本
            boolean midVersion = isBadVersion(mid);
            boolean beforeMidVersion = isBadVersion(mid - 1);
            if (midVersion && !beforeMidVersion) {
                return mid;
            }
            // 二分中间值是true、并且中间值的前个值也是true，说明 错的出现在前半部分
            if (midVersion && beforeMidVersion) {
                right = mid - 1;
            }
            // 二分中间值是false，说明出错的地方在后半部分
            if (!midVersion) {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 官方
    public static int firstBadVersion1(int n) {
        int left = 1, right = n;
        // 循环直至区间左右端点相同
        while (left < right) {
            System.out.println("start====");
            int mid = left + (right - left) / 2;
            // 答案在区间 [left, mid] 中
            if (isBadVersion(mid)) {
                right = mid;
            // 答案在区间 [mid+1, right] 中
            } else {
                left = mid + 1;
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }


    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
        System.out.println(firstBadVersion1(5));
    }
}
