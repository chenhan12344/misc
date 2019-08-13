package leetcode.easy;

import structure.tree.TreeNode;
import structure.tree.TreeUtils;

import java.util.LinkedList;
import java.util.List;

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

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinaryTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5);
        List<String> result = new LC112().hasPathSum(root, 22);
        System.out.println(String.join("->", result));
    }

    /**
     * 判断树中是否存在路径，使得路径为给定的值
     * 基本思想：
     * 先将给定值减去树根的值，如果为0且当前树根为叶子节点，则路径存在
     * 否则递归在左右子树寻找
     *
     * @param root 树根
     * @param sum  给定路径和
     */
    public List<String> hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<String> result = new LinkedList<>();
        if (sum == root.val) {
            result.add(String.valueOf(root.val));
            return result;
        }
        int nextSum = sum - root.val;
        List<String> nextResult;
        if (!(nextResult = hasPathSum(root.left, nextSum)).isEmpty()) {
            result.addFirst(String.valueOf(root.val));
            result.addAll(nextResult);
            return result;
        }
        if (!(nextResult = hasPathSum(root.right, nextSum)).isEmpty()) {
            result.addFirst(String.valueOf(root.val));
            result.addAll(nextResult);
            return result;
        }
        return result;
    }
}
