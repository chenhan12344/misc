package leetcode.medium;

/**
 * Created by 44399 on 2019/2/1
 *
 * @author 44399
 */
public class LC34 {

    public static void main(String[] args) {
        int[] region = new LC34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10);
        System.out.println(String.format("[%d, %d]", region[0], region[1]));
    }

    /**
     * limitation: time complexity in order of O(log n)
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }
        int position = search(nums, target, 0, nums.length - 1);
        if (position == -1) {
            return result;
        }
        result[0] = position;
        result[1] = position;
        for (int i = position - 1; i >= 0; i--) {
            if (nums[i] == target) {
                result[0] = i;
            } else {
                break;
            }
        }
        for (int i = position + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                result[1] = i;
            } else {
                break;
            }
        }
        return result;
    }

    private int search(int[] nums, int target, int start, int end) {
        while (true) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (start == end) {
                return -1;
            }
            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
    }
}
