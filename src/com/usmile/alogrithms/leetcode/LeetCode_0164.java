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
public class LeetCode_0164 {
    public static void main(String[] args) {
        System.out.println(1);
    }
}


/**
 * 基数排序
 */
class LeetCode_0164_Solution1 {
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

        int exp = 1;
        while (max / exp > 1) {
            exp *= 10;
        }



        for (int i = 1; i <= exp; i++) {
            int[] cnt = new int[10];
            for (int j = 0; j < nums.length; j++) {
                cnt[nums[i] / (10 * exp)]++;
            }

            for (int j = 0; j < cnt.length - 1; i++) {
                cnt[i + 1] = cnt[i + 1] + cnt[i];
            }

            int[] temp = new int[nums.length];
            for (int j = 0; j < nums.length; i++) {
                temp[cnt[nums[i]] - 1] = nums[i];
                cnt[nums[i]]--;
            }
        }

        return 0;
    }
}