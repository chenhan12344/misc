package leetcode.medium;

/**
 * Created by Sky on 2019/1/7
 *
 * @author Sky
 */
public class LC564 {

    public static void main(String[] args) {
        System.out.println(new LC564().nearestPalindromic("101"));
    }

    public String nearestPalindromic(String n) {
        n = handlePalindrome(n);
        if (n.equals("10")) {
            return "9";
        }
        char[] chars = n.toCharArray();
        int len = chars.length;
        if (len % 2 == 0) {
            for (int i = 0; i < len / 2; i++) {
                chars[len - 1 - i] = chars[i];
            }
        } else {
            for (int i = 0; i < len / 2 + 1; i++) {
                chars[len - 1 - i] = chars[i];
            }
        }
        return new String(chars);
    }

    private String handlePalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - 1 - i]) {
                return s;
            }
        }
        long n = Long.parseLong(s);
        if (len % 2 == 0) {
            n -= (long) Math.pow(10, len / 2);
        } else {
            n -= (long) Math.pow(10, len / 2 + 1);
        }
        return Long.toString(n);
    }

}
