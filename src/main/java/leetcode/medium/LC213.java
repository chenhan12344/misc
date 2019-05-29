package leetcode.medium;

/**
 * Created by 44399 on 2019/5/25
 *
 * @author 44399
 */

public class LC213 {

    public static void main(String[] args) {
        System.out.println(new LC213().rob(new int[]{
                1, 2, 1, 1
        }));
    }

    public int rob(int[] nums) {
        switch (nums.length) {
            case 0: {
                return 0;
            }
            case 1: {
                return nums[0];
            }
            case 2: {
                return Math.max(nums[0], nums[1]);
            }
            default: {
                int len = nums.length;
                int[] dp = new int[len];
                dp[0] = nums[0];
                dp[1] = Math.max(nums[0], nums[1]);
                for (int i = 2; i < len - 1; i++) {
                    dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
                }
                dp[len - 1] = dp[1] == nums[1] ? Math.max(nums[len - 1] + dp[len - 3], dp[len - 2])
                        : Math.max(nums[len - 1] + dp[len - 3] - nums[0], dp[len - 2]);
                return dp[len - 1];
            }
        }
    }
}
