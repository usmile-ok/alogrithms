package com.usmile.alogrithms.linklist;

/**
 * 翻转链表
 */
public class LinkedList_Reverse {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = reverseList(node1);
        System.out.println("End..." + listNode);
    }

    private static ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        // 第一次翻转，原链表的头节点next为null
        ListNode prev = null;
        // 从原链表头节点开始翻转
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

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}




