package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sky on 2019/1/20
 *
 * @author Sky
 */
public class LC54 {

    public static void main(String[] args) {
        System.out.println(new LC54().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>(0);
        }
        int m = matrix.length,
                n = matrix[0].length;
        List<Integer> result = new ArrayList<>(m * n);
        int leftBorder = 0, rightBorder = n - 1, topBorder = 0, bottomBorder = m - 1;
        do {
            //从左上到右上遍历
            for (int i = leftBorder; i <= rightBorder; i++) {
                result.add(matrix[topBorder][i]);
            }
            if (topBorder++ >= bottomBorder) {
                break;
            }
            //从右上到右下遍历
            for (int i = topBorder; i <= bottomBorder; i++) {
                result.add(matrix[i][rightBorder]);
            }
            if (rightBorder-- <= leftBorder) {
                break;
            }
            //从右下到左下遍历
            for (int i = rightBorder; i >= leftBorder; i--) {
                result.add(matrix[bottomBorder][i]);
            }
            if (bottomBorder-- <= topBorder) {
                break;
            }
            //从左下到左上遍历
            for (int i = bottomBorder; i >= topBorder; i--) {
                result.add(matrix[i][leftBorder]);
            }
            leftBorder++;
        } while (topBorder <= bottomBorder && leftBorder <= rightBorder);
        return result;
    }

}
