package structure.list;

import java.util.Arrays;

/**
 * Created by 44399 on 2019/2/13
 *
 * @author 44399
 */
public class LinkedListUtils {

    public static void printLinkedList(ListNode head) {
        List<String> nums = new LinkedList<>();
        while (head != null) {
            nums.add(String.valueOf(head.val));
            head = head.next;
        }
        System.out.println(String.join(" -> ", nums));
    }

    public static ListNode createLinkedList(List<Integer> vals) {
        int[] nums = new int[vals.size()];
        for (int i = 0; i < vals.size(); i++) {
            nums[i] = vals.get(i);
        }
        return createLinkedList(nums);
    }

    public static ListNode createLinkedList(int[] vals) {
        int len = vals.length;
        if (len == 0) {
            return null;
        }
        ListNode head = new ListNode(vals[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            head = new ListNode(vals[i], head);
        }
        return head;
    }

    public static ListNode createLinkedList(Integer... vals) {
        return createLinkedList(Arrays.asList(vals));
    }
}
