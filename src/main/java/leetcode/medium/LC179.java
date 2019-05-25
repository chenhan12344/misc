package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 44399 on 2019/2/4
 *
 * @author 44399
 */
public class LC179 {

    public static void main(String[] args) {
        System.out.println(new LC179().solution(new int[]{
                824824823, 824
        }));
    }

    public String largestNumber(int[] nums) {
        List<String> numStrings = new ArrayList<>(nums.length);
        for (int num : nums) {
            numStrings.add(String.valueOf(num));
        }
        numStrings.sort((s1, s2) -> {
            int len1 = s1.length(), len2 = s2.length();
            for (int i = 0, j = 0, k = 0; k < Math.max(len1, len2); k++) {
                int diff = s1.charAt(i) - s2.charAt(j);
                if (diff != 0) {
                    return diff > 0 ? -1 : 1;
                }
                i = ++i % len1;
                j = ++j % len2;
            }
            return len1 - len2;
        });
        String result = String.join("", numStrings);
        return result.startsWith("0") ? "0" : result;
    }

    public String solution(int[] nums) {
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrings, (s1, s2) -> {
            String order1 = s1 + s2;
            String order2 = s2 + s1;
            return order2.compareTo(order1);
        });
        return String.join("", numStrings);
    }
}
