package interviewbit.dynamicProgramming.longestIncreasingSubsequence;

import java.util.List;

/**
 * Longest Increasing subsequence.
 * Without DP this problem is O(2^n) as every number can be either in the sequence or not present in the sub-sequence.
 * This gives an exponential solution. But in the brute force solution we can memoize.
 *
 * So for the brute we will add the number in the sub sequence if the last number we added is smaller than the number we are about to add.
 * So in that case there can be many numbers before the number we are about to add which are smaller than the current number.
 * So we can just take maximum subsequence of all those numbers + 1 will become the subsequence for the current number.
 * So the recurrence can be given as.
 *
 * lis(i) = Max(lis(k)) + 1 for all k < i and nums[k] < nums[i]
 *
 * This is decent problem, Not that hard, i solved the O(n^2) solution myself.
 * Created by adib on 11/2/16.
 */
public class Solution {
    public int lis(final List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int len = nums.size();
        int[] lisVal = new int[len];
        lisVal[0] = 1;
        for ( int i = 1; i < len; i++) {
            int max = 1;
            for ( int j = i - 1; j >= 0; j--) {
                if ( nums.get(i) > nums.get(j) ) {
                    max = Math.max(max, lisVal[j] + 1);
                }
            }
            lisVal[i] = max;
        }
        int max = 1;
        for ( int i = 0; i < len; i++) {
            max = Math.max(max, lisVal[i]);
        }
        return max;
    }
}
