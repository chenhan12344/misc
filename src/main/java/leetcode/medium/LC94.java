package leetcode.medium;

import structure.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sky on 2019/8/26
 * --------------------------------------------------
 * 94. Binary Tree Inorder Traversal
 * --------------------------------------------------
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC94 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(5), null), new TreeNode(3, null, new TreeNode(4)));
        System.out.println(new LC94().inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        stack.push(root);
        TreeNode p = root.left;
        while (!stack.isEmpty() || (p != null)) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            result.add((p = stack.pop()).val);
            p = p.right;
        }
        return result;
    }
}
