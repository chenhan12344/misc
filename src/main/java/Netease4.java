import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/11
 *
 * @author 44399
 */
public class Netease4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            maxContinuousN(s);
        }
    }

    private static int maxContinuousN(String s) {
        List<Integer> g1 = new ArrayList<>();      //所有间隔为1的串
        List<Integer> g2 = new ArrayList<>();      //所有间隔为2的串
        int len = 0, gap = 0;
        int index = 0;
        while (s.charAt(index) != 'N') {
            index++;
        }
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) != 'N') {
                gap++;
            } else {
                if (gap > 0) {
                    if (gap == 1) {
                        g1.add(len);
                        len = 1;
                    }
                    if (gap == 2) {
                        g2.add(len);
                        len = 1;
                    }
                    gap = 0;
                    continue;
                }
                len++;
            }
        }
        System.out.println(g1);
        System.out.println(g2);
        return 0;
    }
}
