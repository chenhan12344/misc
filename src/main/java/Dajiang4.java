import java.util.Scanner;

/**
 * Created by Sky on 2019/8/6
 *
 * @author Sky
 */
public class Dajiang4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = scanner.nextInt();
        for (int i = 0; i < caseNumber; i++) {
            //游戏总数
            int games = scanner.nextInt();
            //可以进行游戏的时间
            int totalTime = scanner.nextInt();
            //成就点数
            int[] points = new int[games];
            //需要消耗的时间
            int[] time = new int[games];
            for (int j = 0; j < games; j++) {
                points[j] = scanner.nextInt();
                time[j] = scanner.nextInt();
            }
            System.out.println(maxAchievement(games, totalTime, points, time));
        }
    }

    private static int maxAchievement(int n, int timeLimit, int[] achievements, int[] time) {
        int[][] dp = new int[n][timeLimit + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= timeLimit; j++) {
                if (time[i] > j) {
                    dp[i][j] = get(dp, i - 1, j);
                } else {
                    dp[i][j] = Math.max(
                            get(dp, i - 1, j - time[i]) + achievements[i],
                            get(dp, i - 1, j));
                }
            }
        }
        return dp[n - 1][timeLimit];
    }

    private static int get(int[][] dp, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        } else {
            return dp[i][j];
        }
    }
}
