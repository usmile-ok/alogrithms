package com.usmile.alogrithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class _0101 {
}


/**
 * 递归
 */
class _0101_Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }

        // 判断root左右子树是否对称
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }
}

/**
 * 迭代(层序遍历BFS)
 */
class _0101_Solution2 {
    @SuppressWarnings("all")
    public boolean isSymmetric(TreeNode root) {
        if (null == root || (null == root.left && null == root.right)) {
            return true;
        }
        if (null == root.left ^ null == root.right) {
            return false;
        }

        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;

        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(leftRoot);
        rightQueue.offer(rightRoot);

        while(!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftCurr = leftQueue.poll();
            TreeNode rightCurr = rightQueue.poll();
            if (leftCurr.val != rightCurr.val) {
                return false;
            }
            if (null == leftCurr.right ^ null == rightCurr.left) {
                return false;
            }
            if (null == leftCurr.left ^ null == rightCurr.right) {
                return false;
            }

            if (null != leftCurr.left) {
                leftQueue.offer(leftCurr.left);
                rightQueue.offer((rightCurr.right));
            }

            if (null != leftCurr.right) {
                leftQueue.offer(leftCurr.right);
                rightQueue.offer((rightCurr.left));
            }
        }

        return true;
    }
}