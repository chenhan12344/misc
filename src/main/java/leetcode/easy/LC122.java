package leetcode.easy;

/**
 * Created by Sky on 2019/6/20
 *
 * @author Sky
 */
public class LC122 {

    public static void main(String[] args) {
        System.out.println(new LC122().maxProfit(new int[]{
                7, 1, 5, 3, 6, 4
        }));
    }

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0, len = prices.length; i < len - 1; i++) {
            sum += Math.max(0, prices[i + 1] - prices[i]);
        }
        return sum;
    }
}
