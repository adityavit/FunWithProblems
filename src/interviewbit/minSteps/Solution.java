package interviewbit.minSteps;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 * Created by adib on 8/16/16.
 * The two points would be separated with each other in minimum on a diagonal.
 *
 */
public class Solution {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        if (X == null || Y == null || X.size() == 0 || Y.size() == 0) {
            return 0;
        }
        int startX = X.get(0);
        int startY = Y.get(0);
        int minDistance = 0;
        for(int i = 1; i < X.size(); i++) {
            int distance = Math.max(Math.abs(startX - X.get(i)), Math.abs(startY - Y.get(i)));
            minDistance += distance;
            startX = X.get(i);
            startY = Y.get(i);
        }
        return minDistance;
    }
}
