package com.usmile.alogrithms.leetcode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class _0104 {
}


/**
 * 前序遍历（DFS）
 */
class _0104_Solution1 {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Stack<NodeDepth> nodeStack = new Stack<>();
        nodeStack.push(new NodeDepth(root, 1));
        int maxDepth = 0;
        while (!nodeStack.isEmpty()) {
            NodeDepth current = nodeStack.pop();
            if (maxDepth < current.depth) {
                maxDepth = current.depth;
            }
            if (null != current.node.right) {
                nodeStack.push(new NodeDepth(current.node.right, current.depth + 1));
            }
            if (null != current.node.left) {
                nodeStack.push(new NodeDepth(current.node.left, current.depth + 1));
            }
        }

        return maxDepth;
    }

    private static class NodeDepth {
        TreeNode node;
        int depth;

        public NodeDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

/**
 * BFS
 */
class _0104_Solution2 {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            maxDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (null != current.left) {
                    queue.offer(current.left);
                }
                if (null != current.right) {
                    queue.offer(current.right);
                }
            }
        }

        return maxDepth;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

/**
 * DFS + 递归
 */
class _0104_Solution3 {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}