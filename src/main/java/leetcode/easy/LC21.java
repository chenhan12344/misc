package leetcode.easy;

import structure.list.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 44399 on 2019/2/3
 *
 * @author 44399
 */
public class LC21 {

    public static void main(String[] args) {
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> numList = new ArrayList<>();
        for (ListNode listNode = l1; listNode != null; listNode = listNode.next) {
            numList.add(listNode.val);
        }
        for (ListNode listNode = l2; listNode != null; listNode = listNode.next) {
            numList.add(listNode.val);
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
