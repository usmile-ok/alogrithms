package com.usmile.alogrithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 */
public class _226 {
}

/**
 * 层序遍历(BFS), 翻转每一个节点
 */
class _226_Solution1 {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (null != curr.left) {
                queue.offer(curr.left);
            }
            if (null != curr.right) {
                queue.offer(curr.right);
            }
        }

        return root;
    }
}

/**
 * 递归(DFS)
 */
@SuppressWarnings("all")
class _226_Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}