package leetcode.hard;

import structure.list.LinkedListUtils;
import structure.list.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 44399 on 2019/2/3
 *
 * @author 44399
 */
public class LC23 {

    public static void main(String[] args) {
        LinkedListUtils.printLinkedList(new LC23().mergeKLists(new ListNode[]{
                LinkedListUtils.createLinkedList(1, 4, 5),
                LinkedListUtils.createLinkedList(1, 3, 4),
                LinkedListUtils.createLinkedList(2, 6)
        }));
    }

    /**
     * time complexity in order of O(m * n)
     */
    public ListNode mergeKLists(ListNode[] lists) {
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
}
