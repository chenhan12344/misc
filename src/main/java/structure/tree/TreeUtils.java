package structure.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 44399 on 2019/2/13
 *
 * @author 44399
 */
public class TreeUtils {

    private static final List<Integer> EMPTY_LIST = new ArrayList<>(0);

    /**
     * 先序遍历（递归）
     */
    public static List<Integer> preorderTraversalRecursive(final TreeNode root) {
        if (root == null) {
            return EMPTY_LIST;
        }
        List<Integer> results = new LinkedList<>();
        results.add(root.val);
        results.addAll(preorderTraversalRecursive(root.left));
        results.addAll(preorderTraversalRecursive(root.right));
        return results;
    }

    /**
     * 先序遍历（迭代）
     */
    public static List<Integer> preorderTraversalIterative(final TreeNode root) {
        if (root == null) {
            return EMPTY_LIST;
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

    /**
     * 中序遍历（递归）
     */
    public static List<Integer> inorderTraversalRecursive(final TreeNode root) {
        if (root == null) {
            return EMPTY_LIST;
        }
        List<Integer> results = new LinkedList<>(inorderTraversalRecursive(root.left));
        results.add(root.val);
        results.addAll(inorderTraversalRecursive(root.right));
        return results;
    }

    /**
     * 中序遍历（迭代）
     */
    public static List<Integer> inorderTraversalIterative(final TreeNode root) {
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


    /**
     * 后续遍历（递归）
     */
    public static List<Integer> postorderTraversalRecursive(final TreeNode root) {
        if (root == null) {
            return EMPTY_LIST;
        }
        List<Integer> results = new LinkedList<>(preorderTraversalRecursive(root.right));
        results.addAll(postorderTraversalRecursive(root.right));
        results.add(root.val);
        return results;
    }

    /**
     * 后续遍历（迭代）
     */
    public static List<Integer> postorderTraversalIterative(final TreeNode root) {
        if (root == null) {
            return EMPTY_LIST;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        stack.push(root);
        TreeNode p = root.left, q = null;
        while (!stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (p.right == null || (p.right == q)) {
                q = p;
                result.add(p.val);
                p = null;
            } else {
                stack.push(p);
                p = p.right;
            }
        }
        return result;
    }

    /**
     * 建立完全二叉树
     * 具体思想是先用一个数组维护所有节点，然后依据完全二叉树的特性来建立父子节点的关系
     * 数组中第i个数的左孩子为第2*i个数，右孩子为2*i+1个数，据此建立第1层至第n-1层的所有父子关系
     *
     * @return 二叉树树根
     */
    public static TreeNode buildBinaryTree(final Integer... integers) {
        int len = integers.length;
        if (len == 0) {
            return null;
        }
        List<TreeNode> treeNodeList = new ArrayList<>(len);
        for (Integer i : integers) {
            TreeNode treeNode;
            if (i != null) {
                treeNode = new TreeNode(i);
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
     * 构建二叉排序树
     * 由于二叉排序树属于AVL树，所以将数组中的值作为根节点
     * 然后剩余两侧的子区间分别递归构建子树作为左右子树
     *
     * @return 树根
     */
    public static TreeNode buildBinarySearchTree(final int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return buildBinarySearchTree(nums, 0, nums.length - 1);
    }

    /**
     * 构建二叉排序树辅助函数
     *
     * @return 树根
     */
    private static TreeNode buildBinarySearchTree(final int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBinarySearchTree(nums, start, mid - 1);
        root.right = buildBinarySearchTree(nums, mid + 1, end);
        return root;
    }

    /**
     * 向二叉排序树中插入值
     *
     * @param root  树根
     * @param value 需要插入的值
     * @return 插入后的树根
     */
    public static TreeNode insertIntoBinarySearchTree(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(value);
            } else {
                insertIntoBinarySearchTree(root.left, value);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(value);
            } else {
                insertIntoBinarySearchTree(root.right, value);
            }
        }
        return root;
    }

    /**
     * 检查二叉树的平衡，如果不满足AVL树的特性
     * 则自动进行调整，并返回调整后的新树根
     *
     * @param root 需要检查的树的树根
     * @return 检查完后的树根
     */
    private static TreeNode checkSelfBalancing(TreeNode root) {
        if (root == null) {
            return root;
        }
        int depthDiff = getTreeDepth(root.left) - getTreeDepth(root.right);

        if (depthDiff > 1) {
            /*
             * 左子树深度过大，对树进行右旋操作
             * 右旋过程：
             *        5
             *       / \
             *      3   6
             *     / \
             *    2   4
             *   /
             *  1
             *
             *      3
             *     /|\
             *    2 4 5
             *   /     \
             *  1       6
             *
             *      3
             *     / \
             *    2   5
             *   /   / \
             *  1   4   6
             *
             */
            TreeNode newRoot = root.left;
            TreeNode tmp = newRoot.right;
            newRoot.right = root;
            root.left = tmp;
            root = newRoot;
        } else if (depthDiff < -1) {
            /*
             * 右子树深度过大，对树进行左旋操作
             * 左旋过程：
             *    2
             *   / \
             *  1   4
             *     / \
             *    3   5
             *         \
             *          6
             *
             *      4
             *     /|\
             *    2 3 5
             *   /     \
             *  1       6
             *
             *      4
             *     / \
             *    2   5
             *   / \   \
             *  1   3   6
             *
             */
            TreeNode newRoot = root.right;
            TreeNode tmp = newRoot.left;
            newRoot.left = root;
            root.right = tmp;
            root = newRoot;
        }
        /* 调整完后依次对各孩子节点进行检查 */
        if (root.left != null) {
            root.left = checkSelfBalancing(root.left);
        }
        if (root.right != null) {
            root.right = checkSelfBalancing(root.right);
        }
        return root;
    }

    /**
     * 获取二叉树的深度
     *
     * @param root 树根
     * @return 树的深度
     */
    public static int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
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
