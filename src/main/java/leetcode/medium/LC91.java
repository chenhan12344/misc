package leetcode.medium;

/**
 * Created by Sky on 2019/5/20
 *
 * @author Sky
 */
public class LC91 {

    public static void main(String[] args) {
        System.out.println(new LC91().numDecodings("1234532015"));
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        if (s.length() < 2) {
            return 1;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '0') {
                /* 第i位是0的情况 */
                if (s.charAt(i - 1) < '3' && s.charAt(i - 1) > '0') {
                    dp[i] = get(dp, i - 2);
                } else {
                    return 0;
                }
            } else {
                /* 第i位不是0的情况 */
                if (s.charAt(i - 1) == '0') {
                    dp[i] = get(dp, i - 1);
                } else {
                    if (Integer.valueOf(s.substring(i - 1, i + 1)) > 26) {
                        dp[i] = get(dp, i - 1);
                    } else {
                        dp[i] = get(dp, i - 1) + get(dp, i - 2);
                    }
                }
            }
        }
        return dp[len - 1];
    }

    private static int get(int[] dp, int i) {
        if (i < 0) {
            return 1;
        } else {
            return dp[i];
        }
    }


}
