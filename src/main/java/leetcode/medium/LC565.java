package leetcode.medium;

/**
 * Created by 44399 on 2019/2/23
 *
 * @author 44399
 */
public class LC565 {

    public static void main(String[] args) {
        System.out.println(new LC565().arrayNesting2(new int[]{
                1, 0, 3, 4, 2
        }));
    }

    public int arrayNesting(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            visited[i] = false;
        }
        int longest = 0;
        for (int index = 0; index < len && !visited[index]; index++) {
            int length = 0;
            int begin = index;
            while (!visited[begin]) {
                visited[begin] = true;
                length++;
                begin = nums[begin];
            }
            if (length > longest) {
                longest = length;
            }
            for (int i = 0; i < len; i++) {
                visited[i] = false;
            }
        }
        return longest;
    }

    public int arrayNesting2(int[] nums) {
        int maxsize = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = 0;
            for (int k = i; nums[k] >= 0; size++) {
                int ak = nums[k];
                nums[k] = -1; // mark a[k] as visited;
                k = ak;
            }
            maxsize = Integer.max(maxsize, size);
        }

        return maxsize;
    }

}
