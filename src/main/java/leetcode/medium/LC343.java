package leetcode.medium;

/**
 * Created by 44399 on 2019/6/30
 *
 * @author 44399
 */
public class LC343 {

    public static void main(String[] args) {
        System.out.println(new LC343().integerBreak(10));
    }

    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        int max = (n / 2) * ((n + 1) / 2);
        for (int i = 3; i < n; i++) {
            int base1 = (n / i);
            int base2 = base1 + 1;
            int base1Num = (i - n % i);
            int base2Num = i - base1Num;
            max = Math.max(max, pow(base1, base1Num) * pow(base2, base2Num));
        }
        return max;
    }

    private static int pow(int base, int exp) {
        if (base == 0) {
            return 0;
        }
        if (exp == 0) {
            return 1;
        }
        int res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res *= base;
            }
            exp >>= 1;
            base *= base;
        }
        return res;
    }
}
