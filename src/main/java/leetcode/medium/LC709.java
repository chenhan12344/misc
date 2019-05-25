package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DJH on 2018/11/13
 */
public class LC709 {

    public static void main(String[] args) {

    }

    public static String toLowerCase(String str) {
        Map<Character, Character> caseMap = new HashMap<>();
        caseMap.put('A', 'a');
        caseMap.put('B', 'b');
        caseMap.put('C', 'c');
        caseMap.put('D', 'd');
        caseMap.put('E', 'e');
        caseMap.put('F', 'f');
        caseMap.put('G', 'g');
        caseMap.put('H', 'h');
        caseMap.put('I', 'i');
        caseMap.put('J', 'j');
        caseMap.put('K', 'k');
        caseMap.put('L', 'l');
        caseMap.put('M', 'm');
        caseMap.put('N', 'n');
        caseMap.put('O', 'o');
        caseMap.put('P', 'p');
        caseMap.put('Q', 'q');
        caseMap.put('R', 'r');
        caseMap.put('S', 's');
        caseMap.put('T', 't');
        caseMap.put('U', 'u');
        caseMap.put('V', 'v');
        caseMap.put('W', 'w');
        caseMap.put('X', 'x');
        caseMap.put('Y', 'y');
        caseMap.put('Z', 'z');
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (caseMap.containsKey(chars[i])) {
                chars[i] = caseMap.get(chars[i]);
            }
        }
        return new String(chars);
    }
}
