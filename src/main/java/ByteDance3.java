import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 44399 on 2019/8/25
 * <p>
 * <p>
 * <p>
 * 1
 * 0 0 0 2
 * 0 0 0 2
 * 0 0 4 8
 * 0 0 4 8
 *
 * @author 44399
 */
public class ByteDance3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int direction = scanner.nextInt();
        int[][] matrix = new int[4][4];
        switch (direction) {
            case 1: {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        matrix[j][i] = scanner.nextInt();
                    }
                }
                onUpPress(matrix);
                printColumnFirst(matrix);
                break;
            }
            case 2: {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        matrix[j][i] = scanner.nextInt();
                    }
                }
                onDownPress(matrix);
                printColumnFirst(matrix);
                break;
            }
            case 3: {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                onLeftPress(matrix);
                printRowFirst(matrix);
                break;
            }
            case 4: {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                onRightPress(matrix);
                printRowFirst(matrix);
                break;
            }
            default: {
            }
        }

    }

    private static void onUpPress(int[][] matrix) {
        for (int col = 0; col < 4; col++) {
            Stack<Integer> stack = new Stack<>();
            for (int row = 0; row < 4; row++) {
                if (matrix[col][row] != 0) {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == matrix[col][row]) {
                            stack.push(stack.pop() * 2);
                        } else {
                            stack.push(matrix[col][row]);
                        }
                    } else {
                        stack.push(matrix[col][row]);
                    }
                }
            }
            int[] nums = new int[4];
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                nums[i] = stack.get(i);
            }
            for (int i = size; i < 4; i++) {
                nums[i] = 0;
            }
            System.arraycopy(nums, 0, matrix[col], 0, 4);
        }
    }

    private static void onDownPress(int[][] matrix) {
        for (int col = 0; col < 4; col++) {
            Stack<Integer> stack = new Stack<>();
            for (int row = 3; row >= 0; row--) {
                if (matrix[col][row] != 0) {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == matrix[col][row]) {
                            stack.push(stack.pop() * 2);
                        } else {
                            stack.push(matrix[col][row]);
                        }
                    } else {
                        stack.push(matrix[col][row]);
                    }
                }
            }
            int[] nums = new int[4];
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                nums[i] = stack.get(i);
            }
            for (int i = size; i < 4; i++) {
                nums[i] = 0;
            }
            for (int i = 0; i < 4; i++) {
                matrix[col][3 - i] = stack.get(i);
            }
        }
    }

    private static void onLeftPress(int[][] matrix) {
        for (int col = 0; col < 4; col++) {
            Stack<Integer> stack = new Stack<>();
            for (int row = 0; row < 4; row++) {
                if (matrix[col][row] != 0) {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == matrix[col][row]) {
                            stack.push(stack.pop() * 2);
                        } else {
                            stack.push(matrix[col][row]);
                        }
                    } else {
                        stack.push(matrix[col][row]);
                    }
                }
            }
            int[] nums = new int[4];
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                nums[i] = stack.get(i);
            }
            for (int i = size; i < 4; i++) {
                nums[i] = 0;
            }
            System.arraycopy(nums, 0, matrix[col], 0, 4);
        }
    }

    private static void onRightPress(int[][] matrix) {
        for (int col = 0; col < 4; col++) {
            Stack<Integer> stack = new Stack<>();
            for (int row = 0; row < 4; row++) {
                if (matrix[col][row] != 0) {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == matrix[col][row]) {
                            stack.push(stack.pop() * 2);
                        } else {
                            stack.push(matrix[col][row]);
                        }
                    } else {
                        stack.push(matrix[col][row]);
                    }
                }
            }
            int[] nums = new int[4];
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                nums[i] = stack.get(i);
            }
            for (int i = size; i < 4; i++) {
                nums[i] = 0;
            }
            System.arraycopy(nums, 0, matrix[col], 0, 4);
        }
    }

    private static void printColumnFirst(int[][] matrix) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }

    private static void printRowFirst(int[][] matrix) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
