package leetcode.easy;

/**
 * Created by 44399 on 2019/2/26
 *
 * @author 44399
 */
public class LC53 {

    public static void main(String[] args) {
        System.out.println(new LC53().maxSubArray(new int[]{6, -5, 10}));
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i - 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
