package algorithm.sort;

/**
 * Created by Sky on 2019/3/23
 *
 * @author Sky
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    if (i - j >= 0) {
                        System.arraycopy(nums, j, nums, j + 1, i - j);
                    }
                    nums[j] = temp;
                }
            }
        }
    }
}
