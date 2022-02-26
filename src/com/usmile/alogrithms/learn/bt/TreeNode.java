package com.usmile.alogrithms.learn.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
    }

    // 前序遍历（利用栈的特性）-- 迭代
    public static <T> List<T> preOrder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<TreeNode<T>> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            TreeNode<T> pop = nodeStack.pop();
            result.add(pop.data);
            if (null != pop.right) {
                nodeStack.push(pop.right);
            }
            if (null != pop.left) {
                nodeStack.push(pop.left);
            }
        }

        return result;
    }

    // 前序遍历（利用栈的特性）-- 递归
    public static <T> List<T> preOrderR(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        result.add(root.data);
        result.addAll(preOrderR(root.left));
        result.addAll(preOrder(root.right));

        return result;
    }

    // 中序遍历 - 迭代
    public static <T> List<T> midOrder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<TreeNode<T>> nodeStack = new Stack<>();

        TreeNode<T> current = root;
        while (current != null || !nodeStack.isEmpty()) {
            while (null != current) {
                nodeStack.push(current);
                current = current.left;
            }

            TreeNode<T> pop = nodeStack.pop();
            result.add(pop.data);

            // 需要看一下右节点
            current = pop.right;
        }

        return result;
    }

    // 中序遍历 - 递归
    public static <T> List<T> midOrderR(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        result.addAll(midOrderR(root.left));
        result.add(root.data);
        result.addAll(midOrderR(root.right));

        return result;
    }

    // 后序遍历
    // 思考为什么要对结果进行翻转
    public static <T> List<T> postOrder(TreeNode<T> root) {
        ArrayList<T> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<TreeNode<T>> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            TreeNode<T> pop = nodeStack.pop();
            result.add(0, pop.data);
//            result.add(pop.data);
            if (null != pop.left) {
                nodeStack.push(pop.left);
            }
            if (null != pop.right) {
                nodeStack.push(pop.right);
            }
        }
//        Collections.reverse(result);
        return result;
    }

    // 后序遍历 - 递归
    public static <T> List<T> postOrderR(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        result.addAll(postOrderR(root.left));
        result.addAll(postOrderR(root.right));
        result.add(root.data);

        return result;
    }

    // 层序遍历
    // 利用队列先进先出辅助遍历
    public static <T> List<T> levelOrder(TreeNode<T> root) {
        ArrayList<T> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            result.add(current.data);
            if (null != current.left) {
                queue.offer(current.left);
            }
            if (null != current.right) {
                queue.offer(current.right);
            }
        }

        return result;
    }

    // 层序遍历  - 每层元素单独保存
    // 利用队列先进先出辅助遍历
    public static <T> List<List<T>> levelOrder1(TreeNode<T> root) {
        ArrayList<List<T>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 保存当前层的元素
            List<T> levels = new ArrayList<>();
            // 通过当层元素个数从队列取出元素
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode<T> current = queue.poll();
                levels.add(Objects.requireNonNull(current).data);
                if (null != current.left) {
                    queue.offer(current.left);
                }
                if (null != current.right) {
                    queue.offer(current.right);
                }
            }

            result.add(levels);
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

        List<Integer> integers = TreeNode.postOrderR(node1);

        System.out.println(integers);

    }
}


