package leetcode.medium;

/**
 * Created by DJH on 2018/11/11
 */
public class LC97 {

    public static void main(String[] args) {
        System.out.println(combination(
                "aabcc",
                "dbbca",
                "aadbcbbcac"
        ));
    }


    private static boolean combination(String s1, String s2, String s3) {
        if ((s1 + s2).equals(s3) || (s2 + s1).equals(s3)) {
            return true;
        }
        if (!lastCharOf(s1).equals(lastCharOf(s3)) && lastCharOf(s2).equals(lastCharOf(s3))) {
            return false;
        }
        if (lastCharOf(s1).equals(lastCharOf(s2))) {
            return combination(decrease(s1), s2, decrease(s3)) || combination(s1, decrease(s2), decrease(s3));
        } else if (lastCharOf(s1).equals(lastCharOf(s3))) {
            return combination(decrease(s1), s2, decrease(s3));
        } else {
            return combination(s1, decrease(s2), decrease(s3));
        }
    }

    private static String decrease(String s) {
        if (s.length() == 1) {
            return "";
        } else {
            return s.substring(0, s.length() - 1);
        }
    }

    private static String lastCharOf(String s) {
        return s.substring(s.length() - 1);
    }
}
