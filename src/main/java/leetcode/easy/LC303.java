package leetcode.easy;

/**
 * Created by 44399 on 2019/2/26
 *
 * @author 44399
 */
public class LC303 {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(numArray.sumRange(0, 1));
    }

    static class NumArray {

        private int[] cache;

        public NumArray(int[] nums) {
            this.cache = new int[nums.length + 1];
            this.cache[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                this.cache[i + 1] = cache[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return cache[j + 1] - cache[i];
        }
    }
}
