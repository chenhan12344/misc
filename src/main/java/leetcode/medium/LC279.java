package leetcode.medium;

import java.util.LinkedList;

/**
 * Created by 44399 on 2019/7/1
 *
 * @author 44399
 */
public class LC279 {

    public int numSquares(int n) {
        int coinNumber = (int) Math.sqrt(n);
        int[] coins = new int[coinNumber];
        for (int i = 0; i < coinNumber; i++) {
            coins[i] = (i + 1) * (i + 1);
        }
        boolean[] visited = new boolean[n + 1];
        int depth = 1;
        int count = 1;
        int nextCount = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        do {
            for (int i = coins.length - 1; i >= 0; i--) {
                if (n < coins[i]) {
                    continue;
                }
                if (n == coins[i]) {
                    return depth;
                }
                if (!visited[n - coins[i]]) {
                    queue.addLast(n - coins[i]);
                    nextCount++;
                    visited[n - coins[i]] = true;
                }
            }
            if (--count == 0) {
                depth++;
                count = nextCount;
                nextCount = 0;
            }
            n = queue.pollFirst();
        } while (true);
    }
}
