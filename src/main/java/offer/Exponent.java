package offer;

/**
 * Created by Sky on 2019/6/27
 * 求一个浮点数的整数次幂
 * 注：不得使用Math类
 *
 * @author Sky
 */
public class Exponent {
    /**
     * @param base     底数
     * @param exponent 指数
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        boolean reciprocal = exponent < 0;
        exponent = reciprocal ? -exponent : exponent;
        double res = 1.0;

        /*
         * 利用指数移位的思想
         * 当指数可以被2整除时，a^n = a^(n/2) * a^(n/2)
         * 当指数不可以被2整除时，a^n = a^(n/2) * a^(n/2) * a
         *
         * 指数可以被2整除时，指数自乘
         * 指数不可被2整数时，res先乘以指数，指数再自乘
         *
         * +------+-------+----------+---------+
         * | base |  res  | exponent | exp % 2 |
         * +------+-------+----------+---------+
         * | a^1  | 1     |    13    |    1    |
         * | a^2  | a     |     6    |    0    |
         * | a^4  | a     |     3    |    1    |
         * | a^8  | a^5   |     1    |    1    |
         * | a^16 | a^13  |     0    |    0    |
         * +------+-------+----------+---------+
         */
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                res *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return reciprocal ? 1.0 / res : res;
    }
}
