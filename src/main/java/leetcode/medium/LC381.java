package leetcode.medium;

import java.util.*;

/**
 * Created by 44399 on 2019/1/31
 *
 * @author 44399
 */
public class LC381 {
}

class RandomizedCollection {

    private List<Integer> valueList;
    private List<Integer> countList;
    Map<Integer, Integer> indexMap;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        this.valueList = new LinkedList<>();
        this.countList = new LinkedList<>();
        this.indexMap = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            int index = indexMap.get(val);
            countList.set(index, countList.get(index) + 1);
            return true;
        } else {
            valueList.add(val);
            countList.add(1);
            indexMap.put(val, countList.size() - 1);
            return false;
        }
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (indexMap.containsKey(val)) {
            int index = indexMap.get(val);
            int count = countList.get(index);
            if (count > 1) {
                countList.set(index, count - 1);
            } else {
                indexMap.remove(val);
                countList.remove(index);
                valueList.remove(index);
            }
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return valueList.get(new Random().nextInt(valueList.size()));
    }
}