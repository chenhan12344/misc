import java.util.Scanner;

/**
 * Created by 44399 on 2019/9/1
 *
 * @author 44399
 */
public class Tencent2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer[] customers = new Customer[scanner.nextInt()];
        for (int i = 0, len = customers.length; i < len; i++) {
            customers[i] = new Customer(scanner.nextInt(), scanner.nextInt());
        }

    }
}

class Customer {

    int a;
    int b;

    public Customer(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int dissatisfactory(int i, int queueLen) {
        return a * (i - 1) + b * (queueLen - i);
    }
}