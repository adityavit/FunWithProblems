package interviewbit.intersectionOfSortedArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adib on 9/11/16.
 */
public class Solution {
    /**
     * This is a
     * @param a
     * @param b
     * @return
     */
    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>();
        if ( a == null || b == null || (a.size() == 0 && b.size() == 0)) {
            return result;
        }
        int aI = 0;
        int lenA = a.size();
        int bI = 0;
        int lenB = b.size();
        while ( aI < lenA && bI < lenB) {
            int elemA = a.get(aI);
            int elemB = b.get(bI);
            if (elemA == elemB) {
                result.add(elemA);
                aI++;
                bI++;
                continue;
            }
            if (elemA < elemB) {
                aI++;
            } else {
                bI++;
            }
        }
        return result;
    }
}
