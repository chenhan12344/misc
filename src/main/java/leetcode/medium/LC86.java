package leetcode.medium;

import structure.list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sky on 2019/1/6
 *
 * @author Sky
 */
public class LC86 {

    public static void main(String[] args) {
    }

    public ListNode partition(ListNode head, int x) {
        ListNode cur1 = head;
        head = new ListNode();
        head.next = cur1;
        ListNode prev1 = head;
        while (cur1 != null) {
            if (cur1.val >= x) {
                break;
            }
            prev1 = cur1;
            cur1 = cur1.next;
        }
        if (cur1 == null || cur1.next == null) {
            return head.next;
        }
        for (ListNode cur2 = cur1.next, prev2 = cur1; cur2 != null; ) {
            if (cur2.val < x) {
                prev1.next = cur2;
                prev1 = prev1.next;
                prev2.next = cur2.next;
                cur2.next = cur1;
                cur2 = prev2.next;
                if (cur2 == null) {
                    break;
                }
            } else {
                prev2 = cur2;
                cur2 = cur2.next;
            }
        }
        return head.next;
    }

    private static void printListNode(ListNode head) {
        List<String> nums = new ArrayList<>();
        while (head != null) {
            nums.add(String.valueOf(head.val));
            head = head.next;
        }
        System.out.println(String.join(" -> ", nums));
    }
}
