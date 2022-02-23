package com.usmile.alogrithms.leetcode;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 */
public class _0283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 0,5,8,0,1,0};
        new _0283_Solution1().moveZeroes(nums);
        System.out.println("end");
    }
}


// 暴力解法：新申请一个数组空间。依次赋值原数组非0元素
/**
 * 快慢指针
 * 快指针查找非0
 * 慢指针指向第一个0
 */
class _0283_Solution1 {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast ++) {
            if (nums[fast] != 0) {
                // 不做替换
                if (slow != fast) {
                    int temp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = temp;
                }

                slow ++;
            }
        }
    }
}