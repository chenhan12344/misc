package leetcode.medium;

/**
 * Created by DJH on 2018/11/13
 */
public class LC344 {

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }

    public static String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
