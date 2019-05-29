package leetcode.medium;

import structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 44399 on 2019/5/25
 *
 * @author 44399
 */
public class LC95 {

    public static void main(String[] args) {
        List<TreeNode> results = new LC95().generateTrees(3);
        System.out.println(1);
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> results = new ArrayList<>();
        if (start > end) {
            return results;
        }
        if (start == end) {
            TreeNode root = new TreeNode(start);
            results.add(root);
            return results;
        }
        if (end - start == 1) {
            TreeNode root1 = new TreeNode(start);
            root1.right = new TreeNode(end);
            results.add(root1);
            TreeNode root2 = new TreeNode(end);
            root2.left = new TreeNode(start);
            results.add(root2);
            return results;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            if (leftTrees.isEmpty()) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.right = right;
                    results.add(root);
                }
                continue;
            }
            if (rightTrees.isEmpty()) {
                for (TreeNode left : leftTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    results.add(root);
                }
                continue;
            }
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    results.add(root);
                }
            }

        }
        return results;
    }
}
