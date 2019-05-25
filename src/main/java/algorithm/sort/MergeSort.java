package algorithm.sort;

/**
 * Created by Sky on 2019/3/23
 *
 * @author Sky
 */
public class MergeSort implements Sort {
    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int begin, int end) {
        if (end - begin <= 1) {
            return;
        }
        if (nums.length < 2) {
            return;
        }
        int begin1 = begin;
        int end1 = (begin + end) >>> 1;
        int begin2 = end1 + 1;
        int end2 = end;
        sort(nums, begin1, end1);
        sort(nums, begin2, end2);
        merge(nums, begin1, end1, begin2, end2);
    }

    private static void merge(int[] nums, int begin1, int end1, int begin2, int end2) {
        int len1 = end1 - begin1 + 1;
        int len2 = end2 - begin2 + 1;
        int[] result = new int[len1 + len2];
        int index = 0;
        int i = begin1;
        int j = begin2;
        while (i <= end1 && j <= end2) {
            if (nums[i] < nums[j]) {
                result[index++] = nums[i++];
            } else {
                result[index++] = nums[j++];
            }
        }
        while (i <= end1) {
            result[index++] = nums[i++];
        }
        while (j <= end2) {
            result[index++] = nums[j++];
        }
        System.arraycopy(result, 0, nums, begin1, len1 + len2);
    }
}
