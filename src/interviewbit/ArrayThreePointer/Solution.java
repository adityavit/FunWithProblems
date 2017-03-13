package interviewbit.ArrayThreePointer;

import java.util.List;

/**
 * https://www.interviewbit.com/problems/array-3-pointers/
 *
 * Created by adib on 9/14/16.
 */
public class Solution {
    public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
        if (a == null || b == null || c == null || a.size() == 0 || b.size() == 0 || c.size() == 0 ) {
            return -1;
        }

        int aLen = a.size();
        int bLen = b.size();
        int cLen = c.size();
        int aI = 0;
        int bI = 0;
        int cI = 0;
        int min = Math.max( Math.abs(a.get(0) - b.get(0)), Math.max(Math.abs(b.get(0) - c.get(0)), Math.abs(c.get(0) - a.get(0))));
        while (aI < aLen && bI < bLen && cI < cLen) {
            int aVal = a.get(aI);
            int bVal = b.get(bI);
            int cVal = c.get(cI);
            int diff = Math.max( Math.abs(aVal - bVal), Math.max(Math.abs(bVal - cVal), Math.abs(cVal - aVal)));
            if (diff < min) {
                min = diff;
            }
            if (aVal <= bVal && aVal <= cVal) {
                aI++;
            } else if (bVal <= aVal && bVal <= cVal) {
                bI++;
            } else {
                cI++;
            }
        }
        return min;
    }
}
