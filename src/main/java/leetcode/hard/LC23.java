package leetcode.hard;

import structure.list.LinkedListUtils;
import structure.list.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 44399 on 2019/2/3
 * --------------------------------------------------
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * --------------------------------------------------
 * Example:
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * --------------------------------------------------
 *
 * @author 44399
 */


public class LC23 {

    public static void main(String[] args) {
        LinkedListUtils.printLinkedList(new LC23().mergeKLists(new ListNode[]{
                LinkedListUtils.createLinkedList(-10, -9, -9, -3, -1, -1, 0),
                LinkedListUtils.createLinkedList(-5),
                LinkedListUtils.createLinkedList(4),
                LinkedListUtils.createLinkedList(-8),
                LinkedListUtils.createLinkedList(),
                LinkedListUtils.createLinkedList(-9, -6, -5, -4, -2, 2, 3),
                LinkedListUtils.createLinkedList(-3, -3, -2, -1, 0),
        }));
    }

    /**
     * time complexity in order of O(m * n)
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        List<Integer> numList = new ArrayList<>();
        for (ListNode head : lists) {
            for (ListNode listNode = head; listNode != null; listNode = listNode.next) {
                numList.add(listNode.val);
            }
        }
        if (numList.size() == 0) {
            return null;
        }
        Collections.sort(numList);
        ListNode head = new ListNode(numList.get(numList.size() - 1));
        for (int i = numList.size() - 2; i >= 0; i--) {
            ListNode prev = new ListNode(numList.get(i));
            prev.next = head;
            head = prev;
        }
        return head;
    }

    /**
     * 基于两路链表归并的多路合并算法
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        /*
         * 每次都将相邻两个链表合并，直至剩余一个链表
         *
         *                        +
         *                        |
         *               +-----------------+
         *               |                 |
         *       +---------------+         |
         *       |               |         |
         *   +-------+       +-------+     |
         *   |       |       |       |     |
         * +---+   +---+   +---+   +---+   |
         * |   |   |   |   |   |   |   |   |
         * 0   1   2   3   4   5   6   7   8
         */
        int i, step = 1;
        while (step < lists.length) {
            i = 0;
            do {
                if (i + step < lists.length) {
                    lists[i] = mergeTwoList(lists[i], lists[i + step]);
                }
                i += 2 * step;
            } while (i + step < lists.length);
            step *= 2;
        }
        return lists[0];
    }

    /**
     * 两路链表归并算法，详见LC21
     *
     * @see leetcode.easy.LC21
     */
    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        ListNode i = list1, j = list2;
        ListNode iNext = i.next, tmp;
        while (i.next != null && j != null) {
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
        if (j != null) {
            i.next = j;
        }
        return list1;
    }
}