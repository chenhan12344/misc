package leetcode.medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Sky on 2019/1/19
 *
 * @author Sky
 */
public class LC841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>(rooms.get(0));
        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()) {
            Set<Integer> newKeys = new HashSet<>();
            for (int key : keys) {
                newKeys.addAll(rooms.get(key));
            }
            keys.addAll(newKeys);
            iterator.remove();
        }
        return false;
    }


}
