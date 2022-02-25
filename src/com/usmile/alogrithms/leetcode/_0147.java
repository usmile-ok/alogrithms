package com.usmile.alogrithms.leetcode;

/**
 * 147. 对链表进行插入排序
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 * <p>
 * 插入排序 算法的步骤:
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
 * <p>
 * 对链表进行插入排序。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: head = [4,2,1,3]
 * 输出: [1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: head = [-1,5,3,4,0]
 * 输出: [-1,0,3,4,5]
 */
public class _0147 {
}


class _0147_Solution1 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode current = head.next;
        ListNode prev = head;
        while (null != current) {
            if (prev.val > current.val) {
                ListNode swapPrev = dummy;
                ListNode swap = dummy.next;
                while (swap.val <= current.val) {
                    swapPrev = swap;
                    swap = swap.next;
                }
//                ListNode swapPrev = dummy;
//                while (swapPrev.next.val <= current.val) {
//                    swapPrev = swapPrev.next;
//                }

                ListNode mid = swapPrev.next;
                swapPrev.next = current;
                ListNode temp = current.next;
                prev.next = temp;
                current.next = mid;
                current = temp;
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