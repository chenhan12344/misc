package leetcode.medium;

/**
 * Created by Sky on 2019/6/26
 *
 * @author Sky
 */
public class LC215 {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new LC215().findKthLargest(nums, 1));
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    /**
     * 基于快排的思想，进行快速选择
     *
     * @param nums
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int findKthLargest(int[] nums, int k, int start, int end) {
        /*
         * 对于一个第k大的数，则有k-1个数大于其
         * 进行一趟快排后，以轴作为中心，可以划分为下面两个区域
         * 其中轴之前共有start-i个比轴小的数，轴之后有end-i个比轴大的数
         *
         *                           pivot
         *                             ↓
         * -----------------------------------------------------------
         * |       start - i          |i|         end - i            |
         * -----------------------------------------------------------
         *
         * i)  若此时轴之后的数恰好有k-1个，说明轴即为要找的数
         * ii) 若此时轴之后的数的个数比k-1大，说明前k个最大的数在区间(i + 1, end)中
         * iii)若此时轴之后的数的个数比k-1小，那么需要在区间(start, i - 1)中
         * 去寻找第(k - (end - i + 1))大的数。因为在区间(i, end)中共有
         * (end - i + 1)个数比k都大。
         */
        int i = start, j = end, pivot = nums[start], tmp;
        /* 执行一趟快排 */
        while (i < j) {
            while (j > i && nums[j] >= pivot) {
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
        /* 若此时轴之后的数恰好有k-1个，说明轴即为要找的数 */
        if (end - i == k - 1) {
            return pivot;
        }
        if (end - i > k - 1) {
            /* 若此时轴之后的数的个数比k-1大，说明前k个最大的数在区间(i + 1, end)中 */
            return findKthLargest(nums, k, i + 1, end);
        } else {
            /* 若此时轴之后的数的个数比k-1小，那么需要在区间(start, i - 1)中 */
            return findKthLargest(nums, k - (end - i + 1), start, i - 1);
        }
    }

}
