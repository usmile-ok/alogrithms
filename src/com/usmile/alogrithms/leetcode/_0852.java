package com.usmile.alogrithms.leetcode;

/**
 * 852. 山脉数组的峰顶索引
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 * <p>
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 * <p>
 * <p>
 * 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 */
public class _0852 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,1};
        int i = new _0852_Solution2().peakIndexInMountainArray(arr);
        System.out.println(i);
    }
}

/**
 * 迭代
 */
class _0852_Solution1 {
    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                return i;
            }
        }

        return arr.length - 1;
    }
}

/**
 * 二分查找
 */
class _0852_Solution2 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[left] && arr[mid] > arr[right]) {
                left++;
                right--;
            } else if (arr[mid] <= arr[left] && arr[mid] >= arr[right]) {
                right = mid;
            } else if (arr[mid] >= arr[left] && arr[mid] <= arr[right]) {
                left = mid;
            }
        }

        return arr[left] > arr[right] ? left : right;
    }
}


/**
 * 二分， 判断mid + 1 与mid元素大小
 */
class _0852_Solution3 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid +1]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return arr[left] > arr[right] ? left : right;
    }
}


