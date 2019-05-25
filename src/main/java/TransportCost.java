import java.util.Scanner;

/**
 * Created by Sky on 2019/4/14
 *
 * @author Sky
 */
public class TransportCost {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] fees = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fees[i][j] = scanner.nextInt();
            }
        }


    }


    private static int minFee(int n, int[][] fees) {
        return 0;


    }
}
