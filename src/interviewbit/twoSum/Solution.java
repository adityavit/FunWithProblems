package interviewbit.twoSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/2-sum/
 * Doesn't have the condition that there is a unique solution.
 * Also some condition on returning of the solution is there.
 * Created by adib on 9/25/16.
 */
public class Solution {
    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a == null || a.size() == 0) {
            return result;
        }
        Map<Integer, List<Integer>> numberMap = new HashMap<>();
        int i = 0;
        int len = a.size();
        while (i < len) {
            int num = a.get(i);
            if (numberMap.containsKey(num)) {
                List<Integer> indexes = numberMap.get(num);
                indexes.add(i);
            } else {
                List<Integer> indexes = new ArrayList<Integer>();
                indexes.add(i);
                numberMap.put(num, indexes);
            }
            i++;
        }
        int index1 = -1;
        int index2 = len + 1;
        for(i = 0; i < len; i++) {
            int remainingTarget = b - a.get(i);
            if (numberMap.containsKey(remainingTarget)) {
                //Difference exist find other index not equal to i.
                List<Integer> indexes = numberMap.get(remainingTarget);
                for(int j = 0; j < indexes.size(); j++) {
                    if ( indexes.get(j) + 1 < index2 && i < indexes.get(j)) {
                        // 1. index1 < index 2
                        // 2. index2 is the minimum in all the solutions.
                        index1 = i + 1;
                        index2 = indexes.get(j) + 1;
                    }
                }
            }
        }
        if (index1 != -1) {
            result.add(index1);
            result.add(index2);
        }
        return result;
    }
}
