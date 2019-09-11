import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/25
 *
 * @author 44399
 */
public class KuaiShou3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] content1 = scanner.nextLine().toCharArray();
        char[] content2 = scanner.nextLine().toCharArray();
        int len1 = content1.length, len2 = content2.length;
        if (len1 == 0 || len2 == 0) {
            System.out.println(new String(len1 < len2 ? content1 : content2));
            return;
        }
        int resultLen = (len1 >>> 1) + 1 + (len2 >>> 1) + 1;
        char[] result = new char[resultLen];
        int index1, index2, i, count;
        for (index1 = 0, index2 = 0, i = 0, count = 1; index1 < len1 && index2 < len2; ) {
            if ((count % 5) == 0) {
                result[i++] = content2[index2];
                index2 += 2;
            } else {
                result[i++] = content1[index1];
                index1 += 2;
            }
            count++;
        }
        while (index1 < len1) {
            result[i++] = content1[index1];
            index1 += 2;
        }
        while (index2 < len2) {
            result[i++] = content2[index2];
            index2 += 2;
        }
//        System.out.println(String.join(result, " "));
    }
}
