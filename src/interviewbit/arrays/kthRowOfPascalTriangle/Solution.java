package interviewbit.arrays.kthRowOfPascalTriangle;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
 * time Complexity: O(row^2) or O(k^2)
 * For each row(i) it iterates for previous row elements which is equal to i
 * Space : O(row)
 * As i am using just one arrayList to store all the elements.
 * Created by adib on 10/22/16.
 */
public class Solution {
    public ArrayList<Integer> getRow(int row) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        if ( row == 0) {
            return result;
        }
        for (int i = 1; i <= row; i++) {
            int lastResultSize = result.size();
            int lastResult = 0;
            for (int j = 0; j < lastResultSize; j++) {
                int sum = lastResult + result.get(j);
                lastResult = result.get(j);
                result.set(j, sum);
            }
            result.add(lastResult);
        }
        return result;
    }
}
