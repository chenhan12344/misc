package leetcode.medium;

import structure.list.LinkedListUtils;
import structure.list.ListNode;

/**
 * Created by 44399 on 2019/2/3
 *
 * @author 44399
 */
public class LC24 {

    public static void main(String[] args) {
        LinkedListUtils.printLinkedList(new LC24().swapPairs(
                LinkedListUtils.createLinkedList(1, 2, 3)
        ));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        for (ListNode p1 = head, prev = newHead; p1 != null && p1.next != null; p1 = p1.next) {
            ListNode p2 = p1.next;
            prev.next = p2;
            p1.next = p2.next;
            p2.next = p1;
            prev = p1;
        }
        return newHead.next;
    }
}
