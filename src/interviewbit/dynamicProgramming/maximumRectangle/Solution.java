package interviewbit.dynamicProgramming.maximumRectangle;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/
 * https://leetcode.com/problems/maximal-rectangle/
 * Created by adib on 11/6/16.
 */
public class Solution {
    /**
     * interviewbit
     * @param matrix
     * @return
     */
    public int maximalRectangle(ArrayList<ArrayList<Integer>> matrix) {
        if ( matrix == null || matrix.size() == 0) {
            return 0;
        }
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int[][] rowMatrix = new int[rows][cols];
        int[][] colMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix.get(i).get(j) == 0) {
                    rowMatrix[i][j] = 0;
                    colMatrix[i][j] = 0;
                    continue;
                }
                if ( i > 0 && j > 0) {
                    rowMatrix[i][j] = 1 + rowMatrix[i - 1][j];
                    colMatrix[i][j] = 1 + colMatrix[i][j - 1];
                    continue;
                }
                if ( i == 0 && j > 0) {
                    rowMatrix[i][j] = 1;
                    colMatrix[i][j] = 1 + colMatrix[i][j - 1];
                    continue;
                }
                if ( j == 0 && i > 0) {
                    rowMatrix[i][j] = 1 + rowMatrix[i - 1][j];
                    colMatrix[i][j] = 1;
                    continue;
                }
                rowMatrix[i][j] = 1;
                colMatrix[i][j] = 1;
            }
        }

        int[][] area = new int[rows][cols];
        for ( int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix.get(i).get(j) == 1) {
                    //Check the column matrix and going up.
                    int minCol = colMatrix[i][j];
                    int maxArea = 1 * minCol;
                    int k = 1;
                    while ( i - k >= 0 && matrix.get(i - k).get(j) == 1) {
                        minCol = Math.min(minCol, colMatrix[i - k][j]);
                        maxArea = Math.max(maxArea, ++k * minCol);
                    }
                    area[i][j] = maxArea;
                    //Check the row Matrix going left
                    int minRow = rowMatrix[i][j];
                    maxArea = 1 * minRow;
                    k = 1;
                    while ( j - k >= 0 && matrix.get(i).get(j - k) == 1) {
                        minRow = Math.min(minRow, rowMatrix[i][j - k]);
                        maxArea = Math.max(maxArea, ++k * minRow);
                    }
                    area[i][j] = Math.max( area[i][j] , maxArea);
                }
            }
        }
        int maxArea = area[0][0];
        for ( int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxArea = Math.max(maxArea, area[i][j]);
            }
        }
        return maxArea;
    }

    /**
     * leetcode
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if ( matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rowMatrix = new int[rows][cols];
        int[][] colMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '0') {
                    rowMatrix[i][j] = 0;
                    colMatrix[i][j] = 0;
                    continue;
                }
                if ( i > 0 && j > 0) {
                    rowMatrix[i][j] = 1 + rowMatrix[i - 1][j];
                    colMatrix[i][j] = 1 + colMatrix[i][j - 1];
                    continue;
                }
                if ( i == 0 && j > 0) {
                    rowMatrix[i][j] = 1;
                    colMatrix[i][j] = 1 + colMatrix[i][j - 1];
                    continue;
                }
                if ( j == 0 && i > 0) {
                    rowMatrix[i][j] = 1 + rowMatrix[i - 1][j];
                    colMatrix[i][j] = 1;
                    continue;
                }
                rowMatrix[i][j] = 1;
                colMatrix[i][j] = 1;
            }
        }

        int[][] area = new int[rows][cols];
        for ( int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    //area[i][j] = 1;
                    //Check the column matrix and going up.
                    int minCol = colMatrix[i][j];
                    int maxArea = 1 * minCol;
                    int k = 1;
                    while ( i - k >= 0 && matrix[i - k][j] == '1') {
                        minCol = Math.min(minCol, colMatrix[i - k][j]);
                        maxArea = Math.max(maxArea, ++k * minCol);
                    }
                    area[i][j] = maxArea;
                    //Check the row Matrix going left
                    int minRow = rowMatrix[i][j];
                    maxArea = 1 * minRow;
                    k = 1;
                    while ( j - k >= 0 && matrix[i][j - k] == '1') {
                        minRow = Math.min(minRow, rowMatrix[i][j - k]);
                        maxArea = Math.max(maxArea, ++k * minRow);
                    }
                    area[i][j] = Math.max( area[i][j] , maxArea);
                }
            }
        }
        int maxArea = area[0][0];
        for ( int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxArea = Math.max(maxArea, area[i][j]);
            }
        }
        return maxArea;
    }
}
