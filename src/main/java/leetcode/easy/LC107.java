package leetcode.easy;

import structure.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sky on 2019/7/3
 * --------------------------------------------------
 * 107. Binary Tree Level Order Traversal II
 * --------------------------------------------------
 * Given a binary tree, return the bottom-up level order
 * traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * --------------------------------------------------
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC107 {

    /**
     * 自底向上层次遍历二叉树
     * 具体思路与层次遍历相同，只是利用双端队列将层次遍历结果逆序
     *
     * @param root
     * @return
     * @see leetcode.medium.LC102
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Deque<List<Integer>> results = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int currentLevelNodes = 1;
        int nextLevelNodes = 0;
        List<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            currentLevelNodes--;
            assert node != null;
            result.add(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
                nextLevelNodes++;
            }
            if (node.right != null) {
                queue.addLast(node.right);
                nextLevelNodes++;
            }
            if (currentLevelNodes == 0) {
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
                results.addFirst(result);
                result = new LinkedList<>();
            }
        }
        return (List<List<Integer>>) results;
    }
}
