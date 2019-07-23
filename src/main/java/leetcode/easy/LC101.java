package leetcode.easy;

import structure.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Sky on 2019/7/3
 * --------------------------------------------------
 * 101. Symmetric Tree
 * --------------------------------------------------
 * Given a binary tree,check whether it is
 * a mirror of itself (ie, symmetric around its center).
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC101 {

    /**
     * 基于层次遍历以及双端队列判断树是否对称
     * 具体思路：
     * 层次遍历时，同时取堆头和队尾的元素
     * 如果堆头和队尾元素不相同则该树不对称
     * 如果堆头队尾元素相同，但是左右孩子是否存在不具有对称性
     * 则该树不对称
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.addFirst(root.left);
        nodeDeque.addLast(root.right);
        while (!nodeDeque.isEmpty()) {
            TreeNode first = nodeDeque.pollFirst();
            TreeNode last = nodeDeque.pollLast();
            if (first == null && last == null) {
                continue;
            }
            /* 如果堆头队尾元素不相同则不对称 */
            if (first.val != last.val) {
                return false;
            }
            /* 左右孩子是否存在不具有对称性则不对称 */
            if ((first.left == null && last.right != null)
                    || (first.left != null && last.right == null)) {
                return false;
            }
            if ((first.right == null && last.left != null) ||
                    (first.right != null && last.left == null)) {
                return false;
            }
            nodeDeque.addFirst(first.left);
            nodeDeque.addLast(last.right);
            nodeDeque.addFirst(first.right);
            nodeDeque.addLast(last.left);
        }
        return true;
    }

}
