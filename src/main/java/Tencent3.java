import java.util.Scanner;

/**
 * Created by 44399 on 2019/9/1
 *
 * @author 44399
 */
public class Tencent3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 办公室数量
        int m = scanner.nextInt();  // 搬运工数量
        int boxes[] = new int[n];
        for (int i = 0; i < n; i++) {
            boxes[i] = scanner.nextInt();
        }

    }
}
