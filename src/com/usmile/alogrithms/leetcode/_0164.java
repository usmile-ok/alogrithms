package com.usmile.alogrithms.leetcode;

import java.util.Arrays;

/**
 * 164. 最大间距
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
 * <p>
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 * <p>
 * 输入: nums = [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 */
public class _0164 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 2};
        int i = new _0164_Solution1().maximumGap(nums);
        System.out.println(i);
    }
}


/**
 * 基数排序
 */
class _0164_Solution1 {
    public int maximumGap(int[] nums) {
        if (null == nums || nums.length < 2) {
            return 0;
        }
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int[] temp = new int[nums.length];
        for (int exp = 1; max / exp >= 1; exp *= 10) {
            int[] count = new int[10];
            for (int i = 0; i < nums.length; i++) {
                count[(nums[i] / exp) % 10]++;
            }

            for (int i = 0; i < count.length - 1; i++) {
                count[i + 1] += count[i];
            }

            // 倒序为了保持稳定
            for (int i = nums.length - 1; i >= 0; i--) {
                temp[count[(nums[i] / exp) % 10] - 1] = nums[i];
                count[(nums[i] / exp) % 10]--;
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
        }

        int maxGap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > maxGap) {
                maxGap = nums[i + 1] - nums[i];
            }
        }

        return maxGap;
    }
}

/**
 * 桶排序(利用思想， 桶内的元素无需排序)
 */
class _0164_Solution2 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int d = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketSize = (maxVal - minVal) / d + 1;

        int[][] bucket = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; ++i) {
            Arrays.fill(bucket[i], -1); // 存储 (桶内最小值，桶内最大值) 对， (-1, -1) 表示该桶是空的
        }

        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - minVal) / d;
            if (bucket[idx][0] == -1) {
                bucket[idx][0] = bucket[idx][1] = nums[i];
            } else {
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }

        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                ret = Math.max(ret, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return ret;
    }
}