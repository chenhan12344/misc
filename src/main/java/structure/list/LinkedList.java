package structure.list;

/**
 * Created by Sky on 2019/3/24
 *
 * @author Sky
 */
public class LinkedList implements List {

    ListNode head;
    int size;

    public LinkedList() {
        head = new ListNode();
        size = 0;
    }

    public LinkedList(List list) {
        head = new ListNode();
    }

    @Override
    public List add(int val) {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        size++;
        return this;
    }

    @Override
    public List addAll(int... vals) {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        for (int i : vals) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        size += vals.length;
        return this;
    }

    @Override
    public List remove(int index) {
        if (index > size + 1) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        return this;
    }

    @Override
    public List sort() {
        return this;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[size];
        ListNode cur = head;
        for (int i = 0; i < size; i++) {
            array[i] = cur.val;
            cur = cur.next;
        }
        return array;
    }
}
