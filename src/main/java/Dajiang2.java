import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/4
 *
 * @author 44399
 */
public class Dajiang2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //bug总数
        int a = scanner.nextInt(); //提升的效率倍数
        int x = scanner.nextInt(); //最多喝的杯数
        int[] time = new int[n];   //
        for (int i = 0; i < n; i++) {
            time[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a, x, time));
    }

    private static int solve(int n, int a, int x, int[] time) {
        int total = n * a * x;
        int totalTime = 0;
        for (int i = 0; i < time.length; i++) {
            totalTime += time[i];
        }
        int res;
        if (total > totalTime) {
            res = (int) Math.ceil(totalTime / (a * 1.0));
        } else {
            totalTime -= total;
            res = (int) (Math.ceil(totalTime / (a * 1.0))) + 60 * n;
        }
        return res > 8 * 60 ? 0 : res;
    }
}
