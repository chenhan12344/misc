package leetcode.medium;

import structure.tree.TreeNode;

/**
 * Created by 44399 on 2019/2/23
 *
 * @author 44399
 */
public class LC105 {

    public static void main(String[] args) {
        TreeNode root = new LC105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println("ok");
    }

    /**
     * 先序遍历时，树根在前，因此数组首部一定是树根
     * 中序遍历时，树根将数组分为左右两个子树
     * 子树据此规则递归构建
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        if (len == 1) {
            return root;
        }

        int rootIndex = 0;
        while (inorder[rootIndex] != rootVal) {
            rootIndex++;
        }
        int leftNums = rootIndex, rightNums = len - rootIndex - 1;
        int[] leftPreorder = new int[leftNums],
                leftInorder = new int[leftNums];
        System.arraycopy(preorder, 1, leftPreorder, 0, leftNums);
        System.arraycopy(inorder, 0, leftInorder, 0, leftNums);
        int[] rightPreorder = new int[rightNums],
                rightInorder = new int[rightNums];
        System.arraycopy(preorder, leftNums + 1, rightPreorder, 0, rightNums);
        System.arraycopy(inorder, rootIndex + 1, rightInorder, 0, rightNums);
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }


}
