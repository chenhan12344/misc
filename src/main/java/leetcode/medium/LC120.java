package leetcode.medium;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sky on 2019/5/21
 *
 * @author Sky
 */
public class LC120 {

    public static void main(String[] args) {
        System.out.println(new LC120().minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(1, 8),
                Arrays.asList(19, 19, 1),
                Arrays.asList(1, 1, 11, 3))));
    }

    /**
     * 解题思路：计算走到每个元素的最小代价
     * 走到最后一行时，遍历走到最后一行的每个元素的代价，求出其中最小的即为最小代价
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        // dp[i][j]表示走到（第i行，第j列）的元素所需要的最小代价
        int[][] dp = new int[height][height];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = triangle.get(i).get(j) +
                        (j == 0 ? dp[i - 1][0] :
                                j == i ? dp[i - 1][j - 1] :
                                        Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
            }
        }
        for (int i = 1; i < height; i++) {
            if (dp[height - 1][0] > dp[height - 1][i]) {
                dp[height - 1][0] = dp[height - 1][i];
            }
        }
        return dp[height - 1][0];
    }
}
