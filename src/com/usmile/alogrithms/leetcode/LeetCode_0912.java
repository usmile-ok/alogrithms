package com.usmile.alogrithms.leetcode;

import java.util.ArrayList;

/**
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class LeetCode_0912 {
}

/**
 * 基础冒泡排序（稳定）
 * O(n^2)
 * 超时
 */
class LeetCode_0912_Solution1 {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }
}

/**
 * 减少冒泡排序数据交换次数
 * 超时
 */
class LeetCode_0912_Solution2 {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean switched = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    switched = true;
                }
            }

            if (!switched) {
                return nums;
            }
        }
        return nums;
    }
}

/**
 * 选择排序(不稳定)
 * O(n^2)
 * 超时
 */
class LeetCode_0912_Solution3 {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int min = nums[i];
                int minIndex = i;
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }

                nums[minIndex] = nums[i];
                nums[i] = min;
            }
        }

        return nums;
    }
}

/**
 * 插入排序(稳定)
 * O(n^2)
 * 超时
 */
class LeetCode_0912_Solution4 {
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if(nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        return nums;
    }
}


/**
 * 插入排序(稳定) - 利用赋值（不使用元素交换）
 * O(n^2)
 * 超时
 */
class LeetCode_0912_Solution5 {
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int data = nums[i];
            int j = i;
            for (; j > 0; j--) {
                if(data < nums[j - 1]) {
                    // 相当于大元素往后移动一位
                    nums[j] = nums[j - 1];
                } else {
                    break;
                }
            }
            nums[j] = data;
        }

        return nums;
    }
}

/**
 * 希尔排序
 *      插入排序相对于大规模乱序数组性能较低
 *  思想：先使数组中任意间隔为h的元素（子数组）有序，然后再对全局进行排序
 */
class LeetCode_0912_Solution6 {
    public int[] sortArray(int[] nums) {
        // 1. 计算递增序列
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        int k = 1;
        int h;
        do {
            h = ((int)Math.pow(3, k) - 1) / 2;
            if (h > n / 3) break;
            list.add(h); // 1, 4, 13, 40, 121......
            k++;
        } while (h <= n / 3);

        if (list.isEmpty()) {
            list.add(1);
        }

        // 2. 希尔排序
        for (k = list.size() - 1; k >= 0 ; k--) { // 倒序遍历
            h = list.get(k);
            // 将数组变为 h 有序
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (nums[j] < nums[j - h]) {
                        int temp = nums[j];
                        nums[j] = nums[j - h];
                        nums[j - h] = temp;
                    } else {
                        break;
                    }
                }
            }
        }

        return nums;
    }
}

