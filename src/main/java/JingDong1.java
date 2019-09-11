import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/24
 *
 * @author 44399
 */
public class JingDong1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 2) {
            System.out.println(n);
            return;
        }
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        List<Interval> intervalList = new ArrayList<>();
        int start = 0, end;
        for (int i = 0; ; i++) {
            if (i == n - 1) {
                intervalList.add(new Interval(heights[start], heights[n - 1]));
                break;
            }
            if (heights[i + 1] >= heights[i]) {
                end = i;
                intervalList.add(new Interval(heights[start], heights[end]));
                start = i + 1;
            }
        }
        Interval prev = intervalList.get(0);
        int prevIdx = 0;
        for (int i = 1; i < intervalList.size(); i++) {
            Interval cur = intervalList.get(i);
            if (cur.min < prev.max) {
                int idx = i;
                while ((--idx) > prevIdx) {
                    if (intervalList.get(idx).max <= cur.max) {
                        for (int k = 0; k < (i - idx); k++) {
                            intervalList.remove(prevIdx + 1);
                        }
                        i = prevIdx + 1;
                    }
                }
            } else {
                prev = cur;
            }
        }


        System.out.println(intervalList.size());
    }

    private static class Interval {
        int min;
        int max;

        public Interval(int a, int b) {
            this.min = Math.min(a, b);
            this.max = Math.max(a, b);
        }
    }
}
