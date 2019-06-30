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

    private static void sort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int i = begin, j = end, mid = (i + j) / 2, pivot = nums[mid], tmp;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        sort(nums, begin, mid - 1);
        sort(nums, mid + 1, end);
    }


    private static void sort2(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int i = begin, j = end, pivot = nums[begin], tmp;
        while (i < j) {
            while (j > i && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        sort2(nums, begin, i - 1);
        sort2(nums, j + 1, end);
    }
}
