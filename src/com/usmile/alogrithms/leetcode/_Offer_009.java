package com.usmile.alogrithms.leetcode;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */
public class _Offer_009 {
    public static void main(String[] args) {

    }
}


class CQueue1 {
    Stack<Integer> left = new Stack<>();

    Stack<Integer> right = new Stack<>();

    public void appendTail(int value) {
        if (!right.isEmpty()) {
            while(!right.isEmpty()) {
                left.push(right.pop());
            }
        }
        left.push(value);
    }

    public int deleteHead() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }
        if (right.isEmpty()) {
            while(!left.isEmpty()) {
                right.push(left.pop());
            }
        }

        return right.pop();
    }
}

/**
 * 优化appendTail
 */
class CQueue2 {
    Stack<Integer> left = new Stack<>();

    Stack<Integer> right = new Stack<>();

    // 追加的时候只需要追加到left
    public void appendTail(int value) {
        left.push(value);
    }

    public int deleteHead() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }
        if (right.isEmpty()) {
            while(!left.isEmpty()) {
                right.push(left.pop());
            }
        }

        return right.pop();
    }
}