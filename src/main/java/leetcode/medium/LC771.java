package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DJH on 2018/11/13
 */
public class LC771 {

    public static void main(String[] args) {

    }

    public static int numJewelsInStones(String J, String S) {
        Set<Character> charSet = new HashSet<>();
        for (char c : J.toCharArray()) {
            charSet.add(c);
        }
        int count = 0;
        for (char s : S.toCharArray()) {
            if (charSet.contains(s)) {
                count++;
            }
        }
        return count;
    }

}
