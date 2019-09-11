import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 44399 on 2019/9/1
 *
 * @author 44399
 */
public class Tencent4 {

    private static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            scores[i] = scanner.nextInt();
        }
        int[][] min = new int[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
            min[i][i] = sum[i][i] = scores[i];
        }
        for (int i = 1; i <= n; i++) {
            helper(scores, 1, i, min, sum);
        }
        System.out.println("");
    }

    private static int helper(int[] scores, int i, int j, int[][] min, int[][] sum) {
        if (i == j) {
            return scores[i];
        }
        if (j - i == 1) {
            min[i][j] = Math.min(scores[i], scores[j]);
            sum[i][j] = scores[i] + scores[j];
            return min[i][j];
        }
        for (int k = i + 1; k < j; k++) {
            int s = 0;
            for (int l = i; l < k; l++) {
                s += scores[l];
            }
            sum[i][k - 1] = s;
            s = 0;
            for (int l = k + 1; l <= j; l++) {
                s += scores[l];
            }
            sum[k + 1][j] = s;
            min[i][k - 1] = helper(scores, i, k - 1, min, sum);
            min[k + 1][j] = helper(scores, k + 1, j, min, sum);
            min[i][j] = Math.min(min[i][k - 1], scores[k]);
            min[i][j] = Math.min(min[i][j], min[k + 1][j]);
        }
        return min[i][j];
    }

}
