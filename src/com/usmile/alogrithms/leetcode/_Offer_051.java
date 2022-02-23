package com.usmile.alogrithms.leetcode;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 */
public class _Offer_051 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        int i = new _Offer_051_Solution2().reversePairs(nums);
        System.out.println(i);
    }
}

/**
 * 暴力解法
 * 超时
 */
class _Offer_051_Solution1 {
    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}


/**
 * 归并（合并过程）
 */
class _Offer_051_Solution2 {
    public int reversePairs(int[] nums) {
        if (null == nums || 2 > nums.length) {
            return 0;
        }
        int[] temp = new int[nums.length];
        return sortAndCount(nums, 0, nums.length - 1, temp);
    }

    private int sortAndCount(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = sortAndCount(nums, left, mid, temp);
        int rightPairs = sortAndCount(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);

        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int count = 0;

        // 合并
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == right + 1) {
                nums[k] = temp[i++];
            } else if (temp[j] < temp[i]) {
                nums[k] = temp[j++];
                count += (mid - i) + 1;
            } else {
                nums[k] = temp[i++];
            }
        }

        return count;
    }
}
