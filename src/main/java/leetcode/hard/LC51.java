package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 44399 on 2019/2/19
 *
 * @author 44399
 */
public class LC51 {

    public static void main(String[] args) {
        for (List<String> list : new LC51().solveNQueens(4)) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    /**
     * N皇后问题
     * 从第一行开始，依次选择位置， 如果当前位置满足条件，则向下选位置，
     * 如果不满足条件，那么当前位置后移一位。
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        int[] matrix = new int[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = (1 << n);
        }
        int index = n - 1;
        while (matrix[0] > 0) {
            int valid = 0;
            for (int i = 0; i < n; i++) {
                valid |= matrix[i];
            }
            if (valid != (1 << n + 1) - 1) {
                List<String> result = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    result.add(String.valueOf(matrix[i]));
                }
                results.add(result);
            }
            int tempIndex = index;
            do {
                matrix[tempIndex] >>= 1;
                if (matrix[tempIndex] == 0) {
                    matrix[tempIndex--] = (1 << n);
                }
            } while (tempIndex > 0);
        }
        return results;
    }

    private static void printQueens(int[] arr) {
        int n = arr.length;
        String[] strings = new String[n];
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = '.';
        }
    }
}
