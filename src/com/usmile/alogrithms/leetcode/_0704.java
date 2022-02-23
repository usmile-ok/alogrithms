package com.usmile.alogrithms.leetcode;

/**
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 */
public class _0704 {
}

/**
 * 迭代二分查找
 */
class _0704_Solution1 {
    public int search(int[] nums, int target) {
        if (null == nums) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 防止溢出
            int mid = left + (right - left) / 2; // mid 偏左
            // int mid = left + (right - left + 1) / 2  // mid 偏右
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}

/**
 * 递归二分
 */
class _0704_Solution2 {
    public int search(int[] nums, int target) {
        if (null == nums) {
            return -1;
        }

        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2; // mid 偏左
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target){
            return search(nums, left, mid - 1, target);
        } else {
            return search(nums, mid + 1, right, target);
        }
    }
}