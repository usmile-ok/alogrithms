package com.usmile.alogrithms.leetcode;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
public class _0203 {
}


class _0203_Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        if (null == head) {
            return null;
        }

        // 哨兵节点
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
                current.next = null;
                current = prev.next;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}