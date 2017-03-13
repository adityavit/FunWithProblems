package largestContinousSequenceZeroSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/
 * Created by adib on 9/25/16.
 */
public class Solution {

    /**
     * https://discuss.leetcode.com/topic/25465/longest-continous-zero-sum-subarray/5
     * O(n) solution to the above problem.
     * I looked for the solution for this problem. Got hint from the above link.
     * Idea works in the problem. Firstly create an array with the increasing sum of the elems.
     * Then basically you want to get two i, j such that Sum[i,j] = sum[j] - sum[i-1] i > 0 or Sum[i,j] = sum[j] when i == 0,
     * And we check then for all i,j all the sum[i,j] = 0. This works well, but the solution is still O(n^2) complexity.
     * To make it O(n) is slightly clever as in if sum[i,j] == 0 then either sum[j] == sum[i-1] or sum[j] == 0 and we achieve this by a hashmap.
     * Where we check for all the duplicate and zero values in the array. For the first time we store the index i - 1 in the array, if we see a duplicate sum.
     * we know the j value and so we calculate the length as j - i + 1 and compare it with max length.
     * @param a
     * @return
     */
    public ArrayList<Integer> lszero(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) {
            return a;
        }
        int len = a.size();
        int[] sums = new int[len];
        int maxLen = 0;
        int maxStart = -1;
        int maxEnd = -1;
        Map<Integer, Integer> sameSums = new HashMap<>();
        for(int i = 0; i < len; i++) {
            if ( i == 0) {
                sums[i] = a.get(i);
            } else {
                sums[i] = a.get(i) + sums[i - 1];
            }
        }
        for(int i = 0; i < len; i++) {
            if (sameSums.containsKey(sums[i]) || sums[i] == 0) {
                int start = (sums[i] == 0)?0: sameSums.get(sums[i]) + 1;
                int end = i;
                int sequenceLen =  end - start + 1;
                if ( sequenceLen > maxLen) {
                    maxStart = (sums[i] == 0) ?0:start;
                    maxEnd = end;
                    maxLen = sequenceLen;
                }
            } else {
                sameSums.put(sums[i], i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (maxLen > 0) {
            for(int i = maxStart; i <= maxEnd; i++) {
                result.add(a.get(i));
            }
        }
        return result;
    }


    /**
     * This is a O(n^2) solution, although the solution is correct, but it doesn't pass the time restriction.
     * In this approach we are trying to find the sum of every sub sequence. If the sum is zero, we mark it as the maximum if it's length is greater than max.
     * Think of the iteration as filling the upper part of the rectangle. The upper part of the rectangle does represent all the sequences of the array.
     * Example.
     *    1  2  -2  -1
     * 1  1  3  -1  0
     * 2     2  0  -1
     * -2       -2 -3
     * -1          -1
     * @param a
     * @return
     */
    public ArrayList<Integer> lszeroN2(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) {
            return a;
        }
        int len = a.size();
        Integer[] elems = a.toArray(new Integer[0]);
        int maxSize = 0;
        int maxStart = -1;
        int maxEnd = -1;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for(int j = i; j < len; j++) {
                sum += elems[j];
                if ( sum == 0 && j - i + 1 > maxSize) {
                    maxSize = j - i + 1;
                    maxStart = i;
                    maxEnd = j;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if ( maxSize > 0 ) {
            for (int i = maxStart; i <= maxEnd; i++) {
                result.add(elems[i]);
            }
        }
        return result;
    }
}
