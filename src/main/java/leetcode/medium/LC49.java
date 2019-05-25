package leetcode.medium;

import java.util.*;

/**
 * Created by 44399 on 2019/1/31
 *
 * @author 44399
 */
public class LC49 {


    public static void main(String[] args) {
        System.out.println(new LC49().groupAnagrams(new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        }));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> anagramsMap = new HashMap<>();
        for (String s : strs) {
            int key = productOfString(s);
            List<String> stringList = anagramsMap.getOrDefault(key, new LinkedList<>());
            stringList.add(s);
            anagramsMap.put(key, stringList);
        }
        return new ArrayList<>(anagramsMap.values());
    }

    private static int productOfString(String s) {
        int product = 1;
        for (char c : s.toCharArray()) {

        }
        return product;
    }

}
