import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 44399 on 2019/8/25
 *
 * @author 44399
 */


public class ByteDance4 {

    //TLE
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int candy[] = new int[n];
        for (int i = 0; i < n; i++) {
            candy[i] = scanner.nextInt();
        }
        boolean[] searched = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (searched[i]) {
                continue;
            }
            searched[i] = true;
            Set<Integer> s0 = new HashSet<>();
            Set<Integer> s1 = new HashSet<>();
            s0.add(i);
            int count = 1;
            while (!s0.isEmpty()) {
                for (int index : s0) {
                    for (int j = 0; j < n; j++) {
                        if (index != j && !searched[j] && isConnected(candy[index], candy[j])) {
                            s1.add(j);
                            searched[j] = true;
                            count++;
                        }
                    }
                }
                s0.clear();
                Set<Integer> tmp = s0;
                s0 = s1;
                s1 = tmp;
            }
            result = Math.max(count, result);
        }
        System.out.println(result);
    }

    private static boolean isConnected(int i, int j) {
        int tmp;
        if (i < j) {
            tmp = i;
            i = j;
            j = tmp;
        }
        while (j != 0) {
            tmp = i % j;
            i = j;
            j = tmp;
        }
        return i != 1;
    }
}
