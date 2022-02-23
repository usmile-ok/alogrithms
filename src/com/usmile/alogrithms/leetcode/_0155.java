package com.usmile.alogrithms.leetcode;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 */
public class _0155 {
    public static void main(String[] args) {
        _0155_Solution1 stack = new _0155_Solution1();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}

class _0155_Solution1 {
    private final Stack<Integer> dataStack = new Stack<>();

    private final Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        if (dataStack.isEmpty()) {
            dataStack.push(val);
            minStack.push(val);
        } else {
            dataStack.push(val);
            int min = minStack.peek();
            if (val <= min) {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        if (dataStack.isEmpty()) {
            return;
        }

        int pop = dataStack.pop();
        int min = minStack.peek();
        if (pop == min) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


class _0155_Solution2 {
    private final Stack<Node> dataStack = new Stack<>();

    private static class Node {
        int value;
        int min;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    public void push(int val) {
        if (dataStack.isEmpty()) {
            dataStack.push(new Node(val, val));

            return;
        }

        Node top = dataStack.peek();
        if (val < top.min) {
            dataStack.push(new Node(val, val));
        } else {
            dataStack.push(new Node(val, top.min));
        }
    }

    public void pop() {
        if (dataStack.isEmpty()) {
            return;
        }
        dataStack.pop();
    }

    public int top() {
        return dataStack.peek().value;
    }

    public int getMin() {
        return dataStack.peek().min;
    }
}
