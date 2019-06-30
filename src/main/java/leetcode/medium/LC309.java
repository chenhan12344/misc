package leetcode.medium;

/**
 * Created by Sky on 2019/6/21
 *
 * @author Sky
 */
public class LC309 {

//    [2,1,4,5,2,9,7]

    public static void main(String[] args) {
        System.out.println(new LC309().maxProfit(new int[]{
                1, 2, 3, 0, 2
        }));
    }

    /**
     * 二维DP问题，需要记录第i买入或者卖出状态的收益情况
     * buy[i] : 为第i天处于买入状态时能够获得的最大利润
     * sell[i] : 为第i天处于卖出状态时能够获得的最大利润
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] buyStatus = new int[len], sellStatus = new int[len];
        sellStatus[0] = 0;
        buyStatus[0] = -prices[1];
        sellStatus[1] = Math.max(0, prices[1] - prices[0]);
        buyStatus[1] = -Math.min(prices[0], prices[1]);
        for (int i = 2; i < len; i++) {
            buyStatus[i] = Math.max(sellStatus[i - 2] - prices[i], buyStatus[i - 1]);
            sellStatus[i] = Math.max(buyStatus[i - 1] + prices[i], sellStatus[i - 1]);
        }
        return sellStatus[len - 1];
    }
}
