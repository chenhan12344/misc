package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sky on 2019/8/26
 *
 * @author Sky
 */
public class CloneSpecialLinkedList {

    /**
     * 此方法使用了一个HashMap来建立原链表节点与新链表节点之间的映射关系
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(pHead.label);
        Map<RandomListNode, RandomListNode> map = new HashMap<>(16, 1.0f);
        for (RandomListNode p = pHead.next, q = newHead; p != null; p = p.next) {
            q.next = new RandomListNode(p.label);
            q = q.next;
            map.put(p, q);
        }
        for (RandomListNode p = pHead, q = newHead; p != null; p = p.next, q = q.next) {
            q.random = map.get(p.random);
        }
        return newHead;
    }

    /**
     * 就地在原链每个节点后复制一次节点
     * 然后将原链表拆成两个链表即可
     * @param pHead
     * @return
     */
    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        for (RandomListNode p = pHead; p != null; ) {
            RandomListNode newNode = new RandomListNode(p.label);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        for (RandomListNode p = pHead, q; p != null; ) {
            q = p.next;
            q.random = p.random == null ? null : p.random.next;
            p = q.next;
        }
        RandomListNode newHead = pHead.next;
        for (RandomListNode p = pHead, q; p != null; ) {
            q = p.next;
            p.next = q.next;
            p = p.next;
            q.next = (p == null ? null : p.next);
        }
        return newHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}