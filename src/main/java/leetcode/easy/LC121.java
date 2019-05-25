package leetcode.easy;

/**
 * Created by 44399 on 2019/2/26
 *
 * @author 44399
 */
public class LC121 {

    public static void main(String[] args) {
        System.out.println(new LC121().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int len = prices.length, max = 0;
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                dp[i] = dp[i - 1] + diff;
            } else {
                dp[i] = Math.max(0, dp[i - 1] + diff);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
