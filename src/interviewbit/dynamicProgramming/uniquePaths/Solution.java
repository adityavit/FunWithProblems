package interviewbit.dynamicProgramming.uniquePaths;

/**
 * https://leetcode.com/problems/unique-paths/
 * Created by adib on 11/6/16.
 */
public class Solution {
    public int uniquePaths(int rows, int cols) {
        if (rows == 0 || cols == 0) {
            return 0;
        }
        int[][] paths = new int[rows][cols];
        for ( int i = 0; i < rows ; i++) {
            for ( int j = 0; j < cols; j++) {
                if ( i > 0 && j > 0 ) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                } else if ( i > 0 && j == 0) {
                    paths[i][j] = paths[i - 1][j];
                } else if (j > 0 && i == 0) {
                    paths[i][j] = paths[i][j - 1];
                } else {
                    paths[i][j] = 1;
                }
            }
        }
        return paths[rows - 1][cols - 1];
    }
}
