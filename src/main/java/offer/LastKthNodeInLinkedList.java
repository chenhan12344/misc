package offer;

import structure.list.LinkedListUtils;
import structure.list.ListNode;

/**
 * Created by Sky on 2019/6/27
 * 输入一个链表，输出该链表中倒数第k个结点
 *
 * @author Sky
 */
public class LastKthNodeInLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.createLinkedList(1, 2, 3, 4, 5, 6);
        ListNode node = new LastKthNodeInLinkedList().FindKthToTail(head, 3);
        System.out.println(node.val);
    }

    /**
     * 单链表向前查找困难，故需要使用双指针的方式来查找倒数第k个节点
     *
     * @param head 头结点
     * @param k    倒数
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        /*
         * 对于一个单链表，倒数第k个节点和最后一个节点之间间隔了3个节点
         * 因此使用双指针的方式只要保持前后两个指针间隔3个节点进行遍历
         * 直到前指针指向最后一个节点时，后指针即指向了倒数第k个节点
         *
         *              last 4th node        last node
         *                  |                   |
         *                  |←---  3 nodes   --→|
         *                  ↓                   ↓
         * ... -> 9 -> 3 -> 2 -> 6 -> 4 -> 5 -> 2
         */
        if (k == 0) {
            return null;
        }
        ListNode font = head, back = head;
        while (k > 1 && font != null) {
            font = font.next;
            k--;
        }
        if (font == null) {
            return null;
        }
        while (font.next != null) {
            font = font.next;
            back = back.next;
        }
        return back;
    }
}
