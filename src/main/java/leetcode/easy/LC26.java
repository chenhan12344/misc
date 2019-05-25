package leetcode.easy;

/**
 * Created by 44399 on 2019/2/3
 *
 * @author 44399
 */
public class LC26 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(new LC26().removeDuplicates(nums));
    }

    /**
     * space complexity must in order of O(1)
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int cur = 1; cur < nums.length; cur++) {
            if (nums[cur] != nums[index]) {
                nums[++index] = nums[cur];
            }
        }
        return index;
    }
}
