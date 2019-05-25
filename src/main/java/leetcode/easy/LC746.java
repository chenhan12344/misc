package leetcode.easy;

/**
 * Created by 44399 on 2019/2/27
 *
 * @author 44399
 */
public class LC746 {

    public static void main(String[] args) {
        System.out.println(new LC746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[cost.length];
        dp[len - 1] = cost[len - 1];
        dp[len - 2] = cost[len - 2];
        for (int i = len - 3; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }

}
