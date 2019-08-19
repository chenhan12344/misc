package tencent;

import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/17
 *
 * @author 44399
 */
public class Tencent4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int builds = scanner.nextInt();
        int[] heights = new int[builds];
        int[] dpF = new int[builds];
        int[] dpB = new int[builds];
        dpB[0] = 0;
        dpB[1] = 1;
        for (int i = 2; i < builds; i++) {
            if (dpB[i - 1] > dpB[i - 2]) {
                dpB[i] = 1;
            } else {
                dpB[i] = 1;
            }
        }
    }
}
