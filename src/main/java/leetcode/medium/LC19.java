package leetcode.medium;

import structure.list.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sky on 2019/1/9
 *
 * @author Sky
 */
public class LC19 {

    public static void main(String[] args) {
        ListNode head = new ListNode();
        printListNode(head);
        printListNode(new LC19().removeNthFromEnd2(head, 1));
    }

    private static void printListNode(ListNode head) {
        List<String> vals = new LinkedList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            vals.add(String.valueOf(cur.val));
        }
        if (vals.isEmpty()) {
            System.out.println("null");
        } else {
            System.out.println(String.join(" -> ", vals));
        }
    }

    /**
     * One pass algorithm
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode header = new ListNode();
        header.next = head;
        ListNode cursor1 = header,
                cursor2 = header;
        int gap = 0;
        while (cursor1 != null) {
            cursor1 = cursor1.next;
            gap++;
            if (gap > n + 1) {
                cursor2 = cursor2.next;
            }
        }
        cursor2.next = cursor2.next.next;
        return header.next;
    }


    /**
     * Two pass algorithm
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int count = 0;
        for (ListNode cur = head; cur.next != null; cur = cur.next) {
            count++;
        }
        ListNode headder = new ListNode(),
                prev = headder,
                cur = head;
        prev.next = head;
        int index = 0;
        while (index < count - n + 1) {
            prev = cur;
            cur = cur.next;
            index++;
        }
        if (cur == null) {
            prev.next = null;
        } else {
            prev.next = cur.next;
        }
        return headder.next;
    }

}
