package com.usmile.alogrithms.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 252. 会议室
 * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判断一个人是否能够参加这里面的全部会议。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：false
 * 示例 2：
 *
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：true
 */
public class _0252 {
}

/**
 * 先按照会议开始时间进行排序
 */
class _0252_Solution1 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval-> interval[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }

        return true;
    }
}