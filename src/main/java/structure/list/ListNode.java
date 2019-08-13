package structure.list;

/**
 * Created by Sky on 2019/1/22
 * 链表节点
 *
 * @author Sky
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
