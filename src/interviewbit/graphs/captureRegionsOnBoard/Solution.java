package interviewbit.graphs.captureRegionsOnBoard;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/capture-regions-on-board/
 * https://leetcode.com/problems/surrounded-regions/
 * Goes stack over flow on leetcode.
 *
 * Have to look in the two pass connected component algorigthm or BFS using flood fill algorithm.
 * Created by adib on 11/5/16.
 */
public class Solution {
    public void solve(ArrayList<ArrayList<Character>> board) {
        if ( board == null ) {
            return;
        }
        int rows = board.size();
        int cols = board.get(0).size();
        for ( int i = 0; i < rows; i++) {
            for ( int j = 0; j < cols; j++) {
                char ch = board.get(i).get(j);
                if (ch == 'O') {
                    boolean validToSet = checkDFS(i, j, rows, cols, board);
                    if (validToSet) {
                        markDFS(i, j, rows, cols, board);
                    }
                }
                ch = board.get(i).get(j);
                if (ch == 'Y') {
                    board.get(i).set(j, 'O');
                }
            }
        }
    }

    private boolean checkDFS(int posI, int posJ, int rows, int cols, ArrayList<ArrayList<Character>> board) {
        if (posI < 0 || posJ < 0) {
            return false;
        }
        if (posI > rows - 1 || posJ > cols - 1) {
            return false;
        }
        if (board.get(posI).get(posJ) == 'X' || board.get(posI).get(posJ) == 'Y') {
            return true;
        }
        //Mark the position visited.
        board.get(posI).set(posJ, 'Y');
        boolean up = checkDFS(posI - 1, posJ, rows, cols, board);
        boolean left = checkDFS(posI, posJ - 1, rows, cols, board);
        boolean right = checkDFS(posI, posJ + 1, rows, cols, board);
        boolean down = checkDFS(posI + 1, posJ, rows, cols, board);
        if (up && left && right && down) {
            return true;
        }
        return false;
    }

    private void markDFS(int posI, int posJ, int rows, int cols, ArrayList<ArrayList<Character>> board) {
        if (posI < 0 || posJ < 0) {
            return;
        }
        if (posI > rows - 1 || posJ > cols - 1) {
            return;
        }
        if (board.get(posI).get(posJ) == 'X') {
            return;
        }
        //Mark the position visited.
        board.get(posI).set(posJ, 'X');
        markDFS(posI - 1, posJ, rows, cols, board);
        markDFS(posI, posJ - 1, rows, cols, board);
        markDFS(posI, posJ + 1, rows, cols, board);
        markDFS(posI + 1, posJ, rows, cols, board);
    }
}
