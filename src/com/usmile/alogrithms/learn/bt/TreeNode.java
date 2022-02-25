package com.usmile.alogrithms.learn.bt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }


    // 前序遍历
    public static <T> List<T> preOrder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<TreeNode<T>> nodeStack = new Stack<>();
        nodeStack.push(root);

        while(!nodeStack.isEmpty()) {
            TreeNode<T> pop = nodeStack.pop();
            result.add(pop.value);
            if (null != pop.right) {
                nodeStack.push(pop.right);
            }
            if (null != pop.left) {
                nodeStack.push(pop.left);
            }
        }

        return result;
    }

    public static <T> List<T> midOrder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<TreeNode<T>> nodeStack = new Stack<>();

        if (null != root.left) {
            nodeStack.push(root.left);
        } else {
            nodeStack.push(root);
        }

        while(!nodeStack.isEmpty()) {
            TreeNode<T> pop = nodeStack.pop();
            if (null != pop.left) {
                nodeStack.push(pop.left);
            } else {

            }
            if (null != pop.right) {
                nodeStack.push(pop.right);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node8 = new TreeNode<>(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;

        List<Integer> integers = TreeNode.preOrder(node1);

        System.out.println(integers);

    }
}


