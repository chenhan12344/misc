package algorithm.sort;

/**
 * Created by Sky on 2019/3/23
 *
 * @author Sky
 */
public class ShellSort implements Sort {

    @Override
    public void sort(int[] nums) {
        sort(nums, nums.length >>> 1);
    }

    private void sort(int[] nums, int distance) {
        if (distance == 0) {
            return;
        }
        for (int i = 0; i < distance; i++) {
            for (int j = distance + i; j < nums.length; j += distance) {
                for (int k = i; k < j; k += distance) {
                    if (nums[j] < nums[k]) {
                        int temp = nums[j];
                        for (int l = j; l > k; l -= distance) {
                            nums[l] = nums[l - distance];
                        }
                        nums[k] = temp;
                    }
                }
            }
        }
        sort(nums, distance >>> 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
