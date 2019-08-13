package leetcode.easy;

import structure.list.ListNode;

/**
 * Created by 44399 on 2019/2/3
 * --------------------------------------------------
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * --------------------------------------------------
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * --------------------------------------------------
 *
 * @author 44399
 */
public class LC21 {

    public static void main(String[] args) {
    }

    /**
     * 合并具体思想是，两个链表list1和list2同时开始遍历
     * 在list1中寻找合适的位置将list2中的节点逐一插入
     *
     * @param l1 链表1表头
     * @param l2 链表2表头
     * @return 合并后的表头
     */
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
        /*
         * 若节点j的值介于节点i的值和iNext的值之间
         * 则将节点j插入到节点i和iNext之间，然后各指针顺次后移
         *
         * 合并过程：
         * +---------------------+
         * |i  iNext             |
         * |↓    ↓               |
         * |1 -> 3 -> 5 -> 7     |
         * |2 -> 4 -> 6          |
         * |↑                    |
         * |j                    |
         * +---------------------+
         * |i    j  iNext        |
         * |↓    ↓    ↓          |
         * |1 -> 2 -> 3 -> 5 -> 7|
         * |     4 -> 6          |
         * |     ↑               |
         * |    tmp              |
         * +---------------------+
         * |     i  iNext        |
         * |     ↓    ↓          |
         * |1 -> 2 -> 3 -> 5 -> 7|
         * |     4 -> 6          |
         * |     ↑               |
         * |     j               |
         * +---------------------+
         * 合并至i或j遇到末尾
         */
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
