import structure.tree.TreeNode;
import structure.tree.TreeUtils;

import java.util.Arrays;

/**
 * Created by Sky on 2019/3/30
 *
 * @author Sky
 */
public class Sample1 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildCompleteBinaryTree(
                Arrays.asList(3, 4, 5, 1, 3, null, 1));
        System.out.println(new Sample1().robTree(root));
    }

    public int robTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int dpRoot = root.val;
        if (root.left != null) {
            dpRoot += robTree(root.left.left) + robTree(root.left.right);
        }
        if (root.right != null) {
            dpRoot += robTree(root.right.left) + robTree(root.right.right);
        }
        return Math.max(dpRoot, robTree(root.left) + robTree(root.right));
    }

}