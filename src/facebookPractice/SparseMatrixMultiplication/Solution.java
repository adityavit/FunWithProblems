package facebookPractice.SparseMatrixMultiplication;

/**
 * https://leetcode.com/problems/sparse-matrix-multiplication/
 * Created by adib on 11/12/16.
 * @accepted
 */
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null)
            return null;
        int aRows = A.length;
        int aCols = A[0].length;
        int bRows = B.length;
        int bCols = B[0].length;
        int[][] result = new int[aRows][bCols];
        for ( int i = 0; i < aRows; i++) {
            for ( int j = 0; j < aCols; j++) {
                if (A[i][j] != 0) {
                    for ( int k = 0; k < bCols; k++) {
                        result[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return result;
    }
}
