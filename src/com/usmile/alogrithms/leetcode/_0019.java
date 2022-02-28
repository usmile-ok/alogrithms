package com.usmile.alogrithms.leetcode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class _0019 {
}


/**
 * 迭代（哨兵）
 */
class _0019_Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while (null != temp) {
            temp = temp.next;
            length++;
        }

        // 哨兵节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < length - n; i++) {
            prev = prev.next;
        }

        ListNode deleteNode = prev.next;
        prev.next = deleteNode.next;
        deleteNode.next = null;

        return dummy.next;
    }
}

/**
 * 快慢指针思想
 */
class _0019_Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 哨兵节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode temp = slow.next;
        slow.next  = temp.next;
        temp.next = null;

        return dummy.next;
    }
}