package leetcode.medium;

/**
 * Created by Sky on 2019/5/20
 *
 * @author Sky
 */
public class LC62 {

    public static void main(String[] args) {
        System.out.println(new LC62().uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        if (m < 2 || n < 2) {
            return 1;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = get(dp, i - 1, j) + get(dp, i, j - 1);
            }
        }
        return dp[m - 1][n - 1];
    }

    private int get(int[][] dp, int i, int j) {
        if (i < 0) {
            return 0;
        }
        if (j < 0) {
            return 0;
        }
        return dp[i][j];
    }
}
