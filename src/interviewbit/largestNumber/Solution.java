package interviewbit.largestNumber;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/largest-number/
 * Created by adib on 8/18/16.
 */
public class Solution {
    // DO NOT MODIFY THE LIST
    public String largestNumber(final List<Integer> lst) {
        Comparator<Integer> comp = (Integer a, Integer b) -> {
            int da = numOfDigits(a);
            int db = numOfDigits(b);
            Double bFirst = b * Math.pow(10, da) + a;
            Double aFirst = a * Math.pow(10, db) + b;
            return bFirst.compareTo(aFirst);
        };
        Collections.sort(lst, comp);
        StringBuilder sb = new StringBuilder();
        boolean allZeros = true;
        for(Integer elem : lst) {
            if (elem != 0) {
                allZeros = false;
            }
            sb.append(elem);
        }
        if (allZeros)
            return "0";

        return sb.toString();
    }

    public int numOfDigits(int x) {
        if (x >= 0 && x <= 9 )
            return 1;
        int digits = 0;
        while ( x != 0) {
            x = x/10;
            digits++;
        }
        return digits;
    }

}
