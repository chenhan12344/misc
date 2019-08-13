package offer;

/**
 * Created by Sky on 2019/8/7
 * <p>
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 *
 * @author Sky
 */
public class NumberOfOne {

    public static void main(String[] args) {
        System.out.println(new NumberOfOne().NumberOf1Between1AndN_Solution(21345 + 1));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        int exp = 10;
        while (true) {
            int a = n / 10;
            res += a;
            int b = n % exp;
            if (b > exp / 10) {
                res += exp / 10;
            } else {
                res +=
            }
            exp *= 10;
        }
    }
}
