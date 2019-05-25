package leetcode.medium;

import java.util.Arrays;

/**
 * Created by Sky on 2019/1/7
 *
 * @author Sky
 */
public class LC807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int rows = grid[0].length,
                cols = grid.length;


        //view from bottom
        int[] bottom = new int[cols];
        for (int i = 0; i < cols; i++) {
            int max = 0;
            for (int j = 0; j < rows; j++) {
                if (grid[j][i] > max) {
                    max = grid[j][i];
                }
            }
            bottom[i] = max;
        }
        System.out.println(Arrays.toString(bottom));

        //view from right
        int[] right = new int[rows];
        for (int i = 0; i < rows; i++) {
            int max = 0;
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            right[i] = max;
        }
        System.out.println(Arrays.toString(right));

        int result = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                result += bottom[col] < right[row] ? bottom[col] - grid[row][col] : right[row] - grid[row][col];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new LC807().maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
    }

}
