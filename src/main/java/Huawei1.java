import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/21
 *
 * @author 44399
 */
public class Huawei1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt(16);
        int[] processedBytes = new int[255];
        int index = 1, newLength = length;
        for (int i = 1; i < length; i++) {
            int b = scanner.nextInt(16);
            if (b == 0x0A) {
                processedBytes[index++] = 0x12;
                processedBytes[index++] = 0x34;
                newLength++;
                continue;
            }
            if (b == 0x0B) {
                processedBytes[index++] = 0xAB;
                processedBytes[index++] = 0xCD;
                newLength++;
                continue;
            }
            processedBytes[index++] = b;
        }
        processedBytes[0] = newLength;
        for (int i = 0; i < newLength - 1; i++) {
            System.out.print(Integer.toHexString(processedBytes[i]).toUpperCase() + " ");
        }
        System.out.print(Integer.toHexString(processedBytes[newLength - 1]).toUpperCase());
    }
}
