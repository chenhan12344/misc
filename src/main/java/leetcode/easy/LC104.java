package leetcode.easy;

import structure.tree.TreeNode;
import structure.tree.TreeUtils;

/**
 * Created by Sky on 2019/7/3
 * --------------------------------------------------
 * 104. Maximum Depth of Binary Tree
 * --------------------------------------------------
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the
 * longest path from the root node down to the farthest leaf node.
 * --------------------------------------------------
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 * return its depth = 3.
 * --------------------------------------------------
 *
 * @author Sky
 */

public class LC104 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinaryTree(3, 9, 20, null, null, 15, 7);
        System.out.println(new LC104().maxDepth(root));
    }

    /**
     * 递归求解二叉树最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
