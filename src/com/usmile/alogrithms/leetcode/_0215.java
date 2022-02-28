package com.usmile.alogrithms.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class _0215 {
}

/**
 * 使用大顶堆
 */
@SuppressWarnings("all")
class _0215_Solution1 {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        PriorityQueue<Integer> queue;
        if (k < nums.length - k) {
            queue = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    queue.offer(nums[i]);
                } else {
                    if (nums[i] > queue.peek()) {
                        queue.remove();
                        queue.offer(nums[i]);
                    }
                }
            }
        } else {
            queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int i = 0; i < length; i++) {
                if (i < length - k + 1) {
                    queue.offer(nums[i]);
                } else {
                    if (nums[i] < queue.peek()) {
                        queue.remove();
                        queue.offer(nums[i]);
                    }
                }
            }
        }
        return queue.peek();
    }
}

/**
 * 使用排序
 */
class _0215_Solution2 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}

/**
 * 使用快排
 */
class _0215_Solution3 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}
