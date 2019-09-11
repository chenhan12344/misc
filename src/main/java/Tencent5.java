import java.util.Scanner;

/**
 * Created by 44399 on 2019/9/1
 *
 * @author 44399
 */
public class Tencent5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(plan(scanner.nextInt(), scanner.nextInt(), k));
        }
    }

    private static int plan(int begin, int end, int k) {
        int res = 0;
        for (int l = begin; l <= end; l++) {
            int ks = l / k;
            for (int n = 0; n <= ks; n++) {
                int remaining = l - k * n;
                res += Math.pow(n + 1, remaining);
            }
        }
        return res;
    }
}
