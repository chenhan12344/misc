package leetcode.medium;

import structure.tree.TreeNode;

/**
 * Created by 44399 on 2019/2/23
 *
 * @author 44399
 */
public class LC106 {

    public static void main(String[] args) {
        TreeNode root = new LC106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println("ok");
    }

    /**
     * 中序遍历中，树根将数组分为左右两个子树
     * 后序遍历中，树根都在末尾，左右子树都在前
     * 依据此递归进行建树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) {
            return null;
        }
        int rootVal = postorder[len - 1];
        TreeNode root = new TreeNode(rootVal);
        if (len == 1) {
            return root;
        }
        //
        int rootIndex = 0;
        while (inorder[rootIndex] != rootVal) {
            rootIndex++;
        }
        int leftNums = rootIndex, rightNums = len - rootIndex - 1;
        int[] leftInorder = new int[leftNums],
                leftPostorder = new int[leftNums];
        System.arraycopy(inorder, 0, leftInorder, 0, leftNums);
        System.arraycopy(postorder, 0, leftPostorder, 0, leftNums);
        int[] rightInoder = new int[rightNums],
                rightPostorder = new int[rightNums];
        System.arraycopy(inorder, rootIndex + 1, rightInoder, 0, rightNums);
        System.arraycopy(postorder, leftNums, rightPostorder, 0, rightNums);
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInoder, rightPostorder);
        return root;
    }
}
