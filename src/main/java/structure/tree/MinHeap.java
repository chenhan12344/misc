package structure.tree;

import java.util.Arrays;

/**
 * Created by 44399 on 2019/2/24
 *
 * @author 44399
 */
public class MinHeap {

    private static int defaultCapacity = 16;
    private int size;

    int[] elements;

    public MinHeap() {
        this(defaultCapacity);
    }

    public MinHeap(int capacity) {
        if (capacity < defaultCapacity) {
            this.elements = new int[defaultCapacity];
        } else {
            this.elements = new int[capacity];
        }
    }

    private void ensureCapacity(int size) {
        if (size > elements.length) {
            int newCapacity = elements.length >> 1;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void sort() {
    }

    public int pop() {
        return elements[0];
    }

    public void push(int element) {
        this.elements[size] = element;
        sort();
    }
}
