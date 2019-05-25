/**
 * Created by Sky on 2019/4/11
 *
 * @author Sky
 */
public class MyQueue<T> {

    private Object[] values;
    private int head;
    private int tail;
    private int length;
    private final int size;

    public MyQueue(int size) {
        this.values = new Object[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.length = 0;
    }

    public boolean enqueue(T t) {
        if (this.length == size) {
            return false;
        } else {
            length++;
            values[tail] = t;
            tail = (tail + 1) % size;
            return true;
        }
    }

    public T dequeue() {
        if (this.size == 0) {
            return null;
        } else {
            length--;
            Object value = values[head];
            head = (head + 1) % size;
            return (T) value;
        }
    }

    public T peak() {
        if (this.size == 0) {
            return null;
        } else {
            return (T) values[head];
        }
    }

    public int length() {
        return length;
    }
}
