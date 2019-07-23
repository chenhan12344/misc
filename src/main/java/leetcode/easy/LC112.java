package leetcode.easy;

import structure.tree.TreeNode;

/**
 * Created by Sky on 2019/7/3
 * --------------------------------------------------
 * 112. Path Sum
 * --------------------------------------------------
 * Given a binary tree and a sum,
 * determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC112 {

    /**
     * 判断树中是否存在路径，使得路径为给定的值
     * 基本思想：
     * 先将给定值减去树根的值，如果为0且当前树根为叶子节点，则路径存在
     * 否则递归在左右子树寻找
     *
     * @param root 树根
     * @param sum  给定路径和
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int nextSum = sum - root.val;
        if (nextSum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, nextSum) || hasPathSum(root.right, nextSum);
    }

}
