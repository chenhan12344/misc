package leetcode.medium;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DJH on 2019/1/2
 */
public class LC524 {

    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
    }

    public static String findLongestWord(String s, List<String> d) {
        d.sort((s1, s2) -> {
            if (s1.length() == s2.length()) {
                char[] array1 = s1.toCharArray(),
                        array2 = s2.toCharArray();
                for (int i = 0; i < array1.length; i++) {
                    if (array1[i] != array2[i]) {
                        return array2[i] - array1[i];
                    }
                }
                return 0;
            } else {
                return s2.length() - s1.length();
            }
        });


        for (String target : d) {
            if (containsSubString(s, target)) {
                return target;
            }
        }
        return "";
    }

    private static boolean containsSubString(String origin, String target) {
        if (target.isEmpty()) {
            return true;
        }
        char[] originChars = origin.toCharArray(),
                targetChars = target.toCharArray();
        int j = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (originChars[i] == targetChars[j]) {
                j++;
                if (j == targetChars.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
