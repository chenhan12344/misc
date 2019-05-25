package leetcode.medium;

/**
 * Created by 44399 on 2019/2/1
 *
 * @author 44399
 */
public class LC73 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new LC73().setZeroes(matrix);
        System.out.println(1);
    }

    /**
     * O(mn) space complexity
     */
    public void setZeroes1(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroCols = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }
        for (int i = 0; i < zeroRows.length; i++) {
            if (zeroRows[i]) {
                for (int j = 0; j < zeroCols.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < zeroCols.length; i++) {
            if (zeroCols[i]) {
                for (int j = 0; j < zeroRows.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int rows = matrix.length,
                cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
