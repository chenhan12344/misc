package structure.tree;

/**
 * Created by 44399 on 2019/2/13
 *
 * @author 44399
 */
public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {

    }

    public BinarySearchTree(int... nums) {

    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int val) {
        if (this.root == null) {
            this.root = new TreeNode(val);
            return;
        }
        TreeNode treeNode = root, parent = root;
        while (treeNode != null) {
            parent = treeNode;
            treeNode = val < parent.val ? parent.left : parent.right;
        }
        if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }
    }

    public boolean remove(int val) {
        return false;
    }

    public TreeNode search(int val) {
        return null;
    }
}
