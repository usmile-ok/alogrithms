package com.usmile.alogrithms.leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class _0034 {
}


/**
 * 递归 + 二分
 */
class _0034_Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        search(nums, 0, nums.length - 1, target, result);

        return result;
    }

    private void search(int[] nums, int left, int right, int target, int[] result) {
        if (left > right) {
            return;
        }
        int mid = left + (right - left) / 2; // mid 偏左
        if (nums[mid] == target) {
            if (mid - 1 >= 0 && nums[mid - 1] == target) {
                search(nums, left, mid - 1, target, result);
            } else {
                result[0] = mid;
            }

            if (mid + 1 < nums.length && nums[mid + 1] == target) {
                search(nums, mid + 1, right, target, result);
            } else {
                result[1] = mid;
            }
        } else if (nums[mid] > target) {
            search(nums, left, mid - 1, target, result);
        } else {
            search(nums, mid + 1, right, target, result);
        }
    }
}