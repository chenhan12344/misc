package leetcode.medium;

import structure.tree.TreeNode;
import structure.tree.TreeUtils;

/**
 * Created by 44399 on 2019/5/25
 *
 * @author 44399
 */
public class LC337 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinaryTree(3, 4, 5, 1, 3, null, 1);
        System.out.println(new LC337().rob(root));
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int dpRoot = root.val;
        if (root.left != null) {
            dpRoot += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            dpRoot += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(dpRoot, rob(root.left) + rob(root.right));
    }
}
