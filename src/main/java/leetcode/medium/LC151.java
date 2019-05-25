package leetcode.medium;

/**
 * Created by Sky on 2019/1/9
 *
 * @author Sky
 */
public class LC151 {

    public static void main(String[] args) {
        System.out.println(new LC151().reverseWords("  the     sky   is   blue   "));
    }

    public String reverseWords(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        char[] reverted = new char[len];
        int begin = 0, end = 0, index = len - 1;
        int count = 0;
        while (chars[begin] == ' ') {
            begin++;
            end++;
        }
        while (end < len) {
            while (end < len && chars[end] != ' ') {
                end++;
            }
            end--;
            for (int i = end; i >= begin; i--, index--) {
                reverted[index] = chars[i];
                count++;
            }
            if (index == -1 || end == len - 1) {
                break;
            }

            reverted[index--] = ' ';
            count++;
            begin = end + 1;
            while (begin < len && chars[begin] == ' ') {
                begin++;
            }
            if (chars[--begin] == ' ') {
                break;
            }
            end = begin;
        }
        return new String(reverted, index + 1, count);
    }

}
