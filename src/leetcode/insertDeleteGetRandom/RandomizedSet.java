package leetcode.insertDeleteGetRandom;

import java.util.*;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 * Created using a map which stores the value and index and a list which stores the values.
 * @accepted
 * Created by adib on 10/4/16.
 */
public class RandomizedSet {
    Map<Integer, Integer> valueIndex;
    List<Integer> values;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueIndex = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueIndex.containsKey(val))
            return false;
        values.add(val);
        valueIndex.put(val, values.size() -1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valueIndex.containsKey(val))
            return false;
        int length = values.size() - 1;
        int removeIndex = valueIndex.get(val);
        int lastElem = values.get(length);
        valueIndex.remove(val);
        values.remove(length);
        if (removeIndex == length) {
            return true;
        }
        values.set(removeIndex, lastElem);
        valueIndex.put(lastElem, removeIndex);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = values.size();
        int randomIndex = random.nextInt(size);
        if ( size > 0) {
            return values.get(randomIndex);
        }
        return 0;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
