package offer;

import structure.tree.TreeNode;

import java.util.ArrayList;

/**
 * Created by Sky on 2019/8/26
 *
 * @author Sky
 */
public class TreePathSum {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null||root.val > target) {
            return new ArrayList<>(0);
        }
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        if (root.val == target && root.left == null && root.right == null) {
            ArrayList<Integer> path = new ArrayList<>(10);
            path.add(target);
            pathList.add(path);
            return pathList;
        }
        if (root.left != null) {
            for (ArrayList<Integer> path : FindPath(root.left, target - root.val)) {
                ArrayList<Integer> newPath = new ArrayList<>(path.size()+1);
                newPath.add(root.val);
                newPath.addAll(path);
                pathList.add(newPath);
            }
        }

        if (root.right != null) {
            for (ArrayList<Integer> path : FindPath(root.right, target - root.val)) {
                ArrayList<Integer> newPath = new ArrayList<>(path.size()+1);
                newPath.add(root.val);
                newPath.addAll(path);
                pathList.add(newPath);
            }
        }
        return pathList;
    }
}
