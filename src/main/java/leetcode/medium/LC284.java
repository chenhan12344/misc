package leetcode.medium;

import java.util.Iterator;

/**
 * Created by 44399 on 2019/2/23
 *
 * @author 44399
 */
public class LC284 {

}

class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private boolean isPeeking;
    private boolean hasNext;
    private int peekVal;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.isPeeking = false;
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (isPeeking) {
            return peekVal;
        }
        if (iterator.hasNext()) {
            hasNext = true;
            isPeeking = true;
            peekVal = iterator.next();
            return peekVal;
        }
        return null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (isPeeking) {
            isPeeking = false;
            return peekVal;
        } else {
            return iterator.hasNext() ? iterator.next() : null;
        }
    }

    @Override
    public boolean hasNext() {
        if (isPeeking) {
            return true;
        }
        return iterator.hasNext();
    }
}
