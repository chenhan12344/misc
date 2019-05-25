package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sky on 2019/1/22
 *
 * @author Sky
 */
public class LC78 {

    public static void main(String[] args) {
        System.out.println(new LC78().subsets2(new int[]{1, 2, 3, 4}));
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if (nums.length == 1) {
            List<Integer> finalList = new LinkedList<>();
            finalList.add(nums[0]);
            results.add(finalList);
            results.add(new LinkedList<>());
            return results;
        }
        int cur = nums[0];
        int[] remains = new int[nums.length - 1];
        System.arraycopy(nums, 1, remains, 0, remains.length);
        for (List<Integer> list : subsets(remains)) {
            results.add(list);
            List<Integer> newList = new LinkedList<>(list);
            list.add(0, cur);
            results.add(newList);
        }
        return results;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        results.add(new LinkedList<>());
        for (int num : nums) {
            List<List<Integer>> prevResult = new LinkedList<>();
            for (List<Integer> list : results) {
                prevResult.add(new LinkedList<>(list));
            }
            for (List<Integer> list : prevResult) {
                list.add(num);
            }
            results.addAll(prevResult);
        }
        return results;
    }


}
