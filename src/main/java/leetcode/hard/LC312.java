package leetcode.hard;

/**
 * Created by Sky on 2019/4/12
 * ---------------------------------------------------------------------------------
 * Given n balloons, indexed from 0 to n-1.
 * Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons.
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i.
 * After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * ---------------------------------------------------------------------------------
 * Example:
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * ---------------------------------------------------------------------------------
 *
 * @author Sky
 */
public class LC312 {

    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return maxCoins(nums, 0, nums.length - 1, dp);
    }

    /**
     * 核心思想：自底向上的分治
     * 首先考虑扎爆[start, end]区间的解法
     * 假设第i个气球是最后被扎爆的，那么此时区间[start, i-1]和[i+1, end]区间
     * 都已经被扎爆了，所以此时扎i能够获得的分数为[start - 1] * [i] * [end + 1]
     * 因此在[start, end]区间最后扎爆气球i能够得到的分数为：
     * maxCoins([start][i - 1]) + [start - 1] * [i] * maxCoins([end + 1] + dp[i + 1][end])
     * 那么只需要在[start, end]内遍历i，就能够知道这个区间所能得到的最大分数
     * 然后将最大得分记录到备忘录dp[start][end]，这样以后计算任意区间dp[i][j]可以先检查备忘录
     * 中是否已经有结果
     */
    private int maxCoins(int[] nums, int start, int end, int[][] dp) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int max = nums[start];
        for (int i = start; i <= end; i++) {
            max = Math.max(max,
                    maxCoins(nums, start, i - 1, dp)
                            + get(nums, start - 1) * nums[i] * get(nums, end + 1)
                            + maxCoins(nums, i + 1, end, dp)
            );
        }
        dp[start][end] = max;
        return max;
    }

    private static int get(int[] nums, int index) {
        return (index < 0 || index >= nums.length) ? 1 : nums[index];
    }

}