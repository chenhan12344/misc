package leetcode.hard;

/**
 * Created by Sky on 2019/6/25
 *
 * @author Sky
 */
public class LC188 {

    public static void main(String[] args) {
        System.out.println(new LC188().maxProfit(
                2, new int[]{
                        1, 2, 9, 1, 2, 9, 1, 2, 9
                }
        ));
    }

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] buyStatus = new int[3][2];
        int[][] sellStatus = new int[3][2];
        buyStatus[1][0] = -prices[0];
        buyStatus[2][0] = -prices[0];
        int day, prevDay, txn, prevTxn;
        for (int i = 1; i < len; i++) {
            day = i % 2;
            prevDay = (i - 1) % 2;
            for (int j = 1; j <= k; j++) {
                txn = 1 + j % 2;
                prevTxn = j == 1 ? 0 : 1 + (j - 1) % 2;
                buyStatus[txn][day] = Math.max(
                        sellStatus[prevTxn][prevDay] - prices[i],
                        buyStatus[txn][prevDay]
                );
                sellStatus[txn][day] = Math.max(
                        buyStatus[txn][prevDay] + prices[i],
                        sellStatus[txn][prevDay]
                );
            }
        }
        return sellStatus[1 + k % 2][(len - 1) % 2];
    }
}
