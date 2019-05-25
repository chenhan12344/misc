package leetcode.medium;

import java.util.*;

/**
 * Created by Sky on 2019/1/7
 *
 * @author Sky
 */
public class LC22 {

    private static final char LEFT_BRACE = '(';
    private static final char RIGHT_BRACE = ')';

    public static void main(String[] args) {
        System.out.println(new LC22().generateParenthesis(5));
    }

    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Collections.singletonList("()");
        } else {
            Set<String> inserted = new HashSet<>();
            List<String> results = generateParenthesis(n - 1);
            for (String s : results) {
                int len = s.length();
                for (int i = 0; i <= len; i++) {
                    StringBuilder sb = new StringBuilder(s);
                    sb.insert(i, LEFT_BRACE);
                    for (int j = i + 1; j <= s.length(); j++) {
                        inserted.add(new StringBuilder(sb).insert(j, RIGHT_BRACE).toString());
                    }
                }
            }
            return new ArrayList<>(inserted);
        }
    }
}
