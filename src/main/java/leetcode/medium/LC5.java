package leetcode.medium;

/**
 * Created by Sky on 2019/3/31
 *
 * @author Sky
 */
public class LC5 {

    public static void main(String[] args) {
        System.out.println(new LC5().longestPalindrome("ccc"));
    }


    private String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLength = 0;
        String s1 = "", s2 = "";
        for (int i = 0; i < s.length() - 1; i++) {

            int front = i, end = i;
            while (front < s.length() && end >= 0 && (s.charAt(front) == s.charAt(end))) {
                front++;
                end--;
            }
            front--;
            end++;
            if (front - end + 1 > maxLength) {
                maxLength = front - end + 1;
                s1 = s.substring(end, front + 1);
            }

            front = i + 1;
            end = i;
            while (front < s.length() && end >= 0 && (s.charAt(front) == s.charAt(end))) {
                front++;
                end--;
            }
            front--;
            end++;
            if (front - end + 1 > maxLength) {
                maxLength = front - end + 1;
                s2 = s.substring(end, front + 1);
            }

        }
        return s1.length() > s2.length() ? s1 : s2;
    }

}
