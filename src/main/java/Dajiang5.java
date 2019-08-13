import java.util.Scanner;

/**
 * Created by Sky on 2019/8/6
 *
 * @author Sky
 */
public class Dajiang5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int snackCount = scanner.nextInt();
        int[] price = new int[snackCount];
        for (int i = 0; i < snackCount; i++) {
            price[i] = scanner.nextInt();
        }
        int favouriteCount = scanner.nextInt();
        int[] favour = new int[favouriteCount];
        for (int i = 0; i < favouriteCount; i++) {
            favour[i] = scanner.nextInt();
        }
    }

}
