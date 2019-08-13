package structure.list;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 44399 on 2019/2/13
 * 链表工具类
 *
 * @author 44399
 */
public class LinkedListUtils {

    /**
     * 打印链表
     *
     * @param head 链表表头
     */
    public static void printLinkedList(ListNode head) {
        List<String> nums = new LinkedList<>();
        while (head != null) {
            nums.add(String.valueOf(head.val));
            head = head.next;
        }
        System.out.println(String.join(" -> ", nums));
    }

    /**
     * 创建链表
     *
     * @param items 链表元素
     * @return 链表表头
     */
    public static ListNode createLinkedList(Integer... items) {
        int len = items.length;
        if (len == 0) {
            return null;
        }
        ListNode head = new ListNode(items[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            head = new ListNode(items[i], head);
        }
        return head;
    }
}
