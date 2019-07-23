package leetcode.medium;

import structure.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sky on 2019/7/3
 * --------------------------------------------------
 * 102. Binary Tree Level Order Traversal
 * --------------------------------------------------
 * Given a binary tree, return the level order traversal
 * of its nodes' values.
 * (ie, from left to right, level by level).
 * --------------------------------------------------
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC102 {

    /**
     * 基于队列实现树的层次遍历
     *
     * @param root 树根
     * @return 遍历结果
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> results = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        /* 记录当前层待遍历的节点数 */
        int currentLevelNodes = 1;
        /* 记录下一层需要遍历的节点数 */
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
                results.add(result);
                result = new LinkedList<>();
            }
        }
        return results;
    }
}
