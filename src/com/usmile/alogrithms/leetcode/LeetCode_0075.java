package com.usmile.alogrithms.leetcode;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 */
public class LeetCode_0075 {
}

/**
 * 计数排序
 */
class LeetCode_0075_Solution1 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 0; i < count.length - 1; i++) {
            count[i + 1] = count[i + 1] + count[i];
        }

        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = count[nums[i]];
            temp[index - 1] = nums[i];
            count[nums[i]]--;
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }
}