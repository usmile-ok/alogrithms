package com.usmile.alogrithms.leetcode;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,5]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 */
public class _0154 {
}

class _0154_Solution1 {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left > right) {
            return nums[left];
        }
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (left == mid) {
                return Math.min(nums[left], nums[right]);
            }
            if (nums[mid] == nums[left]) {
                if (nums[left] > nums[right]) {
                    left = mid;
                } else if (nums[left] < nums[right]) {
                    right = mid;
                } else { // left mid right 相等无法判断最小元素区间
                    return Math.min(findMin(nums, left, mid), findMin(nums, mid + 1, right));
                }
            } else if (nums[mid] > nums[left]) {
                if (nums[left] < nums[right]) {
                    right = mid;
                } else if (nums[left] >= nums[right]) {
                    left = mid;
                }
            } else {
                right = mid;
            }
        }

        return nums[mid];
    }
}

/**
 * 官方解答，裂开
 */
class _0154_Solution2 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }
}