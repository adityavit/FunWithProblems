package maxNonNegativeSubArray;

import java.util.ArrayList;

/**
 * Created by adib on 7/31/16.
 */
public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int subArrStartIndex = -1, subArrayEndIndex = 0;
        double maxSubArraySum = -1;
        int maxSubArrStartIndex = -1, maxSubArrEndIndex = 0;
        double subArrSum = 0;
        int i = 0;
        while(i < a.size()) {
            if (a.get(i) >= 0 && i != (a.size() - 1)) {
                subArrSum += a.get(i);
                if (subArrStartIndex ==  -1) {
                    subArrStartIndex = i;
                }
                subArrayEndIndex = i;
            } else {
                if(a.get(i) >= 0 && i == (a.size() - 1)) {
                    subArrSum += a.get(i);
                    if (subArrStartIndex ==  -1) {
                        subArrStartIndex = i;
                    }
                    subArrayEndIndex = i;
                }
                if (subArrSum > maxSubArraySum) {
                    maxSubArraySum = subArrSum;
                    maxSubArrStartIndex = subArrStartIndex;
                    maxSubArrEndIndex = subArrayEndIndex;
                } else if (subArrSum == maxSubArraySum) {
                    if ((subArrayEndIndex - subArrStartIndex) > (maxSubArrEndIndex - maxSubArrStartIndex)) {
                        maxSubArraySum = subArrSum;
                        maxSubArrStartIndex = subArrStartIndex;
                        maxSubArrEndIndex = subArrayEndIndex;
                    } else if ((subArrayEndIndex - subArrStartIndex) == (maxSubArrEndIndex - maxSubArrStartIndex) && subArrStartIndex != -1) {
                        if (a.get(subArrStartIndex) < a.get(maxSubArrStartIndex)) {
                            maxSubArraySum = subArrSum;
                            maxSubArrStartIndex = subArrStartIndex;
                            maxSubArrEndIndex = subArrayEndIndex;
                        }
                    }
                }
                subArrSum = 0;
                subArrStartIndex = -1;
                subArrayEndIndex = 0;
            }
            i++;
        }
        if (maxSubArrStartIndex == -1)
            return new ArrayList<Integer>();

        return new ArrayList<Integer>(a.subList(maxSubArrStartIndex , maxSubArrEndIndex+1));
    }
}