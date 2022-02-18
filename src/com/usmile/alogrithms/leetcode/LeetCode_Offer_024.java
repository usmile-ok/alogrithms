package com.usmile.alogrithms.leetcode;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class LeetCode_Offer_024 {
}

class LeetCode_Offer_024_Solution1 {
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        while (null != current) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}

class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}