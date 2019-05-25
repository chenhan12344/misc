package leetcode.medium;

/**
 * Created by Sky on 2019/1/5
 *
 * @author Sky
 */
public class LC886 {

    public static void main(String[] args) {
        System.out.println(new LC886().primePalindrome(932434374));
    }

    public int primePalindrome(int N) {
        if (N < 3) {
            return 2;
        }
        int begin = N % 2 == 0 ? N + 1 : N;
        while (!isPalindrome(begin) || !isPrime(begin)) {
            begin += 2;
        }
        return begin;
    }

    private static boolean isPrime(int n) {
        if (n < 4) {
            return true;
        }
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        double sqrt = (int) Math.ceil(Math.sqrt(n));
        for (int i = 5; i < sqrt; i++) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(Integer n) {
        String ns = n.toString();
        int len = ns.length();
        for (int i = 0; i < len / 2; i++) {
            if (ns.charAt(i) != ns.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
