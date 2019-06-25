package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 44399 on 2019/6/23
 *
 * @author 44399
 */
public class LC304 {

    class NumMatrix {

        private int[][] sum;
        private int width;
        private int height;

        private Map<String, Integer> cache = new HashMap<>();

        public NumMatrix(int[][] matrix) {
            width = matrix.length;
            height = matrix[0].length;
            if (width * height == 0) {
                return;
            }
            sum = new int[width + 1][height + 1];
            for (int i = 0; i < matrix.length; i++) {
                int tmp = 0;
                for (int j = 0; j < matrix[0].length; j++) {
                    tmp += matrix[i][j];
                    sum[i + 1][j + 1] = sum[i][j + 1] + tmp;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (width * height == 0) {
                return 0;
            }
            return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
        }
    }
}
