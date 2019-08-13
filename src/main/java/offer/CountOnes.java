package offer;

/**
 * Created by Sky on 2019/6/26
 *
 * @author Sky
 */
public class CountOnes {


    public static void main(String[] args) {
        System.out.println(new CountOnes().NumberOf1(-7));
    }

    public int NumberOf1(int n) {
        int count = n > 0 ? 0 : 1;
        if (n < 0) {
            n &= (Integer.MAX_VALUE);
        }
        while (n > 0) {
            count += ((n & 1) == 1) ? 1 : 0;
            n >>= 1;
        }
        return count;
    }


}
