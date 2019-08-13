import structure.tree.TreeNode;

/**
 * Created by Sky on 2019/8/6
 *
 * @author Sky
 */
public class MiscTest {

    public static void main(String[] args) {
        Integer integer = new Integer(1);
        inc(integer);
        System.out.println(integer);
    }

    private static void inc(Integer integer) {
        integer += 1;
    }

    public boolean isBalancedTree(TreeNode root) {
        return helper(root, 0);
    }

    private boolean helper(TreeNode root, Integer depth) {
        if (root == null) {
            depth = 0;
            return true;
        }
        Integer leftDepth = 0, rightDepth = 0;
        if (helper(root.left, leftDepth) && helper(root.right, rightDepth)) {
            if (Math.abs(leftDepth - rightDepth) < 2) {
                depth = 1 + Math.max(leftDepth, rightDepth);
                return true;
            }
        }
        return false;
    }
}
