package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Sky on 2019/8/26
 *
 * @author Sky
 */
public class StackWithMin {

    private Deque<Integer> stack;
    private PriorityQueue<Integer> heap;

    public StackWithMin() {
        this.stack = new LinkedList<>();
        this.heap = new PriorityQueue<>();
    }

    public void push(int node) {
        stack.push(node);
        heap.add(node);
    }

    public void pop() {
        heap.remove(stack.pop());
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return heap.peek();
    }
}
