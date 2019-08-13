import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/4
 *
 * @author 44399
 */
public class Dajiang1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt(); //零食种类
            int t = scanner.nextInt(); //总零钱
            int[] price = new int[n], satisfaction = new int[n], count = new int[n];
            for (int i = 0; i < n; i++) {
                price[i] = scanner.nextInt();
                satisfaction[i] = scanner.nextInt();
                count[i] = scanner.nextInt();
            }
            System.out.println(maxSatisfaction(price, satisfaction, count, n, t));
        }
    }

    private static int maxSatisfaction(int[] price, int[] satisfaction, int[] count, int n, int t) {
        int[] dp = new int[t + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < count[i]; k++) {
                for (int j = t; j >= price[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - price[i]] + satisfaction[i]);
                }
            }
        }
        return dp[t - 1];
    }

}
