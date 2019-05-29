package leetcode.medium;

/**
 * Created by 44399 on 2019/5/25
 *
 * @author 44399
 */
public class LC96 {

    public static void main(String[] args) {
        System.out.println(new LC96().numTrees(4));
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
