package offer;

/**
 * Created by Sky on 2019/6/26
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author Sky
 */
public class JumpFloor {

    public int jumpFloor(int target) {
        int res = 1;
        for (int i = 1; i <= target - 1; i++) {
            res *= 2;
        }
        return res;
    }

    /**
     * 本题可以用动态规划，也可以用排列组合
     * 利用动态规划空间复杂度为O(n)，故使用排列组合更节约空间
     * 排列组合：将n阶台阶划分成m个部分，则有1 <= m <= n - 1
     * 若划分m个部分，则共有C(n - 1, m - 1)种划分方法。故总的台阶跳
     * 法共有C(n-1, 0) + C(n-1, 1) + ... + C(n - 1, n - 1)
     * 上述公式求和可以得到2^(n-1)。故n阶台阶共有2^(n-1)种跳法
     *
     * @param target
     * @return
     */
    public int jumpFloor1(int target) {
        int sum = 0;
        for (int i = 0; i <= target - 1; i++) {
            sum += combination(target - 1, i);
        }
        return sum;
    }

    private static int combination(int n, int m) {
        if (m == 0 || m == n) {
            return 1;
        }
        return step(n) / (step(m) * step(n - m));
    }

    private static int step(int n) {
        if (n < 2) {
            return 1;
        }
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

}
