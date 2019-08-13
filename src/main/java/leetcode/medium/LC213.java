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

    /**
     * 解题思路：本题相比198只是多了一个环形条件，所以进行动态规划时需要特殊处理最后一间房子
     * 当dp到最后一间房子时，因为最后一间房子如果偷了就会影响前面的决策，因此最后一个房子做不偷的处理。
     * 这样处理的话，我们需分别计算从第0间开始和第1间开始偷的两种情况。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        System.out.println(getDp(nums, 0));
        System.out.println(getDp(nums, 1));
        return Math.max(getDp(nums, 0), getDp(nums, 1));
    }

    private static int getDp(int[] nums, int begin) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = get(nums, begin);
        if (len == 1) {
            return dp[0];
        }
        dp[1] = Math.max(get(nums, begin), get(nums, begin + 1));
        if (len == 2) {
            return dp[1];
        }
        for (int i = 2, index = 2 + begin; i < len; i++, index++) {
            if (i == len - 1) {
                // 如果是最后一间房子，那么就不偷了
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(get(nums, index) + dp[i - 2], dp[i - 1]);
            }
        }
        return dp[len - 1];
    }

    private static int get(int[] nums, int index) {
        return nums[index % nums.length];
    }
}
