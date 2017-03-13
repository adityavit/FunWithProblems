package interviewbit.diffK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adib on 9/11/16.
 */
public class Solution {

    /**
     * https://www.interviewbit.com/problems/diffk/
     * Tried this first with an approach similar to 3 sum. Starting a pointer at first and at back.
     * That approach doesn't work, because lets say when the diff is more than k than what to do increase the start pointer which will decrease the difference
     * or decrease the end pointer which will also decrease the difference.
     *
     * Correct approach is to start one pointer j from 0 and i from 1, if they both become equal increase i and continue.
     * Else calculate the diff, now if the diff is more than k then if you increase j then diff will decrease and if diff is less than k then increase i which increases the diff.
     * @param elems
     * @param k
     * @return
     */
    public int diffPossible(ArrayList<Integer> elems, int k) {
        if (elems == null || elems.size() < 2) {
            return 0;
        }
        int j = 0;
        int i = 1;
        int len = elems.size();
        while ( i < len) {
            if ( i == j) {
                i++;
                continue;
            }
            int diff = elems.get(i) - elems.get(j);
            if ( diff == k) {
                return 1;
            }
            if ( diff > k ) {
                j++;
            } else {
                i++;
            }
        }
        return 0;
    }

    /**
     * Two pointer approach is not working for example in the case
     * [ 1, 2, 2, 3, 4 ]
     * 0
     * gives result 0 expected 1
     * @param a
     * @param target
     * @return
     */
//    public int diffPossibleTwoPointer(ArrayList<Integer> elems, int k) {
//        if (elems == null || elems.size() < 2) {
//            return 0;
//        }
//        int j = 0;
//        int len = elems.size();
//        int i = len - 1;
//        while (j < i) {
//            int diff = elems.get(i) - elems.get(j) - k;
//            if (diff == 0) {
//                return 1;
//            }
//            if ( diff > 0) {
//                // Means that the elems.get(i) is bigger
//                i--;
//            } else {
//                j++;
//            }
//        }
//        return 0;
//    }

    /**
     * https://www.interviewbit.com/problems/diffk-ii/
     * Difference here from the above is that this one is not sorted.
     * So used hash like finding 2 sum.
     * @param a
     * @param target
     * @return
     */
    public int diffPossible(final List<Integer> a, int target) {
        if (a == null || a.size() == 0)
            return 0;

        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
        int len = a.size();
        for (int i = 0; i < len; i++) {
            if (numIndexMap.containsKey(a.get(i))) {
                List<Integer> indexes = numIndexMap.get(i);
                indexes.add(i);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                numIndexMap.put(a.get(i), indexes);
            }
        }
        for (Integer j = 0; j < len; j++) {
            Integer diff = target + a.get(j);
            if (numIndexMap.containsKey(diff)) {
                List<Integer> indexes = numIndexMap.get(diff);
                for(Integer index: indexes) {
                    if (!index.equals(j)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
