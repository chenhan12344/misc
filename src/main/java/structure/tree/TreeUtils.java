package structure.tree;

import java.util.*;

/**
 * Created by 44399 on 2019/2/13
 *
 * @author 44399
 */
public class TreeUtils {

    /**
     * 先序遍历（递归）
     */
    public static List<Integer> preorderTraversal(final TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<Integer> results = new LinkedList<>();
        results.add(root.val);
        results.addAll(preorderTraversal(root.left));
        results.addAll(preorderTraversal(root.right));
        return results;
    }

    /**
     * 先序遍历（循环）
     */
    public static List<Integer> preorderTraversalLoop(final TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        do {
            for (TreeNode cur = node; cur.left != null; cur = cur.left) {
                results.add(cur.val);
                stack.push(cur);
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
            }
        } while (!stack.isEmpty());
        return results;
    }

    /**
     * 中序遍历（递归）
     */
    public static List<Integer> inorderTraversal(final TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<Integer> results = new LinkedList<>(inorderTraversal(root.left));
        results.add(root.val);
        results.addAll(inorderTraversal(root.right));
        return results;
    }

    /**
     * 后续遍历（递归）
     */
    public static List<Integer> postorderTraversal(final TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<Integer> results = new LinkedList<>(preorderTraversal(root.right));
        results.addAll(postorderTraversal(root.right));
        results.add(root.val);
        return results;
    }

    /**
     * 建立完全二叉树
     * 具体思想是先用一个数组维护所有节点，然后依据完全二叉树的特性来建立父子节点的关系
     * 数组中第i个数的左孩子为第2*i个数，右孩子为2*i+1个数，据此建立第1层至第n-1层的所有父子关系
     *
     * @return 二叉树树根
     */
    public static TreeNode buildCompleteBinaryTree(final List<Integer> nums) {
        int len = nums.size();
        if (len == 0) {
            return null;
        }
        List<TreeNode> treeNodeList = new ArrayList<>(nums.size());
        for (Integer num : nums) {
            TreeNode treeNode;
            if (num != null) {
                treeNode = new TreeNode(num);
            } else {
                treeNode = null;
            }
            treeNodeList.add(treeNode);
        }
        int depth = new Double(Math.ceil(Math.log(len + 1) / Math.log(2))).intValue();
        for (int i = 0; i < Math.pow(2, depth - 1) - 1; i++) {
            if (treeNodeList.get(i) == null) {
                continue;
            }
            treeNodeList.get(i).left = 2 * i + 1 < len ? treeNodeList.get(2 * i + 1) : null;
            treeNodeList.get(i).right = 2 * i + 2 < len ? treeNodeList.get(2 * i + 2) : null;
        }
        return treeNodeList.get(0);
    }

    /**
     * 建立完全二叉树（重载）
     */
    public static TreeNode buildCompleteBinaryTree(final int[] nums) {
        List<Integer> numList = new ArrayList<>(nums.length);
        for (int num : nums) {
            numList.add(num);
        }
        return buildCompleteBinaryTree(numList);
    }

    /**
     * 建立完全二叉树（重载）
     */
    public static TreeNode buildCompleteBinaryTree(final Integer... integers) {
        List<Integer> numList = new ArrayList<>(integers.length);
        numList.addAll(Arrays.asList(integers));
        return buildCompleteBinaryTree(numList);
    }

    /**
     * 广度优先搜索
     */
    public static TreeNode breadthFirstSearch(final TreeNode root, final int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        List<TreeNode> childrenNodes = new ArrayList<>();
        childrenNodes.add(root.left);
        childrenNodes.add(root.right);
        for (TreeNode treeNode : childrenNodes) {
            if (treeNode != null && treeNode.val == target) {
                return treeNode;
            }
        }
        return null;
    }

    /**
     * 深度优先搜索
     */
    public static TreeNode depthFirthSearch(final TreeNode root, final int target) {
        return null;
    }
}
