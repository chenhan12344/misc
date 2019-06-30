package leetcode.hard;

/**
 * Created by SmaxTransactionsy on 2019/6/21
 * 3
 * [2,6,8,7,8,7,9,4,1,2,4,5,8]
 *
 * @author SmaxTransactionsy
 */
public class LC123 {

    public static void main(String[] args) {
        int[] prices = new int[]{
                1, 2, 3, 4, 5
        };
        int txns = 2;
        LC123 solution = new LC123();
        System.out.println(txns + " -> " + solution.maxProfit(txns, prices));
        System.out.println(txns + " -> " + solution.maxProfitMemoryOptimized(txns, prices));

    }

    public int maxProfit(int[] prices) {
        return maxProfit(2, prices);

    }

    /**
     * 本问题属于二维DP问题，需要记录第maxTransactions次交易在第i天维持买入或卖出状态时获得利润
     * buyStatus[maxTransactions][i] : 表示第maxTransactions次交易在第i天维持买入状态时，能够获得的最大利润
     * sellStatus[maxTransactions][i] : 表示第maxTransactions次交易在第i天维持卖出状态时，能够获得的最大利润
     * 状态迁移过程如下：
     * 第maxTransactions次交易，在第i天，若维持买入状态时，能够获得的最大利润为：
     * Max( 买入 -> 上一次交易在前一天维持卖出状态获得的利润 - 当前股票价格 , 不买入 -> 本次交易在前一天维持买入状态获得的利润 )
     * 即：buyStatus[maxTransactions][i] = Math.max(sellStatus[maxTransactions-1][i-1] - prices[i], buyStatus[maxTransactions][i-1])
     * 第maxTransactions次交易　在第i天，若维持卖出状态时，能够获得的最大利润为：
     * Max( 卖出 -> 本次交易在前一天维持买入状态获得的利润 + 当前股票价格 , 不卖出 -> 本交易在前一天维持卖出状态获得的利润 )
     * 即：sellStatus[maxTransactions][i] = Math.max(buyStatus[maxTransactions][i-1] + prices[i], sellStatus[maxTransactions][i-1])
     *
     * @param prices          股票价格
     * @param maxTransactions 最大交易次数
     * @return 最大利润
     */
    private int maxProfit(int maxTransactions, int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] buyStatus = new int[maxTransactions + 1][len];
        int[][] sellStatus = new int[maxTransactions + 1][len];
        for (int i = 1; i <= maxTransactions; i++) {
            buyStatus[i][0] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= maxTransactions; j++) {
                buyStatus[j][i] = Math.max(
                        sellStatus[j - 1][i - 1] - prices[i],
                        buyStatus[j][i - 1]
                );
                sellStatus[j][i] = Math.max(
                        buyStatus[j][i - 1] + prices[i],
                        sellStatus[j][i - 1]
                );
            }
        }
        return sellStatus[maxTransactions][len - 1];
    }

    /**
     * maxProfit的内存优化版
     * 可以观察到的是，第i天的决策仅仅取决于前一天的状态，而与之前的状态无关
     * 因此可以只用一个长度为2的数组来记录当天或者前一天的状态，并交替使用
     *
     * @param prices
     * @param maxTransactions
     * @return
     */
    private int maxProfitMemoryOptimized(int maxTransactions, int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] buyStatus = new int[maxTransactions + 1][2];
        int[][] sellStatus = new int[maxTransactions + 1][2];
        for (int i = 1; i <= maxTransactions; i++) {
            buyStatus[i][0] = -prices[0];
        }
        int today, yesterday;
        for (int i = 1; i < len; i++) {
            today = i % 2;
            yesterday = (i - 1) % 2;
            for (int j = 1; j <= len / 2; j++) {
                buyStatus[j][today] = Math.max(
                        sellStatus[j - 1][yesterday] - prices[i],
                        buyStatus[j][yesterday]
                );
                sellStatus[j][today] = Math.max(
                        buyStatus[j][yesterday] + prices[i],
                        sellStatus[j][yesterday]
                );
            }
        }
        return sellStatus[maxTransactions][(len - 1) % 2];
    }

}
