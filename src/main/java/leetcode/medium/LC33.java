package leetcode.medium;

/**
 * Created by Sky on 2019/1/22
 *
 * @author Sky
 */
public class LC33 {

    public static void main(String[] args) {
        System.out.println(new LC33().search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
    }

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int begin, int end, int target) {
        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (mid == begin && mid == end) {
            return -1;
        }
        if (target > nums[mid]) {
            if (nums[begin] > nums[end]) {
                return search(nums, mid + 1, end, target);
            } else {
                return search(nums, begin, mid, target);
            }
        } else {
            if (nums[begin] > nums[end]) {
                return search(nums, mid + 1, end, target);
            } else {
                return search(nums, begin, mid, target);
            }
        }
    }
}
