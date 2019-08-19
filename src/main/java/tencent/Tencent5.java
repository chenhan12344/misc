package tencent;

import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/17
 *
 * @author 44399
 */
public class Tencent5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int works[] = new int[n];
        int gyms[] = new int[n];
        for (int i = 0; i < n; i++) {
            works[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            gyms[i] = scanner.nextInt();
        }

        int[][] dp = new int[n][3];
        if (works[n - 1] == 0) {
            dp[n - 1][0] = Integer.MAX_VALUE;

        }
        if (gyms[n - 1] == 0) {
            dp[n - 1][1] = Integer.MAX_VALUE;
        }
        dp[n - 1][2] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (works[i] == 0) {
                dp[i][0] = Integer.MAX_VALUE;
            } else {
                dp[i][0] = Math.min(dp[i + 1][1], dp[i + 1][2]);
            }
            if (gyms[i] == 0) {
                dp[i][1] = Integer.MAX_VALUE;
            } else {
                dp[i][1] = Math.min(dp[i + 1][0], dp[i + 1][2]);
            }
            dp[i][2] = Math.min(dp[i + 1][0], Math.min(dp[i + 1][1], dp[i + 1][2])) + 1;
        }
        System.out.println(Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2])));
    }
}
