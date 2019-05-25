package algorithm.sort;

/**
 * Created by Sky on 2019/3/23
 *
 * @author Sky
 */
public class HeapSort implements Sort {

    @Override
    public void sort(int[] nums) {
        sort(nums, nums.length);
    }

    private void sort(int[] nums, int length) {
        if (length < 2) {
            return;
        }
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] > nums[(i - 1) >> 1]) {
                swap(nums, i, (i - 1) >> 1);
            }
        }
        swap(nums, 0, length - 1);
        sort(nums, length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
