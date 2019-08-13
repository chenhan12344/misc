package leetcode.easy;

import java.util.Arrays;

/**
 * Created by Sky on 2019/7/2
 * --------------------------------------------------
 * 88. Merge Sorted Array
 * --------------------------------------------------
 * Given two sorted integer arrays nums1 and nums2
 * merge nums2 into nums1 as one sorted array.
 * --------------------------------------------------
 * Example:
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 * --------------------------------------------------
 *
 * @author Sky
 */
public class LC88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 5, 6, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3};
        new LC88().merge(
                nums1, 3, nums2, 3
        );
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 直接遍历num2然后插入到num1简单可行
     * 但是这样做每次插入都需要移动多个元素
     * 由于num1和num2都是排好序的
     * 设想一下如果num2中的所有元素都比num1大
     * 那么直接将num2放置到num1尾部即可
     * 基于此对直接插入进行改进
     *
     * @param nums1 数组1
     * @param m     数组1元素的个数
     * @param nums2 数组2
     * @param n     数组2元素的个数
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        /*
         *         left     right
         *           ↓        ↓
         * [1, 2, 3, 8, _, _, _]
         * [4, 6, 7]
         *        ↑
         *       idx
         * -----------------------
         *         left     right
         *           ↓        ↓
         * [1, 2, 3, 8, _, _, 8]
         * [4, 6, 7]
         *        ↑
         *       idx
         * -----------------------
         *         left  right
         *           ↓     ↓
         * [1, 2, 3, 7, _, _, 8]
         * [4, 6, 7]
         *     ↑
         *    idx
         */

        int left = m - 1, right = m + n - 1;
        int idx = n - 1;
        while (idx >= 0) {
            if (nums1[left] <= nums2[idx]) {
                nums1[right--] = nums2[idx];
            } else {
                while (left >= 0 && nums1[left] > nums2[idx]) {
                    nums1[right--] = nums1[left--];
                }
                if (left < 0) {
                    System.arraycopy(nums2, 0, nums1, 0, idx + 1);
                    return;
                }
                nums1[right--] = nums2[idx];
            }
            idx--;
        }
    }
}
