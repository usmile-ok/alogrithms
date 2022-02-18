package com.usmile.alogrithms.leetcode;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class LeetCode_0070 {
}

/**
 * 递归， 超时
 * O(n*n)
 */
class LeetCode_0070_Solution1 {
    public int climbStairs(int n) {
        if (0 == n || 1 == n) {
            return 1;
        }
        if (2 == n) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}