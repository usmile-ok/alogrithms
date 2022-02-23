package com.usmile.alogrithms.leetcode;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * 示例 5:
 * <p>
 * 输入: nums = [1], target = 0
 * 输出: 0
 */
public class _0035 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int i = new _0035_Solution1().searchInsert(nums, 5);
        System.out.println(i);
    }


}


/**
 * 这里只用计算一种。代码里重复了。
 */
class _0035_Solution1 {
    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        // 查找最后一个小于等于target的值
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // mid 需要靠右， 不然会死循环
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
//        int leftIndex = left;
        // 查找第一个大于等于target的值
//        left = 0;
//        right = nums.length - 1;
//        while (left < right) {
//            // mid 需要靠左， 不然会死循环
//            int mid = left + (right - left) / 2;
//            if (nums[mid] >= target) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        int rightIndex = right;
//
//        return rightIndex == leftIndex ? leftIndex : leftIndex + 1;

        return nums[left] == target ? left : left + 1;
    }
}