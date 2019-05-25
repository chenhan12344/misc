package leetcode.medium;

import java.util.Arrays;

/**
 * Created by Sky on 2019/1/21
 *
 * @author Sky
 */
public class LC41 {

    public static void main(String[] args) {
        System.out.println(new LC41().firstMissingPositive(new int[]{0, 2, 2, 1, 1}));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        int index = 0;
        for (; index < nums.length; index++) {
            if (nums[index] >= 0) {
                break;
            }
        }
        if (nums[index] > 1) {
            return 1;
        }
        while (index < nums.length - 1) {
            if (nums[index] + 1 != nums[index + 1] && nums[index] != nums[index + 1]) {
                return nums[index] + 1;
            } else {
                index++;
            }
        }
        return nums[index] + 1;
    }

}
