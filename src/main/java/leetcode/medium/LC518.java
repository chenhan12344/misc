package leetcode.medium;

import java.util.LinkedList;

/**
 * Created by 44399 on 2019/7/1
 * ------------------------------------------------------------------------------------
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 * ------------------------------------------------------------------------------------
 * Example:
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * @author 44399
 */
public class LC518 {

    public static void main(String[] args) {
        System.out.println(new LC518().change(10, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        return helperBFS(coins, amount);
    }

    private int helperBFS(int[] coins, Integer amount) {
        boolean[] visited = new boolean[amount + 1];
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        do {
            for (int i = coins.length - 1; i >= 0; i--) {
                if (amount == 0) {

                }
                if (amount < coins[i]) {
                    continue;
                }
                if (!visited[amount - coins[i]]) {
                    queue.addLast(amount - coins[i]);
                    visited[amount - coins[i]] = true;
                }
            }
            amount = queue.pollFirst();
        } while (amount != null);
        return count;
    }
}
