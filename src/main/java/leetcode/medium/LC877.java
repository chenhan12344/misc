package leetcode.medium;

/**
 * Created by Sky on 2019/6/18
 *
 * @author Sky
 */
public class LC877 {

    public static void main(String[] args) {
        System.out.println(new LC877().stoneGame(new int[]{

        }));
    }

    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        if (len == 0) {
            return false;
        }
        if (len < 3) {
            return true;
        }
        int[][] dp = new int[len][len];
        return stoneGame(piles, 0, len - 1, dp);
    }

    private boolean stoneGame(int[] piles, int start, int end, int[][] dp) {
        if (dp[start][end] != 0) {
            return dp[start][end] > sum(piles, start, end) / 2;
        }
        if (start == end) {
            dp[start][end] = piles[start];
            return true;
        }
        if (end - start == 1) {
            dp[start][end] = Math.max(piles[start], piles[end]);
            return true;
        }
        dp[start][end] = Math.max(
                piles[start] + sum(piles, start + 1, end) - dp[start + 1][end],
                piles[end] + sum(piles, start, end - 1) - dp[start][end - 1]
        );
        return dp[start][end] > sum(piles, start, end) / 2;
    }

    private static int sum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
