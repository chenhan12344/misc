package structure.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sky on 2019/7/9
 *
 * @author Sky
 */
public class MaxHeap<T extends Comparable> {

    public static void main(String[] args) {
        MaxHeap<String> maxHeap = new MaxHeap<>();

    }

    private List<T> elements;

    public MaxHeap() {
        this.elements = new ArrayList<>();
    }

    public MaxHeap(int initialCapacity) {
        this.elements = new ArrayList<>(initialCapacity);
    }

    public void add(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        elements.add(t);
        sortUp();
    }

    public T pop() {
        if (elements.size() == 0) {
            return null;
        }
        T top = elements.get(0);
        elements.set(0, elements.remove(elements.size() - 1));
        sortDown();
        return top;
    }

    private void sortDown() {
    }

    private void sortUp() {
        int curIdx = elements.size() - 1, parentIdx = ((curIdx + 1) >> 1) - 1;
        while (curIdx >= 0) {

        }
    }
}
