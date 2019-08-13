import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/11
 *
 * @author 44399
 */
public class Netese2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();          //T
        for (int i = 0; i < n; i++) {
            int maxVolume = scanner.nextInt();          //m  水池最大容量
            int totalTime = scanner.nextInt();          //t  总时间
            int incoming = scanner.nextInt();           //m1 进水速度
            int incomingInterval = scanner.nextInt();   //t1 进水间隔
            int outgoing = scanner.nextInt();           //m2 排水速度
            int outgoingInterval = scanner.nextInt();   //t2 排水间隔
            System.out.println(getPoolWater(maxVolume, totalTime,
                    incoming, incomingInterval,
                    outgoing, outgoingInterval));
        }
    }

    private static int getPoolWater(int maxVolume, int totalTime,
                                    int incomingSpeed, int incomingInterval,
                                    int outgoingSpeed, int outgoingInterval) {
        int cycleTime = getLCM(2 * incomingInterval, 2 * outgoingInterval);     // 一个周期的时间
        int cycleVolume = 0;        // 一个周期剩余的水量
        int t = cycleTime, i = 0, o = 0, is = incomingSpeed, os = outgoingSpeed;
        while (t > 0) {
            cycleVolume = Math.max(0, Math.min(maxVolume, cycleVolume + is - os));
            ++i;
            ++o;
            if (i % incomingInterval == 0) {
                is = is > 0 ? 0 : incomingSpeed;
            }
            if (o % outgoingInterval == 0) {
                os = os > 0 ? 0 : outgoingSpeed;
            }
            --t;
        }
        int baseVolume = Math.min(maxVolume, cycleVolume * (totalTime / cycleTime));
        int remainingTime = totalTime % cycleTime;
        i = 0;
        o = 0;
        is = incomingSpeed;
        os = outgoingSpeed;
        while (remainingTime > 0) {
            baseVolume = Math.max(0, Math.min(maxVolume, baseVolume + is - os));
            ++i;
            ++o;
            if (i % incomingInterval == 0) {
                is = is > 0 ? 0 : incomingSpeed;
            }
            if (o % outgoingInterval == 0) {
                os = os > 0 ? 0 : outgoingSpeed;
            }
            --remainingTime;
        }
        return Math.max(0, Math.min(maxVolume, baseVolume));
    }

    /**
     * 求最小公倍数
     */
    private static int getLCM(int a, int b) {
        int p = a * b, r;
        do {
            r = a % b;
            a = b;
            b = r;
        } while (r != 0);
        return p / a;
    }
}
