package offer;

import structure.list.ListNode;

/**
 * Created by 44399 on 2019/9/8
 *
 * @author 44399
 */
public class FirstCommonNode {

    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        int len1 = 0, len2 = 0;
        for (ListNode node = head1; node != null; node = node.next) {
            len1++;
        }

        for (ListNode node = head2; node != null; node = node.next) {
            len2++;
        }
        if (len2 > len1) {
            ListNode tmp = head1;
            head1 = head2;
            head2 = tmp;
        }
        int lenDiff = Math.abs(len1 - len2);
        ListNode p1 = head1, p2 = head2;
        for (int i = 0; i < lenDiff; i++) {
            p1 = p1.next;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}
