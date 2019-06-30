package offer;

import structure.list.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Sky on 2019/6/26
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 *
 * @author Sky
 */
public class InvertPrintLinkedList {


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode head = listNode;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ArrayList<Integer> result = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public int RectCover(int target) {
        if (target < 3) {
            return target - 1;
        }
        int[] dp = new int[target];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target - 1];
    }

}
