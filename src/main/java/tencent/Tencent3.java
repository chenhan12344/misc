package tencent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/17
 *
 * @author 44399
 */
public class Tencent3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int L = scanner.nextInt();
        ArrayList<int[]> ranges = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int[] range = new int[2];
            range[0] = scanner.nextInt();
            range[1] = scanner.nextInt();
            ranges.add(range);
        }
        ranges.sort(Comparator.comparingInt(r -> r[0]));
        if (ranges.get(0)[0] > 0) {
            System.out.println(-1);
        }
        int result = 1;
        int[] coverableRange = ranges.get(0);
        for (int index = 1, len = ranges.size(); index < len; index++) {
            int[] range = ranges.get(index);
            if (range[0] >= coverableRange[0] && range[1] <= coverableRange[1]) {
                continue;
            }
            if (range[0] == coverableRange[0]) {
                coverableRange[1] = Math.max(range[1], coverableRange[1]);
                continue;
            }
            if (range[1] > coverableRange[1]) {
                coverableRange[1] = range[1];
                result++;
            }
        }
        System.out.println(coverableRange[1] >= L ? result : -1);
    }

}
