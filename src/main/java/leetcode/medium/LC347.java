package leetcode.medium;

import java.util.List;

/**
 * Created by Sky on 2019/7/9
 * --------------------------------------------------
 * 347. Top K Frequent Elements
 * --------------------------------------------------
 * Given a non-empty array of integers, return the k most frequent elements
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        FrequentNode root = new FrequentNode(nums[0]);
        for (int num : nums) {

        }
        return null;
    }
}

class FrequentNode {

    int val;
    int freq;
    FrequentNode left;
    FrequentNode right;

    public FrequentNode(int val) {
        this.val = val;
    }
}
