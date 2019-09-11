import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/30
 *
 * @author 44399
 */
public class Alibaba1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n, area);
        System.out.println(minimumTimeCost);
    }

    private static int getMinimumTimeCost(int n, int[][] area) {
        if (n < 2) {
            return 0;
        }
        // dp[i][j]表示从area[i][j]到下边的时间
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        if (n % 2 == 0) {
            // 偶数行则只需要跳到倒数第二行
            // 初始化倒数第二行
            for (int col = n - 1; col >= 0; col--) {
                if (col <= n - 3) {
                    // 如果可以向下或者向右跳，那么选一条最短的路
                    dp[n - 2][col] = Math.min(area[n - 1][col], area[n - 2][col + 1] + dp[n - 2][col + 2]);
                } else {
                    // 否则只能向下跳
                    dp[n - 2][col] = area[n - 1][col];
                }
            }
            for (int row = n - 4; row >= 0; row -= 2) {
                for (int col = n - 1; col >= 0; col--) {
                    if (col <= n - 3) {
                        // 如果可以向下或者向右跳，那么选一条最短的路
                        dp[row][col] = Math.min(area[row + 1][col] + dp[row + 2][col],
                                area[row][col + 1] + dp[row][col + 2]);
                    } else {
                        // 否则只能向下跳
                        dp[row][col] = area[row + 1][col] + dp[row + 2][col];
                    }
                }
            }
        } else {
            // 奇数行则只需要跳到倒数第三行
            // 初始化倒数第三行
            for (int col = n - 1; col >= 0; col--) {
                if (col <= n - 3) {
                    // 如果可以向下或者向右跳，那么选一条最短的路
                    dp[n - 3][col] = Math.min(area[n - 2][col], area[n - 3][col + 1] + dp[n - 3][col + 2]);
                } else {
                    // 否则只能向下跳
                    dp[n - 3][col] = area[n - 2][col];
                }
            }

            for (int row = n - 5; row >= 0; row -= 2) {
                for (int col = n - 1; col >= 0; col--) {
                    if (col <= n - 2) {
                        // 如果可以向下或者向右跳，那么选一条最短的路
                        dp[row][col] = Math.min(area[row + 1][col] + dp[row + 2][col],
                                area[row][col + 1] + dp[row][col + 2]);
                    } else {
                        // 否则只能向下跳
                        dp[row][col] = area[row + 1][col] + dp[row + 2][col];
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int num : dp[0]) {
            res = Math.min(res, num);
        }
        return res;
    }
}
