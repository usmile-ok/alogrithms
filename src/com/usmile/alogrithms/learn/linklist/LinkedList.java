package com.usmile.alogrithms.learn.linklist;

public class LinkedList {
    Node head;
    Node tail; // 单向链表没有必要添加尾节点

    public static class Node {
        int value;
        Node next;
    }

    public void add(int value) {
        Node node = new Node();
        node.value = value;

        if (null == head) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    // 未指定前驱节点删除元素
    public void remove(int value) {
        Node temp = head;
        // 需要对记录删除节点的前驱节点
        Node prev = null;
        while (null != temp && temp.value != value) {
            prev = temp;
            temp = temp.next;
        }

        // 如果temp节点不为null，表示找到需要删除的节点
        if (null != temp) {
            // 需要删除的节点为头节点
            if (null == prev) {
                // 如果只有一个节点
                if (head == tail) {
                    head = tail = null;
                } else {
                    head = head.next;
                }
            } else {
                // 如果删除为尾节点，需要重置
                if (temp == tail) {
                    tail = prev;
                }
                prev.next = temp.next;
            }
        }
    }
}
