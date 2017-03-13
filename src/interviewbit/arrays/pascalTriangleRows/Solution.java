package interviewbit.arrays.pascalTriangleRows;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/pascal-triangle-rows/
 * time: O(rows^2)
 * space: (rows^2)
 * Created by adib on 10/22/16.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int rows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (rows == 0) {
            return result;
        }
        ArrayList<Integer> resultRow = new ArrayList<>();
        resultRow.add(1);
        result.add(resultRow);
        if ( rows == 1) {
            return result;
        }
        for ( int i = 1; i < rows; i++) {
            ArrayList<Integer> lastRow = result.get(i - 1);
            ArrayList<Integer> newRow = new ArrayList<>();
            int lastResult = 0;
            for ( int j = 0; j < lastRow.size(); j++) {
                newRow.add(lastResult + lastRow.get(j));
                lastResult = lastRow.get(j);
            }
            newRow.add(lastResult);
            result.add(newRow);
        }
        return result;
    }
}
