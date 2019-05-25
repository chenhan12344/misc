package leetcode.hard;

/**
 * 两个有序数组寻找中位数·
 * Created by Sky on 2019/3/31
 *
 * @author Sky
 */
public class LC4 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 9};
        int[] nums2 = new int[]{5, 6, 7, 8, 10};
        System.out.println(new LC4().findMedianSortedArrays1(nums1, nums2));
        System.out.println(new LC4().findMedianSortedArrays(nums1, nums2));
    }

    private double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len2 = nums2.length;
        int len1 = nums1.length;
        int totalNums = nums1.length + nums2.length;
        if (totalNums == 0) {
            return 0.0;
        }
        if (len1 < len2) {
            int[] tmp = nums1;
            nums1 = nums2;
            len1 = nums1.length;
            nums2 = tmp;
            len2 = nums2.length;
        }
        if (len2 == 0) {
            return (nums1[len1 / 2] + nums1[(len1 - 1) / 2]) / 2.0;
        }

        if (nums1[len1 - 1] < nums2[0]) {
            if (len1 == len2) {
                return (nums1[len1 - 1] + nums2[0]) / 2.0;
            }
            return (nums1[totalNums / 2] + nums1[(totalNums - 1) / 2]) / 2.0;
        } else if (nums2[len2 - 1] < nums1[0]) {
            if (len1 == len2) {
                return (nums1[len1 - 1] + nums2[0]) / 2.0;
            }
            return (nums1[(totalNums >> 1) - len2] + nums1[((totalNums - 1) >> 1) - len2]) / 2.0;
        }


        int index1 = 0;
        int index2 = 0;
        while (index1 + index2 + 1 != (totalNums >> 1)) {
            System.out.println(String.format("index1:%d, index2:%d", index1, index2));
            if (index1 + index2 + 1 < (totalNums) >> 1) {
                if (nums1[index1] < nums2[index1]) {
                    index1 = (index1 + nums1.length) >> 1;
                } else {
                    index2 = (index2 + nums2.length) >> 1;
                }
            } else {
                if (nums1[index1] < nums2[index1]) {
                    index2 >>= 1;
                } else {
                    index1 >>= 1;
                }
            }
        }
        System.out.println(String.format("index1:%d, index2:%d", index1, index2));
        if (totalNums % 2 == 1) {
            return nums1[index1] > nums2[index2] ? nums1[index1] : nums2[index2];
        } else {
            return (nums1[index1] + nums2[index2]) / 2.0;
        }
    }


    /**
     * 时间复杂度O(m+n)
     */
    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalNums = nums1.length + nums2.length;
        int mediumIndex = totalNums >> 1;
        int i = 0;
        int j = 0;
        int index = 0;
        if (totalNums % 2 == 1) {
            double med = 0;
            while (index <= mediumIndex && i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    med = nums1[i++];
                } else {
                    med = nums2[j++];
                }
                index++;
            }
            if (index > mediumIndex) {
                return med;
            } else {
                while (index <= mediumIndex && i < nums1.length) {
                    med = nums1[i++];
                    index++;
                }

                while (index <= mediumIndex && j < nums2.length) {
                    med = nums2[j++];
                    index++;
                }
                return med;
            }
        } else {
            double med1 = 0, med2 = 0;
            while (index <= mediumIndex && i < nums1.length && j < nums2.length) {
                med2 = med1;
                if (nums1[i] < nums2[j]) {
                    med1 = nums1[i++];
                } else {
                    med1 = nums2[j++];
                }
                index++;
            }
            if (index > mediumIndex + 1) {
                return (med1 + med2) / 2;
            } else {
                while (index <= mediumIndex && i < nums1.length) {
                    med2 = med1;
                    med1 = nums1[i++];
                    index++;
                }

                while (index <= mediumIndex && j < nums2.length) {
                    med2 = med1;
                    med1 = nums2[j++];
                    index++;
                }
                return (med1 + med2) / 2;
            }
        }
    }
}
