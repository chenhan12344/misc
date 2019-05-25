package leetcode.medium;

/**
 * Created by Sky on 2019/5/20
 *
 * @author Sky
 */
public class LC63 {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0, 1}};
        System.out.println(new LC63().uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,
                n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 :
                        get(dp, i - 1, j, obstacleGrid) + get(dp, i, j - 1, obstacleGrid);
            }
        }
        return dp[m - 1][n - 1];
    }

    private static int get(int[][] dp, int i, int j, int[][] obstacleGrid) {
        if (obstacleGrid[i][j] == 1) {
            return 0;
        } else {
            return dp[i][j];
        }
    }
}
