package leetcode.medium;

/**
 * Created by Sky on 2019/5/21
 *
 * @author Sky
 */
public class LC152 {

    public static void main(String[] args) {
        System.out.println(new LC152().maxProduct(new int[]{1, 1, 1}));
    }

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        return 0;

    }

}
