package interviewbit.fourSum;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/4-sum/
 * Have used a Map to solve this problem in O(n^2).
 * There is another approach to use 4 pointers on the sorted array, that would be also O(n^2) approach.
 *
 * Created by adib on 9/25/16.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if ( a == null || a.size() == 0)
            return result;

        Map<Integer,List<List<Integer>>> twoSum = new HashMap<>();
        int len = a.size();
        //Create a hashMap and store the sum in the map with two of the values.
        //calculate a + b
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = a.get(i) + a.get(j);
                List<Integer> currentSumList = new ArrayList<>();
                // Store the index so that you can check whether the index are different in the next check
                currentSumList.add(i);
                currentSumList.add(j);
                if (twoSum.containsKey(sum)) {
                    List<List<Integer>> values = twoSum.get(sum);
                    values.add(currentSumList);
                } else {
                    List<List<Integer>> values = new ArrayList<>();
                    values.add(currentSumList);
                    twoSum.put(sum, values);
                }
            }
        }
        Set<List<Integer>> listSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int elem1 = a.get(i);
                int elem2 = a.get(j);
                int sum = elem1 + elem2;
                int diff = target - sum;
                if (twoSum.containsKey(diff)) {
                    //Contains the diff, check for the values to see if it is not the same.
                    List<List<Integer>> indexes = twoSum.get(diff);
                    for(List<Integer>index: indexes) {
                        //Check if the two index is not the same as i and j
                        if ( index.get(0) != i && index.get(1) != i && index.get(0) != j && index.get(1) != j ) {
                            Integer[] values = {elem1, elem2, a.get(index.get(0)), a.get(index.get(1))};
                            Arrays.sort(values);
                            ArrayList<Integer> valueLst = new ArrayList(Arrays.asList(values));
                            if(!listSet.contains(valueLst)) {
                                listSet.add(valueLst);
                                result.add(valueLst);
                            }
                        }
                    }
                }
            }
        }
        result.sort((List<Integer> list1, List<Integer> list2)-> {
            if (list1.get(0) < list2.get(0))
                return -1;
            if (list1.get(0) > list2.get(0))
                return 1;
            if (list1.get(1) < list2.get(1))
                return -1;
            if (list1.get(1) > list2.get(1))
                return 1;
            if (list1.get(2) < list2.get(2))
                return -1;
            if (list1.get(2) > list2.get(2))
                return 1;
            if (list1.get(3) < list2.get(3))
                return -1;
            if (list1.get(3) > list2.get(3))
                return 1;
            return 0;
        });
        return result;
    }
}
