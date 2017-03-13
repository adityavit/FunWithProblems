package interviewbit.ThreeSumClosest;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/3-sum/
 * Created by adib on 9/11/16.
 */
public class Solution {

    /**
     * @Accepted
     * @param list
     * @param k
     * @return
     */
    public int threeSumClosest(ArrayList<Integer> list, int k) {
        if (list == null || list.size() < 3){
            return 0;
        }
        Collections.sort(list);
        Integer[] sortedArr = list.toArray(new Integer[0]);
        //For each element in sorted list use two pointers to get the minimum difference between k - c , a + b
        int c = 0;
        int len = sortedArr.length;
        int a = 0;
        int b = len - 1;
        int minSum = sortedArr[a+1] + sortedArr[b] + sortedArr[c];
        int minDiff = Math.abs(k - minSum);
        for ( c = 0; c < len - 2; c++ ) {
            int target = k - sortedArr[c];
            a = c + 1;
            b = len - 1;
            while (a < b) {
                int twoSum = sortedArr[a] + sortedArr[b];
                int diff = Math.abs(k - (twoSum + sortedArr[c]));
                if ( diff == 0) {
                    return sortedArr[a] + sortedArr[b] + sortedArr[c];
                }
                if ( diff < minDiff ) {
                    minDiff = diff;
                    minSum = sortedArr[a] + sortedArr[b] + sortedArr[c];
                }
                if (twoSum > target) {
                    b--;
                } else {
                    a++;
                }
            }
        }
        return minSum;
    }

    /**
     * This solution works, and is the most efficient solution of O(n^2), brute force is O(n^3).
     * Although the code can be cleaned further. For example a can start from c + 1 rather than always starting from 0
     * C can go till length - 3 because the length - 2 one would be a and length - 1 would be b so c loop will be c < length - 2 or c <= length - 3
     * If you think about it C is smallest element and A and B are after that. If you do this you can remove the two continue conditions.
     * @param list
     * @param k
     * @return
     */
    public int threeSumClosestFirst(ArrayList<Integer> list, int k) {
        if (list == null || list.size() < 3){
            return 0;
        }
        Collections.sort(list);
        Integer[] sortedArr = list.toArray(new Integer[0]);
        //For each element in sorted list use two pointers to get the minimum difference between k - c , a + b
        int c = 0;
        int len = sortedArr.length;
        int a = 0;
        int b = len - 1;
        int minSum = sortedArr[a+1] + sortedArr[b] + sortedArr[c];
        int minDiff = Math.abs(k - minSum);
        for ( c = 0; c < len; c++ ) {
            int target = k - sortedArr[c];
            a = 0;
            b = len - 1;
            while (a < b) {
                if ( a == c ){
                    a++;
                    continue;
                }
                if ( b == c) {
                    b--;
                    continue;
                }
                int twoSum = sortedArr[a] + sortedArr[b];
                int diff = Math.abs(k - (twoSum + sortedArr[c]));
                if ( diff == 0) {
                    return sortedArr[a] + sortedArr[b] + sortedArr[c];
                }
                if ( diff < minDiff ) {
                    minDiff = diff;
                    minSum = sortedArr[a] + sortedArr[b] + sortedArr[c];
                }
                if (twoSum > target) {
                    b--;
                } else {
                    a++;
                }
            }
        }
        return minSum;
    }
}
