package com.usmile.alogrithms.leetcode;

/**
 * 1095. 山脉数组中查找目标值
 * （这是一个 交互式问题 ）
 * <p>
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 * <p>
 * 如果不存在这样的下标 index，就请返回 -1。
 * <p>
 * <p>
 * <p>
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 * <p>
 * 首先，A.length >= 3
 * <p>
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 * <p>
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * <p>
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 * <p>
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
 * <p>
 * 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：array = [1,2,3,4,5,3,1], target = 3
 * 输出：2
 * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
 * 示例 2：
 * <p>
 * 输入：array = [0,1,2,4,2,1], target = 3
 * 输出：-1
 * 解释：3 在数组中没有出现，返回 -1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= mountain_arr.length() <= 10000
 * 0 <= target <= 10^9
 * 0 <= mountain_arr.get(index) <= 10^9
 */
public class _1095 {
    public static void main(String[] args) {
    }
}

class _1095_Solution_1 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;

        // 先找到山顶
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int topIndex = right;

        // 先查左边
        left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            if (mountainArr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 如果左边没有，再查右边
        left = topIndex;
        right = mountainArr.length() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            if (mountainArr.get(mid) > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

interface MountainArray {
    int get(int index);

    int length();
}