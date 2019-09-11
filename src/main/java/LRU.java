import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sky on 2019/8/27
 *
 * @author Sky
 */
public class LRU {

    private Map<Integer, BiListNode> indexMap;
    private int capacity;
    private int size;
    private BiListNode head;
    private BiListNode tail;

    public LRU(int capacity) {
        this.indexMap = new HashMap<>(capacity + 1, 1.0f);
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int num) {
        if (indexMap.containsKey(num)) {
            System.out.println("缓存命中");
            int res = indexMap.get(num).val;
            updatePage(num);
            return res;
        } else {
            System.out.println("缺页中断");
            // 模拟从磁盘读取页框
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (size == 0) {
                head = tail = new BiListNode(num);
                size++;
                indexMap.put(num, head);
                return num;
            }
            BiListNode newHead = new BiListNode(num);
            if (size == capacity) {
                // 创建新节点并放入表头
                BiListNode h = head;
                newHead.next = h;
                h.prev = newHead;
                head = newHead;
                // 删除尾部节点
                BiListNode t = tail;
                BiListNode p = tail.prev;
                indexMap.remove(t.val);
                p.next = null;
                t.prev = null;
                tail = p;
            } else {
                // 创建新节点并放入表头
                BiListNode h = head;
                newHead.next = h;
                h.prev = newHead;
                head = newHead;
                size++;
            }
            indexMap.put(num, newHead);
            return num;
        }
    }

    private void updatePage(int num) {
        if (size <= 1) {
            return;
        }
        if (head.val == num) {
            return;
        }
        BiListNode cur = indexMap.get(num);
        if (tail.val == num) {
            BiListNode t = tail;
            BiListNode h = head;
            BiListNode p = tail.prev;
            p.next = null;
            t.prev = null;
            tail = p;
            t.next = h;
            h.prev = t;
            head = t;
        } else {
            BiListNode p = cur.prev;
            BiListNode n = cur.next;
            p.next = n;
            n.prev = p;
            BiListNode h = head;
            cur.next = h;
            h.prev = cur;
            head = cur;
        }
    }

    static class BiListNode {

        BiListNode prev;
        BiListNode next;
        int val;

        BiListNode(int val) {
            this.val = val;
        }

    }
}