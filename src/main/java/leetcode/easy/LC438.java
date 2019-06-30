package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sky on 2019/6/14
 *
 * @author Sky
 */
public class LC438 {

    public static void main(String[] args) {
        System.out.println(new LC438().findAnagrams(


                "",
                "abc"
        ));
    }


    public List<Integer> findAnagrams(String s, String p) {
//        if (s.isEmpty() || p.isEmpty() || s.length() < p.length()) {
//            return new ArrayList<>(0);
//        }
        int sLen = s.length(), pLen = p.length(), loops = sLen - pLen;
        List<Integer> results = new ArrayList<>(s.length());
        long[] hashCodes = new long[26];
        for (int i = 0; i < 26; i++) {
            hashCodes[i] = new Object().hashCode();
        }

        long hash = 0L;
        for (int i = 0; i < Math.min(sLen, pLen); i++) {
            hash += hashCodes[s.charAt(i) - 97];
        }


        long targetHash = 0L;
        for (char c : p.toCharArray()) {
            targetHash += hashCodes[c - 97];
        }
        char[] sCharArray = s.toCharArray();


        int index = 0;
        do {
            if (hash == targetHash) {
                results.add(index);
            }
            if (++index > loops) {
                break;
            }
            hash = hash - hashCodes[sCharArray[index - 1] - 97] +
                    hashCodes[sCharArray[index + pLen - 1] - 97];
        } while (true);
        return results;
    }
}
