package leetcode.medium;

/**
 * Created by Sky on 2019/5/20
 *
 * @author Sky
 */
public class LC64 {

    public static void main(String[] args) {
        System.out.println(new LC64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length,
                n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 & j == 0) {
                    dp[i][j] = grid[0][0];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(get(dp, i - 1, j), get(dp, i, j - 1));
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int get(int[][] dp, int i, int j) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        } else {
            return dp[i][j];
        }
    }

}
