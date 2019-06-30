package leetcode.medium;

/**
 * Created by Sky on 2019/6/17
 *
 * @author Sky
 */
public class LC416 {

    public static void main(String[] args) {
        System.out.println(new LC416().canPartition(
                new int[]{1, 2, 3, 4}
        ));
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        return canPartition(nums, 0, len - 1, new boolean[len][len]);
    }

    private static boolean canPartition(int[] nums, int start, int end, boolean[][] dp) {
        if (start >= end) {
            return false;
        }
        if (dp[start][end]) {
            return true;
        }
        if (end - start == 1) {
            return nums[start] == nums[end];
        }
        for (int i = start + 1; i < end; i++) {
            int left = sum(nums, start, i - 1), right = sum(nums, i + 1, end);
            if ((left + nums[i] == right)
                    || (left == right + nums[i])
                    || (left + right == nums[i])) {
                dp[start][end] = true;
                return true;
            }
        }
        return dp[start][end];
    }

    private static int sum(int[] nums, int begin, int end) {
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
