import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/25
 *
 * @author 44399
 */
public class ByteDance2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, 1);
        dp[2] = 1;
        dp[4] = 2;
        helper(n, dp);
        System.out.println(dp[n] % 1000000007L);
    }

    private static long helper(int n, long[] dp) {
        if (n < 2) {
            return 1;
        }
        if (dp[n] != 1) {
            return dp[n];
        }
        int i = 1;
        long res = 0;
        for (int j = i + 1; j <= n; j += 2) {
            res += helper(j - i - 1, dp) * helper(n - j, dp);
        }
        dp[n] = res;
        return res;
    }
}
