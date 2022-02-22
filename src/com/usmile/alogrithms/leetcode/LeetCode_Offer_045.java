package com.usmile.alogrithms.leetcode;

import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class LeetCode_Offer_045 {
}

class LeetCode_Offer_045_Solution1 {
    public String minNumber(int[] nums) {
        Integer[] newNums = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }

        // 最重要的排序逻辑
        Arrays.sort(newNums, (num1, num2)-> {
            String xy = "" + num1 + num2;
            String yx = "" + num2 + num1;

            return xy.compareTo(yx);
        });

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < newNums.length; i++) {
            result.append(newNums[i]);
        }

        return result.toString();
    }
}