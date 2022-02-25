package com.usmile.alogrithms.leetcode;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 */
public class _0023 {
}

/**
 * 顺序合并
 */
class _0023_Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }

        return result;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (null != list1 && null != list2) {
            if (list1.val > list2.val) {
                prev.next = list2;
                list2 = list2.next;
            } else {
                prev.next = list1;
                list1 = list1.next;
            }

            prev = prev.next;
        }
        if (null != list1) {
            prev.next = list1;
        }
        if (null != list2) {
            prev.next = list2;
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
 * 利用分治思想（类似归并排序）
 */
class _0023_Solution2 {
    public ListNode mergeLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        return mergeLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left)/ 2;
        // 合并左节点
        ListNode leftNode = mergeLists(lists, left, mid);
        // 合并右节点
        ListNode rightNode = mergeLists(lists, mid + 1, right);

        // 合并左右节点
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (null != leftNode && null != rightNode) {
            if (leftNode.val > rightNode.val) {
                prev.next = rightNode;
                rightNode = rightNode.next;
            } else {
                prev.next = leftNode;
                leftNode = leftNode.next;
            }
            prev = prev.next;
        }
        if (null != leftNode) {
            prev.next = leftNode;
        }
        if (null != rightNode) {
            prev.next = rightNode;
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