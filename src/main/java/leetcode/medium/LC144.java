package leetcode.medium;

import structure.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sky on 2019/8/26
 * --------------------------------------------------
 * 144. Binary Tree Preorder Traversal
 * --------------------------------------------------
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC144 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(5), null), new TreeNode(3,null,new TreeNode(4)));
        System.out.println(new LC144().preorderTraversal(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        result.add(root.val);
        TreeNode p = root.left;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                result.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop().right;
        }
        return result;
    }
}
