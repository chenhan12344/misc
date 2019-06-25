package leetcode.medium;

/**
 * Created by 44399 on 2019/6/23
 *
 * @author 44399
 */
public class LC240 {

    public static void main(String[] args) {
        System.out.println(new LC240().searchMatrix(new int[][]{
                {2, 5},
                {2, 8},
                {7, 11},
                {9, 11}
        }, 7));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        if (height == 0) {
            return false;
        }
        int width = matrix[0].length;
        if (width == 0) {
            return false;
        }
        int i = 0, j;
        while (i < Math.min(width, height) - 1) {
            if (matrix[i][i] < target) {
                i++;
            } else {
                break;
            }
        }
        j = i;
        if (matrix[i][i] < target) {
            if (width > height) {
                while (j < width - 1) {
                    if (matrix[i][j] < target) {
                        j++;
                    } else {
                        break;
                    }
                }
            } else if (width < height) {
                while (i < height - 1) {
                    if (matrix[i][j] < target) {
                        i++;
                    } else {
                        break;
                    }
                }
            } else {
                return false;
            }
        }
        if (i > 0) {
            for (int col = j; col < width; col++) {
                if (matrix[i - 1][col] == target) {
                    return true;
                }
            }
        }
        for (int col = j; col >= 0; col--) {
            if (matrix[i][col] == target) {
                return true;
            }
        }
        return false;
    }
}
