package com.usmile.alogrithms.leetcode;

import java.util.Stack;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * 示例 3：
 * <p>
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 */
public class _0112 {
}

/**
 * 前序遍历，并记录所到节点路径和
 */
class _0112_Solution1 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        Stack<NodeSum> nodeStack = new Stack<>();
        nodeStack.push(new NodeSum(root, root.val));
        while (!nodeStack.isEmpty()) {
            NodeSum current = nodeStack.pop();
            if (null == current.node.left && null == current.node.right) {
                if (current.sum == targetSum) {
                    return true;
                }
            }
            if (null != current.node.right) {
                nodeStack.push(new NodeSum(current.node.right, current.sum + current.node.right.val));
            }
            if (null != current.node.left) {
                nodeStack.push(new NodeSum(current.node.left, current.sum + current.node.left.val));
            }
        }


        return false;
    }


    private static class NodeSum {
        TreeNode node;
        int sum;

        public NodeSum(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }
}

/**
 * 记录路径剩余和
 */
class _0112_Solution2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        Stack<NodeSum> nodeStack = new Stack<>();
        nodeStack.push(new NodeSum(root, targetSum - root.val));
        while (!nodeStack.isEmpty()) {
            NodeSum current = nodeStack.pop();
            if (null == current.node.left && null == current.node.right) {
                if (current.sum == 0) {
                    return true;
                }
            }
            if (null != current.node.right) {
                nodeStack.push(new NodeSum(current.node.right, current.sum - current.node.right.val));
            }
            if (null != current.node.left) {
                nodeStack.push(new NodeSum(current.node.left, current.sum - current.node.left.val));
            }
        }


        return false;
    }


    private static class NodeSum {
        TreeNode node;
        int sum;

        public NodeSum(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }
}


/**
 * 递归实现
 */
class _0112_Solution3 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        if (null == root.left && null == root.right) {
            return targetSum - root.val == 0;
        }

        boolean left = hasPathSum(root.left, targetSum - root.val);
        if (left) {
            return true;
        }
        return hasPathSum(root.right, targetSum - root.val);
    }
}