package leetcode.medium;

/**
 * Created by Sky on 2019/8/6
 * --------------------------------------------------
 * 74. Search a 2D Matrix
 * --------------------------------------------------
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * --------------------------------------------------
 * Example:
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC74 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1}};
        System.out.println(new LC74().searchMatrix(matrix, 2));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rightBound = matrix[0].length - 1, upBound = 0;
        while (matrix[0][rightBound] > target) {
            rightBound--;
            if (rightBound < 0) {
                return false;
            }
        }
        while (matrix[upBound][rightBound] < target) {
            upBound++;
            if (upBound == matrix.length) {
                return false;
            }
        }
        for (int i = upBound; i < matrix.length; i++) {
            for (int j = 0; j <= rightBound; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
