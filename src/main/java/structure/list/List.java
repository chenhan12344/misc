package structure.list;

/**
 * Created by Sky on 2019/3/24
 *
 * @author Sky
 */
public interface List {

    List add(int val);

    List addAll(int... vals);

    List remove(int index);

    List sort();

    int[] toArray();
}