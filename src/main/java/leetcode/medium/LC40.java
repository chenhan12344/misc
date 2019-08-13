package leetcode.medium;

import java.util.*;

/**
 * Created by Sky on 2019/7/10
 * --------------------------------------------------
 * 40. Combination Sum II
 * --------------------------------------------------
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 * --------------------------------------------------
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [[1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]]
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC40 {

    public static void main(String[] args) {
        System.out.println(new LC40().combinationSum2(
                new int[]{2, 5, 2, 1, 2}, 5
        ));
    }

    private List<List<Integer>> results;
    private Deque<Integer> tmp;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        results = new LinkedList<>();
        tmp = new LinkedList<>();
        helper(candidates, target, 0);
        return results;
    }

    private void helper(int[] candidates, int target, int idx) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            results.add(new ArrayList<>(tmp));
        }
        for (int i = idx, len = candidates.length; i < len; i++) {
            if (i > idx && candidates[i - 1] == candidates[i]) {
                continue;
            }
            tmp.push(candidates[i]);
            helper(candidates, target - candidates[i], i + 1);
            tmp.pop();
        }
    }
}
