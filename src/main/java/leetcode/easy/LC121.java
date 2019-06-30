package leetcode.easy;

/**
 * Created by 44399 on 2019/2/26
 *
 * @author 44399
 */
public class LC121 {

    public static void main(String[] args) {
        System.out.println(new LC121().maxProfit(new int[]{
                7, 6, 4, 3, 1
        }));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int minPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < len; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
