package algorithm.sort;

import java.util.Arrays;

/**
 * Created by Sky on 2019/3/23
 *
 * @author Sky
 */
public class RadixSort implements Sort {

    @Override
    public void sort(int[] nums) {
        sort(nums, 1);
    }

    public void sort(int[] nums, int radix) {
        int[] bucket0 = Arrays.stream(nums).filter((num) -> (num & radix) == 0).toArray();
        int[] bucket1 = Arrays.stream(nums).filter((num) -> (num & radix) == 1).toArray();
        if (bucket0.length == 0 && bucket1.length == 0) {
            return;
        }
        System.arraycopy(bucket0, 0, nums, 0, bucket0.length);
        System.arraycopy(bucket1, 0, nums, bucket0.length, bucket1.length);
        sort(nums, radix << 1);
    }

}
