package leetcode.easy;

import structure.tree.TreeNode;

/**
 * Created by Sky on 2019/8/26
 * --------------------------------------------------
 * 572. Subtree of Another Tree
 * --------------------------------------------------
 * Given two non-empty binary trees s and t,
 * check whether tree t has exactly the same
 * structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in
 * s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC572 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3, new TreeNode(4, new TreeNode(1), null), new TreeNode(5, new TreeNode(2), null));
        TreeNode root2 = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        System.out.println(new LC572().isSubtree(root1, root2));
    }

    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }
        return helper(root1, root2) || isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        return (root1.val == root2.val) && helper(root1.left, root2.left) && helper(root1.right, root2.right);
    }
}
