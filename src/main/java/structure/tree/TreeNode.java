package structure.tree;

/**
 * Created by Sky on 2019/1/22
 *
 * @author Sky
 */
public class TreeNode {

    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
