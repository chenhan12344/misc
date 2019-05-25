package algorithm.sort;

/**
 * Created by Sky on 2019/3/23
 *
 * @author Sky
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        sort(nums, 0, nums.length - 1);

    }

    private void sort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int i = begin;
        int j = end;
        int key = nums[begin];
        while (i < j) {
            while (nums[j] >= key && j > i) {
                j--;
            }
            if (i == j) {
                break;
            }
            swap(nums, i, j);
            while (nums[i] <= key && i < j) {
                i++;
            }
            if (i == j) {
                break;
            }
            swap(nums, i, j);
        }
        sort(nums, begin, i);
        sort(nums, j + 1, end);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
