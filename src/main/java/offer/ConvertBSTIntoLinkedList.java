package offer;

import structure.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sky on 2019/8/26
 *
 * @author Sky
 */
public class ConvertBSTIntoLinkedList {

    public TreeNode Convert(TreeNode root) {
        return null;
    }

    public Queue<TreeNode> postorderTraverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root, q;
        do {
            while (p.left != null) {
                stack.push(p);
                p = p.left;
            }
            if (p.right != null) {
                stack.push(p);
                p = p.right;
                continue;
            }
            queue.add(p);

        } while (!stack.isEmpty());
        return null;
    }
}
