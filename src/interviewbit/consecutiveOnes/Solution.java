package interviewbit.consecutiveOnes;

import java.util.ArrayList;

/**
 * Created by adib on 9/12/16.
 */
public class Solution {
    public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        if ( a == null || a.size() == 0) {
            return result;
        }
        int maxLength = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int start = 0;
        int end = 0;
        int oneLen = 0;
        int len = a.size();
        int i = 0;
        int k = b;
        int consecutiveZero = 0;
        while ( i < len ) {
            consecutiveZero++;
            int elem = a.get(i);
            if ( elem == 0 ) {
                if ( k > 0) {
                    end = i;
                    k--;
                    oneLen++;
                } else {
                    //If the k is reached and we get another zero then we include this zero.
                    // So rather then starting a new group we
                    if (consecutiveZero > b) {
                        start = i - b + 1;
                    } else {
                        start = start + 1;
                    }
                    end = i;
                }
            } else {
                //If element is 1 then just increase the end and see if it is greater than max.
                end++;
                oneLen++;
                consecutiveZero = 0;
            }
            if (oneLen > maxLength) {
                maxLength = oneLen;
                maxStart = start;
                maxEnd = end;
            }
            i++;
        }
        for (int j = maxStart; j <= maxEnd; j++) {
            result.add(j);
        }
        return result;
    }
}

