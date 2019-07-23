package leetcode.easy;

import structure.tree.TreeNode;
import structure.tree.TreeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sky on 2019/7/3
 * --------------------------------------------------
 * 110. Balanced Binary Tree
 * --------------------------------------------------
 * Given a binary tree, determine if it is height-balanced.
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC110 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinaryTree(1, 2, 2, 3, null, null, 3, 4, null, null, 4);
        System.out.println(new LC110().isBalanced(root));
    }

    private static Map<Integer, Integer> cache = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getTreeDepth(root.left) - getTreeDepth(root.right)) < 2) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    private static int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hashCode = root.hashCode();
        if (cache.containsKey(hashCode)) {
            return cache.get(hashCode);
        }
        int depth = 1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
        cache.put(hashCode, depth);
        return depth;
    }
}
