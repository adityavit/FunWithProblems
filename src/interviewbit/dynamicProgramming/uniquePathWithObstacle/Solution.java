package interviewbit.dynamicProgramming.uniquePathWithObstacle;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 * Created by adib on 11/6/16.
 */
public class Solution {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> grid) {
        if ( grid == null || grid.size() == 0 ) {
            return 0;
        }
        int rows = grid.size();
        int cols = grid.get(0).size();
        int[][] paths = new int[rows][cols];
        for ( int i = 0; i < rows ; i++) {
            for ( int j = 0; j < cols; j++) {
                if (grid.get(i).get(j) == 1) {
                    paths[i][j] = 0;
                    continue;
                }
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

    public int uniquePathsWithObstacles(int[][] grid) {
        if ( grid == null || grid.length == 0 ) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] paths = new int[rows][cols];
        for ( int i = 0; i < rows ; i++) {
            for ( int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    paths[i][j] = 0;
                    continue;
                }
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
