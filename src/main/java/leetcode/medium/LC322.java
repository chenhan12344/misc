package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by 44399 on 2019/7/1
 *
 * @author 44399
 */
public class LC322 {

    public static void main(String[] args) {
        System.out.println(new LC322().coinChange(new int[]{5, 9}, 12));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        return helperDp(coins, amount);
    }

    /**
     * 利用动态规划自底向上
     *
     * @param coins
     * @param amount
     * @return
     */
    private int helperDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = coins[0] == 1 ? 1 : Integer.MAX_VALUE;
        for (int i = 2; i <= amount; i++) {
            for (int coin : coins) {
                int remaining = i - coin;
                if (remaining < 0) {
                    continue;
                }
                if (dp[remaining] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * 利用广度优先搜索
     *
     * @param coins
     * @param amount
     * @return
     */
    private int helperBFS(int[] coins, int amount) {
        boolean[] visited = new boolean[amount + 1];
        int depth = 1;
        /* 当前层剩余需要遍历的节点数量 */
        int count = 1;
        /* 下一层需要遍历的节点数量 */
        int nextCount = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        do {
            for (int i = coins.length - 1; i >= 0; i--) {
                if (amount < coins[i]) {
                    continue;
                }
                if (amount == coins[i]) {
                    return depth;
                }
                if (!visited[amount - coins[i]]) {
                    queue.addLast(amount - coins[i]);
                    nextCount++;
                    visited[amount - coins[i]] = true;
                }
            }
            if (--count == 0) {
                depth++;
                count = nextCount;
                nextCount = 0;
            }
            if (queue.isEmpty()) {
                return Integer.MAX_VALUE;
            }
            amount = queue.pollFirst();
        } while (true);
    }
}
