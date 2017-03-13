package zeroMatrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by adib on 5/30/16.
 */
public class Solution {

    public void makeZeroMatrix(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        Set<Integer> rowSet = new HashSet<Integer>();
        Set<Integer> colSet = new HashSet<Integer>();
        int rowSize = matrix.length;
        int colSize = 0;
        if (matrix[0] != null) {
            colSize = matrix[0].length;
        }

        for (int i = 0; i < rowSize; i++) {
           for (int j = 0; j < colSize; j++) {
               if (matrix[i][j] == 0) {
                   if (!rowSet.contains(i)) {
                       rowSet.add(i);
                   }
                   if(!colSet.contains(j)) {
                       colSet.add(j);
                   }
               }
           }
        }

        makeRowZero(matrix, rowSet, colSize);
        makeColZero(matrix, colSet, rowSize);
    }

    private void makeRowZero(int[][] matrix, Set<Integer> rowSet, int colSize) {
        for(Integer row : rowSet) {
            for(int j = 0; j < colSize; j++) {
                matrix[row][j] = 0;
            }
        }
    }

    private void makeColZero(int[][] matrix, Set<Integer> colSet, int rowSize) {
        for(Integer col : colSet) {
            for(int i = 0; i < rowSize; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
