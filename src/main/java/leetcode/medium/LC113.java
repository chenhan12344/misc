package leetcode.medium;

import structure.tree.TreeNode;
import structure.tree.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sky on 2019/1/25
 *
 * @author Sky
 */
public class LC113 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinaryTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1);
        System.out.println(new LC113().pathSum(root, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> results = new ArrayList<>();
        if (root.left != null) {
            results.addAll(pathSum(root.left, sum - root.val));
        }
        if (root.right != null) {
            results.addAll(pathSum(root.right, sum - root.val));
        }
        if (root.val == sum && root.left == null && root.right == null) {
            List<List<Integer>> result = new LinkedList<>();
            List<Integer> singletonList = new LinkedList<>();
            singletonList.add(root.val);
            result.add(singletonList);
            return result;
        } else {
            for (List<Integer> list : results) {
                list.add(0, root.val);
            }
            return results;
        }
    }
}
