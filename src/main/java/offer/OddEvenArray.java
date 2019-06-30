package offer;

import java.util.Arrays;

/**
 * Created by Sky on 2019/6/27
 * 实现一个函数来调整该数组中数字的顺序：
 * 1) 使得所有的奇数位于数组的前部，所有的偶数位于数组的后部
 * 2) 保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author Sky
 */
public class OddEvenArray {

    public static void main(String[] args) {
        int[] array = new int[]{};
        new OddEvenArray().reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * @param array
     */
    public void reOrderArray(int[] array) {
        int len = array.length;
        int[] evens = new int[len];
        int i = 0, k = 0;
        /* 初始化i到第一个偶数所在的位置 */
        while (i < len && (array[i] & 1) == 1) {
            i++;
        }
        for (int j = i; j < len; j++) {
            if ((array[j] & 1) == 1) {
                /* 从i开始，若遇到偶数，则添加到偶数数组中 */
                array[i] = array[j];
                i++;
            } else {
                /* 若遇到奇数则，与第i位置的数交换 */
                evens[k] = array[j];
                k++;
            }
        }
        System.arraycopy(evens, 0, array, i, k);
    }
}
