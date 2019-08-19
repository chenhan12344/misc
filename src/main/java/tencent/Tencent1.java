package tencent;

import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/17
 *
 * @author 44399
 * <p>
 * [10|A]
 */
public class Tencent1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(depressString(input, 0, input.length() - 1));
    }

    private static String depressString(String compressedString, int start, int end) {
        if (start > end) {
            return null;
        }
        int left = start, right = end;
        StringBuilder sb = new StringBuilder();
        while (left < right && compressedString.charAt(left) != '[') {
            sb.append(compressedString.charAt(left));
            left++;
        }
        while (right > left && compressedString.charAt(right) != ']') {
            right--;
        }
        if (left >= right) {
            return compressedString.substring(start, end + 1);
        }
        int timesEnd = left;
        do {
            ++timesEnd;
        } while (compressedString.charAt(timesEnd) >= '0' && compressedString.charAt(timesEnd) <= '9');
        int times = Integer.parseInt(compressedString.substring(left + 1, timesEnd));
        String next = depressString(compressedString, timesEnd + 1, right - 1);
        for (int i = 0; i < times; i++) {
            sb.append(next);
        }
        if (right <= end) {
            sb.append(compressedString, right + 1, end + 1);
        }
        return sb.toString();
    }
}
