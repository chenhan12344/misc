package leetcode.medium;

/**
 * Created by Sky on 2019/6/3
 *
 * @author Sky
 */
public class LC375 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new LC375().getMoneyAmount(200));
        long end = System.currentTimeMillis();
        System.out.println("total time ms:" + (end - start));
    }

    private int dpMethod(int[][] dp, int start, int end) {
        if (end - start == 2) {
            return (start + end) / 2;
        }
        if (end - start == 1) {
            return start;
        }
        if (end <= start) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++) {
            res = Math.min(res, i + Math.max(dpMethod(dp, start, i - 1), dpMethod(dp, i + 1, end)));
        }
        dp[start][end] = res;
        return res;
    }


    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return dpMethod(dp, 1, n);
    }
}
