package leetcode.medium;

/**
 * Created by 44399 on 2019/6/22
 *
 * @author 44399
 */
public class LC220 {

    public static void main(String[] args) {
        System.out.println(new LC220().containsNearbyAlmostDuplicate(new int[]{
                10, 15, 19, 24
        }, 3, 3));
    }

    /**
     * @param nums
     * @param k    窗口宽度
     * @param t    最大差值
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k > nums.length) k = nums.length - 1;
        for (int i = 1; i <= nums.length; i++)
            for (int j = i; j < Math.min(i + k, nums.length); j++)
                if (Math.abs((long) nums[i - 1] - nums[j]) <= t) return true;
        return false;
    }
}