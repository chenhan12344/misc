package offer;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Sky on 2019/8/6
 *
 * @author Sky
 */
public class IsPopOrder {

    public static void main(String[] args) {
        int[] pushOrder = new int[]{1, 2, 3};
        int[] popOrder = new int[]{3, 1, 2};
        System.out.println(new IsPopOrder().validateStackSequences(pushOrder, popOrder));
    }

    public boolean validateStackSequences(int[] pushed, int[] poped) {
        if (pushed == null) {
            return true;
        }
        int len = pushed.length;
        if (len < 3) {
            return true;
        }
        Map<Integer, Integer> indexMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            indexMap.put(pushed[i], i);
        }
        outer:
        for (int i = 1; i < len - 1; i++) {
            int j = i;
            do {
                j++;
                if (j == len) {
                    continue outer;
                }
            } while (indexMap.get(poped[j]) < indexMap.get(poped[i]));
            for (int index = 0; index < i; index++) {
                if (indexMap.get(poped[index]) > indexMap.get(poped[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validateStackSequences2(int[] pushed, int[] poped) {
        Deque<Integer> stack = new LinkedList<>();
        return false;
    }

}
