package interviewbit.threeSum;

import java.util.*;

/**
 * Created by adib on 9/11/16.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> elems) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Set<ArrayList<Integer>> duplicateTracking = new HashSet<>();
        if (elems == null || elems.size() < 3) {
            return result;
        }
        //Sort the elems in the list.
        Collections.sort(elems);
        int len = elems.size();
        for ( int a = 0; a < len - 2; a++) {
            int b = a + 1;
            int c = len - 1;
            while (b < c) {
                int sum = elems.get(a) + elems.get(b) + elems.get(c);
                if (sum == 0) {
                    Integer[] tempArray = {elems.get(a), elems.get(b), elems.get(c)};
                    ArrayList<Integer> answerList = new ArrayList<>(Arrays.asList(tempArray));
                    if (!duplicateTracking.contains(answerList)){
                        result.add(answerList);
                        duplicateTracking.add(answerList);
                    }
                }
                if ( sum > 0) {
                    c--;
                } else {
                    b++;
                }
            }
        }
        return result;
    }
}
