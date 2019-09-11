import java.util.Scanner;

/**
 * Created by 44399 on 2019/9/1
 *
 * @author 44399
 */
public class Tencent1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 宝箱数量
        int m = scanner.nextInt();  // 钥匙数量
        int oddBox = 0, evenBox = 0;
        int oddKey = 0, evenKey = 0;
        for (int i = 0; i < n; i++) {
            if ((scanner.nextInt() & 1) == 0) {
                evenBox++;
            } else {
                oddBox++;
            }
        }
        for (int i = 0; i < m; i++) {
            if ((scanner.nextInt() & 1) == 0) {
                evenKey++;
            } else {
                oddKey++;

            }
        }
        System.out.println(Math.min(oddKey, evenBox) + Math.min(evenKey, oddBox));
    }
}
