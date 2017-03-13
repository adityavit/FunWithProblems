package interviewbit.equalSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/equal/
 * Created by adib on 9/25/16.
 */
public class Solution {

    /**
     * This is the solution i came up with.
     * It is very similar to the 4 sum problem, if we use a map to solve that problem.
     * But the solution can contain only one loop, as you can use the first loop to store the result and also to check if the result already exist
     * and matches condition then return it.
     * @param elems
     * @return
     * @accepted
     */
    public ArrayList<Integer> equal(ArrayList<Integer> elems) {
        ArrayList<Integer> result = new ArrayList<>();
        if ( elems == null || elems.size() == 0)
            return result;
        int len = elems.size();
        Map<Integer, List<List<Integer>>> sumMap = new HashMap<>();
        for( int c = 0; c < len; c++ ) {
            for(int d = c + 1; d < len; d++) {
                int sum = elems.get(c) + elems.get(d);
                List<Integer> sumIndex = new ArrayList<>();
                sumIndex.add(c);
                sumIndex.add(d);
                if (sumMap.containsKey(sum)) {
                    List<List<Integer>> indexes = sumMap.get(sum);
                    indexes.add(sumIndex);
                } else {
                    List<List<Integer>> indexes = new ArrayList<>();
                    indexes.add(sumIndex);
                    sumMap.put(sum, indexes);
                }
            }
        }

        for ( Integer a = 0; a < len; a++) {
            for ( Integer b = a + 1; b < len; b++) {
                int sum = elems.get(a) + elems.get(b);
                if (sumMap.containsKey(sum)) {
                    List<List<Integer>> indexes = sumMap.get(sum);
                    for (List<Integer> index : indexes) {
                        if (a < index.get(0) && b != index.get(0) && b != index.get(1)){
                            result.add(a);
                            result.add(b);
                            result.add(index.get(0));
                            result.add(index.get(1));
                            return result;
                        }
                    }
                }
            }
        }
        return result;
    }
}
