package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sky on 2019/1/5
 *
 * @author Sky
 */
public class LC15 {

    public static void main(String[] args) {
        System.out.println(new LC15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1, k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                    j++;
                }
            }
        }
        return new ArrayList<>(results);
    }

    /**
     * TLE
     *
     * @param nums
     * @return
     */
    @Deprecated
    public List<List<Integer>> threeSum1(int[] nums) {

        Set<List<Integer>> results = new HashSet<>();

        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    List<Integer> numList = Arrays.asList(nums[i], nums[j], nums[k]);
                    Collections.sort(numList);
                    results.add(numList);
                }
            }
        }
        return results
                .stream()
                .filter((list) -> list.get(0) + list.get(1) + list.get(2) == 0)
                .collect(Collectors.toList());
    }
}
