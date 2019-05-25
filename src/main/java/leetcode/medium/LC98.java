package leetcode.medium;

import structure.tree.TreeNode;
import structure.tree.TreeUtils;

/**
 * Created by 44399 on 2019/2/13
 *
 * @author 44399
 */
public class LC98 {

    public static void main(String[] args) {
        System.out.println(new LC98().isValidBST(
                TreeUtils.buildCompleteBinaryTree(2, 1, 3)
        ));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.left.val >= root.val) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.val <= root.val) {
                return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left, right;
        while (true) {
            left = root.left;
            right = root.right;
            if (left != null) {

            }

        }
    }
}
