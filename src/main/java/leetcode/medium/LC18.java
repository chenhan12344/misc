package leetcode.medium;

import java.util.*;

/**
 * Created by Sky on 2019/1/5
 *
 * @author Sky
 */
public class LC18 {

    public static void main(String[] args) {
        System.out.println(new LC18().fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, target, 4, 0, nums.length - 1);
    }

    private List<List<Integer>> nSum(int[] nums, int target, int n, int start, int end) {
        Set<List<Integer>> results = new HashSet<>(1);
        if (end - start + 1 < n) {
            return new ArrayList<>(results);
        }
        if (end - start + 1 == n) {
            int sum = 0;
            List<Integer> numList = new ArrayList<>(nums.length);
            for (int i = start; i <= end; i++) {
                sum += nums[i];
                numList.add(nums[i]);
            }
            if (sum == target) {
                results.add(numList);
            }
            return new ArrayList<>(results);
        }
        if (n == 2) {
            int left = start, right = end, sum;
            while (left < right) {
                sum = nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    List<Integer> result = new ArrayList<>(n);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);
                    left++;
                    right--;
                }
            }
            return new ArrayList<>(results);
        }
        for (int i = start; i < nums.length - (n - 1); i++) {
            List<List<Integer>> nextResults = nSum(nums, target - nums[i], n - 1, i + 1, end);
            for (List<Integer> result : nextResults) {
                result.add(nums[i]);
                results.add(result);
            }
        }
        return new ArrayList<>(results);
    }

}