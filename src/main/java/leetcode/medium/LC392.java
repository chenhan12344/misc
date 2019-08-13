package leetcode.medium;

/**
 * Created by 44399 on 2019/6/30
 *
 * @author 44399
 */
public class LC392 {

    public static void main(String[] args) {
        System.out.println(new LC392().isSubsequence("abc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.isEmpty()) {
            return false;
        }
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == t.length()) {
            return s.equals(t);
        }

        int slen = s.length(), tlen = t.length(),
                si = 0, sj = slen - 1, ti = 0, tj = tlen - 1;
        while (ti <= tj) {
            while (ti <= tj) {
                if (t.charAt(ti) != s.charAt(si)) {
                    ti++;
                } else {
                    ti++;
                    si++;
                    break;
                }
            }
            while (ti <= tj) {
                if (t.charAt(tj) != s.charAt(sj)) {
                    tj--;
                } else {
                    tj--;
                    sj--;
                    break;
                }
            }
            if (sj < si) {
                return true;
            }
        }
        return false;
    }
}
