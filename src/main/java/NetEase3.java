import java.util.Scanner;

public class NetEase3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();          // 样例总数
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();      // 喝咖啡的间隔
            int m = scanner.nextInt();
            int[] coffeeDays = new int[m];   // 固定喝咖啡的日子
            for (int j = 0; j < m; j++) {
                coffeeDays[j] = scanner.nextInt();
            }
            System.out.println(helper(k, coffeeDays));
        }

    }

    private static int helper(int k, int[] coffeeDays) {
        int len = coffeeDays.length;
        int totalCups = 0;
        if (len > 0) {
            int day = coffeeDays[0];
            int index = 0;
            int kk = 0;
            while (day <= coffeeDays[len - 1]) {
                if (index < len && day == coffeeDays[index]) {
                    totalCups++;
                    kk = k;
                    index++;
                } else {
                    if (kk <= 0 && coffeeDays[index] - day > k) {
                        totalCups++;
                        kk = k;
                    } else {
                        kk--;
                    }
                }
                day++;
            }
            for (day = coffeeDays[0] - 1, kk = k; day >= 1; day--) {
                if (kk <= 0) {
                    totalCups++;
                    kk = k;
                } else {
                    kk--;
                }
            }
            for (day = coffeeDays[len - 1] + 1, kk = k; day <= 30; day++) {
                if (kk <= 0) {
                    totalCups++;
                    kk = k;
                } else {
                    kk--;
                }
            }
        } else {
            for (int day = 1, kk = 0; day <= 30; day++) {
                if (kk <= 0) {
                    totalCups++;
                    kk = k;
                } else {
                    kk--;
                }
            }
        }
        return totalCups;
    }
}
