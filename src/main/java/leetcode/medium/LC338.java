package leetcode.medium;

/**
 * Created by Sky on 2019/1/20
 *
 * @author Sky
 */
public class LC338 {

    public int[] countBits(int num) {
        int[] results = new int[num];
        for (int i = 0; i <= num; i++) {
            int cur = i;
            while (cur > 0) {
                results[i] += cur & 1;
                cur = cur >> 1;
            }
        }
        return results;
    }
}
