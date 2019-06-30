package offer;

import structure.list.LinkedListUtils;
import structure.list.ListNode;

/**
 * Created by Sky on 2019/6/27
 * 输入两个单调递增的链表，输出两个链表合成后的链表
 * 要求合成后的链表满足单调不减规则
 *
 * @author Sky
 */
public class MergeList {

    public static void main(String[] args) {
        ListNode head1 = LinkedListUtils.createLinkedList(1);
        ListNode head2 = LinkedListUtils.createLinkedList(1);
        head1 = new MergeList().Merge(head1, head2);
        LinkedListUtils.printLinkedList(head1);
    }


    /**
     * 合并具体思想是，两个链表list1和list2同时开始遍历
     * 在list1中寻找合适的位置将list2中的节点逐一插入
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode i = list1, j = list2;
        /* 保证每次i都从较小的一个链表开始 */
        if (list1.val > list2.val) {
            i = list2;
            j = list1;
        }
        ListNode iNext = i.next, tmp;
        while (i.next != null && j != null) {
            /* 若节点j的值介于节点i的值和iNext的值之间，则将节点j插入到节点i和iNext之间 */
            if (i.val <= j.val && j.val < iNext.val) {
                tmp = j.next;
                i.next = j;
                j.next = iNext;
                j = tmp;
                i = i.next;
                continue;
            }
            if (i.val > j.val) {
                j = j.next;
            } else {
                i = i.next;
                iNext = i.next;
            }
        }
        /* 此时list1已经遍历完成，如果list2末尾还有多余的节点，则将其直接链接到list1的尾部 */
        i.next = j;
        return list1.val > list2.val ? list2 : list1;
    }

}
