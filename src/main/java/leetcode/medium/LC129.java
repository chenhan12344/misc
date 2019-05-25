package leetcode.medium;

import structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 44399 on 2019/3/5
 *
 * @author 44399
 */
public class LC129 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ((List) list).add("123");
        System.out.println(list.get(1));
        for (Object obj : list) {
            System.out.println(obj.getClass());
        }
    }

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode treeNode, int sum) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return sum * 10 + treeNode.val;
        }
        return sum(treeNode.left, sum * 10 + treeNode.val) +
                sum(treeNode.right, sum * 10 + treeNode.val);
    }
}
