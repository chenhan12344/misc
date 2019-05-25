package leetcode.easy;

/**
 * Created by 44399 on 2019/2/26
 *
 * @author 44399
 */
public class LC70 {

    public static void main(String[] args) {
        System.out.println(new LC70().climbStairs(10));
        System.out.println(new LC70().climbStairs2(10));
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1, b = 2, temp = 0;
        for (int i = 2; i < n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
