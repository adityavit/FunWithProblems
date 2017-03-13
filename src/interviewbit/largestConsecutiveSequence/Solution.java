package interviewbit.largestConsecutiveSequence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/longest-consecutive-sequence/
 * This problem is simple. O(n). Iterative DFS, I don't think stack will work in this, easy to get stack overflow error.
 * Maintain a map for the numbers in the list, with the visited as the value and the number as the key.
 * For each value in the list check whether the next Value is present and is not visited mark the nextvalue visited then increase the next value.
 * Similarly check for the previous value.
 * Get the total Count as the sum of move in the next and previous plus that number itself.
 * Created by adib on 10/1/16.
 */
public class Solution {
    public int longestConsecutive(final List<Integer> values) {
        if (values == null || values.size() == 0) {
            return 0;
        }
        int maxCons = 0;
        Map<Integer, Boolean> digitVisitedMap = new HashMap<>();
        for(Integer value: values) {
            digitVisitedMap.put(value, false);
        }
        int i = 0;
        int len = values.size();
        while ( i < len) {
            int elem = values.get(i);
            //If elem is visited already then nothing needs to be done.
            if (!digitVisitedMap.get(elem)) {
                //If elem is not present in the map
                //Get the previous and next value for the elem, check for each one of them.
                int nextValue = elem + 1;
                int prevValue = elem - 1;
                int nextCount = 0;
                int prevCount = 0;
                while(digitVisitedMap.containsKey(nextValue) && !digitVisitedMap.get(nextValue)) {
                    digitVisitedMap.put(nextValue, true);
                    nextValue++;
                    nextCount++;
                }
                while(digitVisitedMap.containsKey(prevValue) && !digitVisitedMap.get(prevValue)) {
                    digitVisitedMap.put(prevValue, true);
                    prevValue--;
                    prevCount++;
                }
                int totalCount = 1 + nextCount + prevCount;
                if (totalCount > maxCons) {
                    maxCons = totalCount;
                }
                digitVisitedMap.put(elem, true);
            }
            i++;
        }
        return maxCons;
    }
}
