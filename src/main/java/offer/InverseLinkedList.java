package offer;

import structure.list.LinkedListUtils;
import structure.list.ListNode;

/**
 * Created by Sky on 2019/6/27
 * 输入一个链表，反转链表后，输出新链表的表头
 *
 * @author Sky
 */
public class InverseLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.createLinkedList();
        head = new InverseLinkedList().ReverseList(head);
        LinkedListUtils.printLinkedList(head);
    }

    /**
     * 就地反转链表
     *
     * @param head 链表头结点
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head, cur = prev.next, tmp;
        /* 原始链表头节点将成为反转后的尾节点，因此需要将其下一个元素置为空 */
        prev.next = null;
        while (cur.next != null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        /* 反转后由于最后一个节点处于游离状态，需要作为反转后的头结点链回到链表中 */
        cur.next = prev;
        return cur;
    }
}
