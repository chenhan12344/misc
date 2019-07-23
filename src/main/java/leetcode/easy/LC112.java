package leetcode.easy;

import structure.tree.TreeNode;
import structure.tree.TreeUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 44399 on 2019/7/4
 *
 * @author 44399
 */
public class LC112 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildCompleteBinaryTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5);
        List<String> result = new LC112().hasPathSum(root, 22);
        System.out.println(String.join("->", result));
    }

    public List<String> hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<String> result = new LinkedList<>();
        if (sum == root.val) {
            result.add(String.valueOf(root.val));
            return result;
        }
        int nextSum = sum - root.val;
        List<String> nextResult;
        if (!(nextResult = hasPathSum(root.left, nextSum)).isEmpty()) {
            result.addFirst(String.valueOf(root.val));
            result.addAll(nextResult);
            return result;
        }
        if (!(nextResult = hasPathSum(root.right, nextSum)).isEmpty()) {
            result.addFirst(String.valueOf(root.val));
            result.addAll(nextResult);
            return result;
        }
        return result;
    }
}
