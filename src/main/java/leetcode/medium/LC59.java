package leetcode.medium;

/**
 * Created by 44399 on 2019/1/30
 *
 * @author 44399
 */
public class LC59 {

    public static void main(String[] args) {
        int[][] matrix = new LC59().generateMatrix(5);
        System.out.println(1);
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0,
                right = n - 1,
                up = 0,
                down = n - 1;
        int num = 1;
        while (num <= n * n) {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = num++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                matrix[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[down][i] = num++;
            }
            down--;
            for (int i = down; i >= up; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }
}
