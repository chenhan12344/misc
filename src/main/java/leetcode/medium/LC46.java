package leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sky on 2019/1/9
 *
 * @author Sky
 */
public class LC46 {

    public static void main(String[] args) {
        System.out.println(new LC46().permute(new int[]{1, 2, 3, 5, 8}));
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            return Collections.singletonList(Collections.singletonList(nums[0]));
        } else {
            List<List<Integer>> results = new LinkedList<>();
            List<List<Integer>> prevResults = permute(Arrays.copyOf(nums, nums.length - 1));
            for (List<Integer> list : prevResults) {
                int num = nums[nums.length - 1];
                int len = list.size();
                for (int i = 0; i <= len; i++) {
                    List<Integer> result = new LinkedList<>(list);
                    result.add(i, num);
                    results.add(result);
                }
            }
            return results;
        }
    }

}
