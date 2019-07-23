package leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sky on 2019/7/2
 *
 * @author Sky
 */
public class LC1104 {

    public static void main(String[] args) {
        System.out.println(new LC1104().pathInZigZagTree(16));
    }

    public List<Integer> pathInZigZagTree(int label) {
        if (label < 1) {
            return new LinkedList<>();
        }
        int depth = (int) Math.ceil(Math.log(label + 1) / Math.log(2));
        Deque<Integer> result = new LinkedList<>();
        while (label > 0) {
            result.addFirst(label);
            depth--;
            label = (int) (Math.pow(2, depth - 1) + Math.pow(2, depth) - 1 - label / 2);
        }
        return (List<Integer>) result;
    }
}
