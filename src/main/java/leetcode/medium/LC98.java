package leetcode.medium;

import structure.tree.TreeNode;
import structure.tree.TreeUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by 44399 on 2019/2/13
 * --------------------------------------------------
 * 98. Validate Binary Search Tree
 * --------------------------------------------------
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * --------------------------------------------------
 *
 * @author 44399
 */
public class LC98 {

    public static void main(String[] args) {
        System.out.println(new LC98().isValidBST(
                TreeUtils.buildBinaryTree(2, 1, 3)
        ));
    }

    /**
     * 校验一棵树是否是BST
     * 基本思想：
     * BST满足以下特性：
     * 对于任意一个节点，其左子树所有节点的值都比该节点的值小
     * 其右子树所有节点的值都大于该节点的值
     * 因此，进行中序遍历时，如果任意一个节点不满足上述特性
     * 则该树不是一颗BST
     *
     * @param root 树根
     * @return 是否为BST
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        /*
         * 采用基于栈的中序遍历
         * 每一个节点只需要和前一个节点的值进行对比
         * 若小于前一个节点的值则不满足BST特性
         */
        Deque<TreeNode> stack = new LinkedList<>();
        long preNodeVal = Long.MIN_VALUE;
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            if (currentNode.val <= preNodeVal) {
                return false;
            } else {
                preNodeVal = currentNode.val;
            }
            currentNode = currentNode.right;
        }
        return true;
    }
}
