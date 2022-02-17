package com.usmile.alogrithms.leetcode;


import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class LeetCode_20 {
    public static void main(String[] args) {
        String in = "()[]{}";
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isValid(in));
    }
}

class Solution1 {
    public boolean isValid(String s) {
        int length = s.length();
        if (0 != length % 2) {
            return false;
        }

        int mid = length / 2;

        for (int i = 0; i < mid; i++) {
            char left = s.charAt(mid - 1 - i);
            char right = s.charAt(mid + i);
            if (left == '(') {
                if (right != ')') {
                    return false;
                }
            } else if (left == '{') {
                if (right != '}') {
                    return false;
                }
            } else if (left == '[') {
                if (right != ']') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}


