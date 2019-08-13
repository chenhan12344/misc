package leetcode.easy;

import structure.tree.TreeNode;

/**
 * Created by Sky on 2019/7/3
 * --------------------------------------------------
 * 108. Convert Sorted Array to Binary Search Tree
 * --------------------------------------------------
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * --------------------------------------------------
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC108 {

    /**
     * 将有序数组转换为二叉排序树
     * 思路：
     * 由于二叉排序树属于AVL树，所以将数组中的值作为根节点
     * 然后剩余两侧的子区间分别递归构建子树作为左右子树
     *
     * @param nums 数组
     * @return 二叉排序树树根
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * 构建BST的辅助函数
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }

}
