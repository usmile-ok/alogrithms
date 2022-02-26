package com.usmile.alogrithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 * <p>
 * <p>
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0100 {
}

/**
 * 直接遍历（BFS）
 */
class _0100_Solution1 {
    @SuppressWarnings("all")
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode curr1 = queue1.poll();
            TreeNode curr2 = queue2.poll();
            if (curr1.val != curr2.val) {
                return false;
            }

            if (null == curr1.left ^ null == curr2.left) {
                return false;
            }
            if (null == curr1.right ^ null == curr2.right) {
                return false;
            }
//            if ((null == curr1.left && null != curr2.left) || (null != curr1.left && null == curr2.left)) {
//                return false;
//            }
//            if ((null == curr1.right && null != curr2.right) || (null != curr1.right && null == curr2.right)) {
//                return false;
//            }

            if (curr1.left != null && curr2.left != null) {
                queue1.offer(curr1.left);
                queue2.offer(curr2.left);
            }
            if (curr1.right != null && curr2.right != null) {
                queue1.offer(curr1.right);
                queue2.offer(curr2.right);
            }
        }
        if (!queue1.isEmpty() || !queue2.isEmpty()) {
            return false;
        }

        return true;
    }
}

/**
 * DFS（递归）
 */
class _0100_Solution2 {
    @SuppressWarnings("all")
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;
    }
}
