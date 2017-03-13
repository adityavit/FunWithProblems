package interviewbit.arrays.antiDiagonal;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/anti-diagonals/
 * index i + j is the index of the diagonal array in the result array.
 * Created by adib on 11/5/16.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int rows = nums.size();
        int cols = nums.get(0).size();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int diagonalListIndex = i + j;
                ArrayList<Integer> diagonalList;
                if (result.size() - 1 >= diagonalListIndex) {
                    diagonalList = result.get(diagonalListIndex);
                }else {
                    diagonalList = new ArrayList<>();
                    result.add(diagonalList);
                }
                int value = nums.get(i).get(j);
                diagonalList.add(value);
            }
        }
        return result;
    }
}
