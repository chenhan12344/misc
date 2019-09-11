package offer;

import structure.tree.TreeNode;

/**
 * Created by Sky on 2019/6/27
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * 注：空树不是任意一个树的子结构
 *
 * @author Sky
 */
public class SubTreeOfAnotherTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8, null, new TreeNode(8, null, new TreeNode(9, null, new TreeNode(2, null, new TreeNode(5, null, null)))));
        TreeNode root2 = new TreeNode(8, null, new TreeNode(9, new TreeNode(3), new TreeNode(2)));
        System.out.println(new SubTreeOfAnotherTree().isSubtree(root1, root2));

    }


    /**
     * 判断树B是否是A的子树
     *
     * @param root1 A的树根
     * @param root2 B的树根
     * @return
     */
    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        return helper(root1, root2, false);
    }

    private static boolean helper(TreeNode root1, TreeNode root2, boolean isRecursive) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val && isRecursive) {
            return false;
        }
        if (root1.val == root2.val) {
            boolean isSubTree = true;
            if (root2.left != null) {
                isSubTree = helper(root1.left, root2.left, true);
            }
            if (root2.right != null) {
                isSubTree = isSubTree && helper(root1.right, root2.right, true);
            }
            if (isSubTree) {
                return true;
            }
        }
        return helper(root1.left, root2, false) || helper(root1.right, root2, false);
    }
}
