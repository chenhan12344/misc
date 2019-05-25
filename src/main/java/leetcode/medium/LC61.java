package leetcode.medium;

import structure.list.ListNode;

/**
 * Created by Sky on 2019/1/21
 *
 * @author Sky
 */
public class LC61 {

    public ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            count++;
        }
        k %= count;
        ListNode cur1 = head, cur2 = head;
        int dist = 0;
        while (cur1.next != null) {
            cur1 = cur1.next;
            dist++;
            if (dist > k) {
                cur2 = cur2.next;
            }
        }
        cur1.next = head;
        ListNode newHead = cur2.next;
        cur2.next = null;
        return newHead;
    }


}
