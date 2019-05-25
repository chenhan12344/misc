package design.adapter;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by DJH on 2019/1/2
 */
public class EnumeratorIterator extends ArrayList {

    private Enumeration enumeration;

    public EnumeratorIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    public Object next() {
        return enumeration.nextElement();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

}
