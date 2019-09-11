import java.util.Scanner;

/**
 * Created by 44399 on 2019/8/29
 *
 * @author 44399
 */
public class SF2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] dp = new int[n];
        int max = 0;
        int res = 0;
        for (int num : arr) {
            int i = binarySearch(dp, 0, res, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == res) {
                res++;
            }
        }
        System.out.println(res);
    }

    private static int binarySearch(int[] nums, int begin, int end, int target) {
        int mid;
        while (begin < end) {
            mid = (begin + end) / 2;
            if (nums[mid] == target) {
                while (mid <= end && nums[mid] == target) {
                    mid++;
                }
                return mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -(begin + 1);
    }
}
