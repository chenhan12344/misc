package leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sky on 2019/7/10
 * --------------------------------------------------
 * 39. Combination Sum88
 * --------------------------------------------------
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * --------------------------------------------------
 * Example:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [[7], [2, 2, 3]]
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC39 {

    public static void main(String[] args) {
        System.out.println(new LC39().combinationSum(
                new int[]{2, 3, 6, 7}, 7
        ));
    }

    private List<List<Integer>> results;
    private Deque<Integer> tmp;


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            return;
        }
        for (int i = idx, len = candidates.length; i < len; i++) {
            tmp.push(candidates[i]);
            helper(candidates, target - candidates[i], i);
            tmp.pop();
        }
    }
}
