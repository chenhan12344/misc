import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 44399 on 2019/9/8
 *
 * @author 44399
 */
public class ByteDance5 {

    private static final int TURN_LEFT = -1;
    private static final int TURN_RIGHT = -2;

    enum Direction {
        LEFT,
        RIGHT
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        int[] map = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            String input = scanner.next();
            if ("<".equals(input)) {
                map[i] = TURN_LEFT;
            } else if (">".equals(input)) {
                map[i] = TURN_RIGHT;
            } else {
                map[i] = Integer.parseInt(input);
            }
        }
        for (int i = 0; i < q; i++) {
            int[] newMap = new int[n + 1];
            System.arraycopy(map, 0, newMap, 0, n + 1);
            System.out.println(playGame(newMap, scanner.nextInt(), scanner.nextInt()));
        }
    }

    private static int playGame(int[] map, int start, int end) {
        int len = map.length;
        boolean[] accessible = new boolean[len];
        Arrays.fill(accessible, true);
        accessible[0] = false;
        Direction direction = Direction.RIGHT;
        int index = start, score = 0;
        while (true) {
            switch (map[index]) {
                case TURN_LEFT: {
                    direction = Direction.LEFT;
                    break;
                }
                case TURN_RIGHT: {
                    direction = Direction.RIGHT;
                    break;
                }
                default: {
                    if (map[index] > 0) {
                        score += map[index];
                        map[index]--;
                    } else {
                        accessible[index] = false;
                    }
                }
            }
            switch (direction) {
                case LEFT: {
                    index--;
                    if (isGameOver(start, end, index)) {
                        return score;
                    } else {
                        if (!accessible[index]) {
                            return score;
                        }
                    }
                    break;
                }
                case RIGHT: {
                    index++;
                    if (isGameOver(start, end, index)) {
                        return score;
                    } else {
                        if (!accessible[index]) {
                            return score;
                        }
                    }
                    break;
                }
            }
        }
    }

    private static boolean isGameOver(int start, int end, int index) {
        return index < start || index > end;
    }
}
