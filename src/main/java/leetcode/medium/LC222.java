package leetcode.medium;

import structure.tree.TreeNode;
import structure.tree.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sky on 2019/6/21
 *
 * @author Sky
 */
public class LC222 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinaryTree(

        );
        System.out.println(new LC222().countNodes(root));
    }

    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode treeNode;
        int nodes = 0;
        while ((treeNode = queue.poll()) != null) {
            nodes++;
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return nodes;
    }


}
