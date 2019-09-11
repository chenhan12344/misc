package offer;

/**
 * Created by 44399 on 2019/9/8
 *
 * @author 44399
 */
public class InversedPairs {

    public static void main(String[] args) {
        System.out.println(new InversedPairs().inversePairs(
                new int[]{1, 2, 3, 4, 5, 0, 7, 0}
        ));
    }

    public int inversePairs(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = arr[1] < arr[0] ? 1 : 0;
        for (int i = 2; i < len; i++) {


        }
        int sum = 0;
        for (int i = 1; i < len; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
