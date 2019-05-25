package leetcode.medium;

import structure.list.LinkedListUtils;
import structure.list.ListNode;

/**
 * Created by Sky on 2019/1/22
 *
 * @author Sky
 */
public class LC92 {

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.createLinkedList(new int[]{1, 2, 3, 4});
        LinkedListUtils.printLinkedList(new LC92().reverseBetween(head, 1, 3));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode cursor = head;
        for (int i = 0; i < m - 1; i++) {
            cursor = cursor.next;
        }
        ListNode nodeMPrev = cursor,
                nodeM = cursor.next,
                prev = nodeM;
        cursor = cursor.next.next;
        ListNode next = cursor.next;
        for (int i = 0; i < m - n; i++) {
            assert cursor != null;
            cursor.next = prev;
            prev = cursor;
            cursor = next;
            if (next != null) {
                next = next.next;
            }
        }
        nodeMPrev.next = prev;
        nodeM.next = cursor;
        return head;
    }

}
