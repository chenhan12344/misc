package leetcode.medium;

import structure.tree.TreeNode;

/**
 * Created by Sky on 2019/1/6
 *
 * @author Sky
 */
public class LC493 {

    public static void main(String[] args) {
//        System.out.println(Long.MIN_VALUE);
        System.out.println(new LC493().reversePairs(new int[]{2147483647, 2147483647, -2147483647, -2147483647, -2147483647, 2147483647}));
    }

    public int reversePairs(int[] nums) {
        int len = nums.length;
        int min = 0;

        RichTreeNode root = null;
        for (int i = len - 1; i >= 0; i--) {
            if (root == null) {
                root = new RichTreeNode(nums[i]);
            } else {
                insert(root, nums[i]);
            }
        }
        return traverse(root);

    }

    class RichTreeNode extends TreeNode {

        RichTreeNode(long value) {
            this.value = value;
        }

        RichTreeNode left;
        RichTreeNode right;
        long value;
        int count = 1;
        int biggerCont = 0;
    }

    private void insert(RichTreeNode root, long value) {
        if (value > 2 * root.value) {
            root.biggerCont += root.count;
        }
        if (value == root.value) {
            root.count++;
        }
        if (value <= root.value) {
            if (root.left == null) {
                root.left = new RichTreeNode(value);
            } else {
                insert(root.left, value);
            }
        }
        if (value > root.value) {
            if (root.right == null) {
                root.right = new RichTreeNode(value);
            } else {
                insert(root.right, value);
            }
        }

    }

    private int traverse(RichTreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = root.biggerCont;
        count += traverse(root.left);
        count += traverse(root.right);
        return count;
    }
}
