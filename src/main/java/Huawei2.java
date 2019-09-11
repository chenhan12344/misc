import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/21
 *
 * @author 44399
 */
public class Huawei2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = scanner.nextInt();
        int high = scanner.nextInt();
        int[] primes = new int[high - low];
        int index = 0;
        for (int num = low; num < high; num++) {
            if (isPrime(num)) {
                primes[index++] = num;
            }
        }
        int sumOfOnes = 0, sumOfTens = 0;
        for (int i = 0; i < index; i++) {
            sumOfOnes += primes[i] % 10;
            sumOfTens += (primes[i] % 100) / 10;
        }
        System.out.println(Math.min(sumOfOnes, sumOfTens));
    }

    private static boolean isPrime(int num) {
        if (num < 6) {
            return num != 4;
        }
        int mod = num % 6;
        if (mod != 1 && mod != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
