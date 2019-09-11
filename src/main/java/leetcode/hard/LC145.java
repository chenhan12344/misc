package leetcode.hard;

import structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sky on 2019/8/26
 *
 * @author Sky
 */
public class LC145 {

    public static void main(String[] args) {
        System.out.println(new LC145().postorderTraversal(
                new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)))
        ));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
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


}
