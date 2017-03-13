package interviewbit.arrays.spiralOrderMatrixII;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/spiral-order-matrix-ii/
 * Created by adib on 10/22/16.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (num == 0) {
            return result;
        }
        int[][] resultArr = new int[num][num];
        int startElem = 1;
        int startI = 0;
        for (int i = num; i > 0; i = i - 2) {
            int endElem = startElem + elemOnOutsideBorder(i);
            fillOutRectange(resultArr, startI, i, startElem, endElem - 1);
            startI++;
            startElem = endElem;
        }
        for ( int i = 0; i < num; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                rowList.add(resultArr[i][j]);
            }
            result.add(rowList);
        }
        return result;

    }

    private int elemOnOutsideBorder(int n) {
        if (n == 1) {
            return 1;
        }
        return 2 * n + 2 * (n - 2);
    }

    private void fillOutRectange(int[][] result, int startI, int size, int startElem, int endElem) {
        for (int i = startI; i < startI + size; i++) {
            if ( i == startI) {
                // It is the first row
                for (int j = startI; j < startI + size; j++) {
                    result[i][j] = startElem++;
                }
            }

            if ( i != startI && i == startI + size - 1) {
                // It is the last row
                for (int j = startI + size - 1; j >= startI; j--) {
                    result[i][j] = startElem++;
                }
            }

            if ( i != startI && i != startI + size - 1) {
                // Niether the first or the last row
                result[i][startI] = endElem--;
                result[i][startI + size - 1] = startElem++;
            }
        }
    }
}
