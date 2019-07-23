package leetcode.medium;

import structure.list.ListNode;

/**
 * Created by Sky on 2019/7/2
 *
 * @author Sky
 */
public class LC21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        /* 保证每次i都从较小的一个链表开始 */
        if (l1.val > l2.val) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        ListNode i = l1, j = l2;
        ListNode iNext = i.next, tmp;
        while (i.next != null && j != null) {
            /* 若节点j的值介于节点i的值和iNext的值之间，则将节点j插入到节点i和iNext之间 */
            if (i.val <= j.val && j.val <= iNext.val) {
                tmp = j.next;
                i.next = j;
                j.next = iNext;
                j = tmp;
                i = i.next;
            } else {
                i = i.next;
                iNext = i.next;
            }
        }
        /* 此时list1已经遍历完成，如果list2末尾还有多余的节点，则将其直接链接到list1的尾部 */
        if (j != null) {
            i.next = j;
        }
        return l1;
    }
}
