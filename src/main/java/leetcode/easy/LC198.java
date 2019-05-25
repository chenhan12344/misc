package leetcode.easy;

/**
 * Created by 44399 on 2019/2/26
 *
 * @author 44399
 */
public class LC198 {

    public static void main(String[] args) {
        System.out.println(new LC198().rob(new int[]{1, 8, 7, 1}));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] money = new int[len];
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            money[i] = Math.max(money[i - 2] + nums[i], money[i - 1]);
        }
        return money[len - 1];
    }
}
