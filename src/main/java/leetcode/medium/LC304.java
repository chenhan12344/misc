package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by 44399 on 2019/6/23
 *
 * @author 44399
 */
public class LC304 {


    public int[] pickNRadomNumbers(int[] nums, int n) {
        int m = nums.length;
        int[] pickedNumbers = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            // 从第0个数开始到n-1个数，从数组总随机选取一个数与之交换
            int j = random.nextInt(m - i) + i;
            swap(nums, i, j);
        }
        // 最后选取前n个数
        System.arraycopy(nums, 0, pickedNumbers, 0, n);
        return pickedNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


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
