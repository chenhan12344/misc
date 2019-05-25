package leetcode.medium;

/**
 * Created by Sky on 2019/1/20
 *
 * @author Sky
 */
public class LC43 {

    public static void main(String[] args) {
        System.out.println(new LC43().multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {

        int len1 = num1.length(),
                len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                result[i + j + 1] += (a * b) % 10;
                result[i + j] += (a * b) / 10;
            }
        }
        for (int i = result.length - 1; i >= 1; i--) {
            if (result[i] >= 10) {
                result[i - 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < result.length - 1 &&
                result[i] == 0) {
            i++;
        }
        for (; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

}
