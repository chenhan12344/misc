package leetcode.medium;

import java.util.Arrays;

/**
 * Created by Sky on 2019/7/5
 * --------------------------------------------------
 * 16. 3Sum Closest
 * --------------------------------------------------
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int p = left + 1;
        int minDiff = Integer.MAX_VALUE;
        for (int i = left + 1; i < right; i++) {
            int diff = nums[left] + nums[right] + nums[i] - target;
            if (diff < minDiff) {
                minDiff = diff;
            } else {
                i++;
            }

        }
        return 0;
    }
}
