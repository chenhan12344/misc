import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 44399 on 2019/9/8
 * 用1~26编码A~Z
 * 输入编码后的串，求所有解码的可能
 *
 * @author 44399
 */
public class ByteDance6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (String s : decode(input)) {
            System.out.println(s);
        }
    }

    private static char convert(char c) {
        return (char) (c - '1' + 'A');
    }

    private static char convert(String s) {
        return (char) (Integer.parseInt(s) - 1 + 'A');
    }

    private static List<String> decode(String input) {
        List<String> results = new LinkedList<>();
        if (input.isEmpty()) {
            results.add("");
            return results;
        }
        if (input.length() == 1) {
            results.add(input);
            return results;
        }
        char c = input.charAt(0);
        switch (c) {
            case '0': {
                return results;
            }
            case '1': {
                // 开头是1或2那么可以考虑将第一个看成独立的编码
                for (String result : decode(input.substring(1))) {
                    results.add(convert(c) + result);
                }
                for (String result : decode(input.substring(2))) {
                    results.add(convert(input.substring(0, 2)) + result);
                }
                return results;
            }
            case '2': {
                // 开头是1或2那么可以考虑将第一个看成独立的编码
                for (String result : decode(input.substring(1))) {
                    results.add(convert(c) + result);
                }
                if ('0' <= (c = input.charAt(1)) && c <= '6') {
                    for (String result : decode(input.substring(2))) {
                        results.add(convert(input.substring(0, 2)) + result);
                    }
                }
                return results;
            }
            default: {
                // 剩下都是3~9开头，因此第一个字符一定是一个独立的编码
                for (String result : decode(input.substring(1))) {
                    results.add(convert(c) + result);
                }
            }
        }
        return results;
    }
}
