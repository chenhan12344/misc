package leetcode.easy;

import structure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sky on 2019/7/3
 * --------------------------------------------------
 * 111. Minimum Depth of Binary Tree
 * --------------------------------------------------
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the
 * shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC111 {

    /**
     * 计算一棵树的最小高度（最小高度为树根到最近一个叶子节点的之间高度）
     * 基本思想：
     * 进行层次遍历，如果遍历遇到一个叶子节点则返回该叶子节点的深度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int depth = 1, currentLevelCount = 1, nextLevelCount = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            currentLevelCount--;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                nextLevelCount++;
                nodeQueue.add(node.left);
            }
            if (node.right != null) {
                nextLevelCount++;
                nodeQueue.add(node.right);
            }
            if (currentLevelCount == 0) {
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
                depth++;
            }
        }
        return depth;
    }
}
