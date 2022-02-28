package com.usmile.alogrithms.leetcode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 */
public class _0206 {
}

/**
 * 迭代解法
 */
class _0206_Solution1 {
    public ListNode reverseList(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        while (null != current) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}

/**
 * 递归实现
 */
class _0206_Solution2 {
    public ListNode reverseList(ListNode head) {
        // 终止条件
        if (null == head || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList(head.next);
        // 归
        head.next.next = head;
        head.next = null;

        return listNode;
    }
}