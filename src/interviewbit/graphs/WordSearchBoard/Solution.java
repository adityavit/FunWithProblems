package interviewbit.graphs.WordSearchBoard;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/word-search-board/
 * Created by adib on 11/5/16.
 */
public class Solution {
    public int exist(ArrayList<String> grid, String word) {
        if ( grid == null  || grid.size() == 0 ) {
            return 0;
        }
        if ( word == null || word.length() == 0) {
            return 0;
        }
        int rows = grid.size();

        for ( int i = 0; i < rows; i++ ) {
            String row = grid.get(i);
            int rowLen = row.length();
            for ( int j = 0; j < rowLen; j++) {
                boolean existCheck = existDFS(word, 0, i , j, rows, grid);
                if (existCheck)
                    return 1;
            }
        }
        return 0;
    }

    private boolean existDFS(String word, int index, int posI, int posJ, int rows, ArrayList<String> grid) {
        if (posI > rows - 1|| posI < 0)
            return false;
        String rowString = grid.get(posI);
        if ( posJ < 0 || posJ > rowString.length() - 1) {
            return false;
        }

        if (rowString.charAt(posJ) != word.charAt(index)) {
            return false;
        }

        if ( index == word.length() - 1)
            return true;
        boolean up = existDFS(word, index + 1, posI - 1, posJ, rows, grid);
        boolean down = existDFS(word, index + 1, posI + 1, posJ, rows, grid);
        boolean left = existDFS(word, index + 1, posI, posJ - 1, rows, grid);
        boolean right = existDFS(word, index + 1, posI, posJ + 1, rows, grid);
        if (up || down || left || right)
            return true;
        return false;
    }
}
