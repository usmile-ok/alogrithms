package com.usmile.alogrithms.leetcode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 */
public class _0148 {
}


/**
 * 归并排序，自顶向下
 */
class _0148_Solution1 {
    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        // 查找中间节点
        ListNode slow = head;
        ListNode fast = head.next;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;

        // 合并左边
        ListNode left = sortList(head);
        // 合并右边
        ListNode right = sortList(rightHead);

        // 合并
        ListNode dummy = new ListNode(-1);
        ListNode merged = dummy;
        while (null != left && null != right) {
            if (left.val > right.val) {
                merged.next = right;
                right = right.next;
            } else {
                merged.next = left;
                left = left.next;
            }

            merged = merged.next;
        }

        if (null != left) {
            merged.next = left;
        }
        if (null != right) {
            merged.next = right;
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

/**
 * 归并排序，自底朝上
 */
class _0148_Solution2 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 计算链表的长度
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        // bug 修复：step 从 1 开始，而不是从 0 开始
        for (int step = 1; step < length; step <<= 1) {
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, step);
                // 分割得到下次处理的链表头
                curr = split(right, step);
                // 合并 left 和 right 链表
                prev = merge(left, right, prev);
            }
        }

        return dummy.next;
    }
    // 合并 left 和 right 两个有序链表
    // 将 prev.next 设置为合并之后链表的表头
    // 返回合并之后链表的最后一个节点
    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        ListNode curr = prev;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left == null) curr.next = right;
        if (right == null) curr.next = left;
        // 保证 curr 是合并之后链表的最后一个节点
        // bug 修复：使用 while 循环找到最后一个节点
        while (curr.next != null) curr = curr.next;
        return curr;
    }

    // 将 node 从第 step 个节点切断，并返回右边链表的头节点
    private ListNode split(ListNode node, int step) {
        if (node == null) return null;
        // 找到分割点
        for (int i = 1; node.next != null && i < step; i++) {
            node = node.next;
        }
        ListNode right = node.next;
        node.next = null;

        return right;
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