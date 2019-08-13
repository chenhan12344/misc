package offer;

import structure.tree.TreeNode;

/**
 * Created by Sky on 2019/6/26
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * @author Sky
 */
public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = new ReConstructBinaryTree().reConstructBinaryTree(pre, 0, in, 0, pre.length);
        System.out.println("done.");
    }

    /**
     * 先序遍历可以知道树根
     * 中序遍历可以知道左右子树
     * 根据上述规则可以重建二叉树
     *
     * @param pre 先序遍历序列
     * @param in  中序遍历序列
     * @return 重建好的二叉树树根
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int leftCount = 0, rightCount;
        for (int value : in) {
            if (value == pre[0]) {
                break;
            }
            leftCount++;
        }
        rightCount = in.length - 1 - leftCount;
        if (leftCount == 0) {
            root.left = null;
        } else {
            int[] leftPre = new int[leftCount], leftIn = new int[leftCount];
            System.arraycopy(pre, 1, leftPre, 0, leftCount);
            System.arraycopy(in, 0, leftIn, 0, leftCount);
            root.left = reConstructBinaryTree(leftPre, leftIn);
        }
        if (rightCount == 0) {
            root.right = null;
        } else {
            int[] rightPre = new int[rightCount], rightIn = new int[rightCount];
            System.arraycopy(pre, leftCount + 1, rightPre, 0, rightCount);
            System.arraycopy(in, leftCount + 1, rightIn, 0, rightCount);
            root.right = reConstructBinaryTree(rightPre, rightIn);
        }
        return root;
    }

    /**
     * 重建二叉树改良版，直接就地建树，避免内存占用
     *
     * @param pre      先序遍历序列
     * @param preStart 先序遍历序列开始索引
     * @param in       中序遍历序列
     * @param inStart  中序遍历序列开始索引
     * @param count    节点数
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int[] in, int inStart, int count) {
        if (count == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int leftCount = 0, rightCount;
        for (int i = 0; i < count; i++) {
            if (in[inStart + i] == pre[preStart]) {
                break;
            }
            leftCount++;
        }
        rightCount = count - 1 - leftCount;
        root.left = leftCount <= 0 ? null :
                reConstructBinaryTree(pre, preStart + 1, in, inStart, leftCount);
        root.right = rightCount <= 0 ? null :
                reConstructBinaryTree(pre, preStart + leftCount + 1, in, inStart + leftCount + 1, rightCount);
        return root;
    }
}
