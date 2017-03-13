package interviewbit.ContainerWithMostWater;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/container-with-most-water/
 * https://leetcode.com/problems/container-with-most-water/
 * Created by adib on 9/14/16.
 * Thought about this problem quite a bit. The thing which struck me to solve the problem was this property
 * From elements a1 to aN if a1 is smaller than aN then maximum area a1 can make is a1 * (N - 1) as N - 1 is maximum distance.
 * So once we get it's area and compare it with max we can move further if a1 is smaller else move aN if an is smaller.
 * We move the smaller one because the larger one can still get more area from some point further.
 *
 * https://leetcode.com/articles/container-most-water/
 * @accepted
 */
public class Solution {
    public int maxArea(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) {
            return 0;
        }
        int first = 0;
        int last = a.size() - 1;
        int maxArea = 0;
        while ( first < last) {
            int firstVal = a.get(first);
            int lastVal = a.get(last);
            int area = (last - first) * Math.min(firstVal, lastVal);
            if ( area > maxArea) {
                maxArea = area;
            }
            if ( firstVal < lastVal) {
                first++;
            } else {
                last--;
            }
        }
        return maxArea;
    }
}
