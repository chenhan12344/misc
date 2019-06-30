package leetcode.medium;

/**
 * Created by Sky on 2019/6/17
 *
 * @author Sky
 */
public class LC322 {


    public static void main(String[] args) {
        System.out.println("total coins: " + new LC322().coinChange(
                new int[]{186, 419, 83, 408}, 6249
        ));
    }

    public int coinChange(int[] coins, int amount) {
//        if (amount < 1) {
//            return 0;
//        }
//        return coinChange(coins, amount, new int[amount]);
        int[] cache = new int[amount + 1];
        coinChangeDFS(coins, amount, cache);
        return cache[amount];
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    private static int coinChangeDFS(int[] coins, int amount, int[] cache) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (cache[amount] > 0) {
            return cache[amount];
        }
        for (int coin : coins) {
            int nextCoins = coinChangeDFS(coins, amount - coin, cache);
            if (nextCoins >= 0 && cache[amount] >= 0) {
                cache[amount] = Math.min(1 + nextCoins, cache[amount]);
            }

        }
        return cache[amount];
//        for (int i = coins.length - 1; i >= 0; i--) {
//            int nextCoins = coinChangeDFS(coins, amount - coins[i], cache);
//            if (nextCoins >= 0) {
//                cache[amount] = Math.min(1 + nextCoins, cache[amount]);
////                return cache[amount];
//            }
//        }
//        if (cache[amount] >= 0) {
//            return cache[amount];
//        }
//        return -1;
    }

}
