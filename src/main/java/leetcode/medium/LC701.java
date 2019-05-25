package leetcode.medium;

import structure.tree.TreeNode;

/**
 * Created by Sky on 2019/1/7
 *
 * @author Sky
 */
public class LC701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode();
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
