package interviewbit.arrays.maxNonNegativeNumberSubArray;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/max-non-negative-subarray/
 * time: O(n)
 * space: O(1)
 * Take care of the overflow when the numbers in the nums is big and their sum can overflow.
 * Created by adib on 10/22/16.
 * @accepted
 */
public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>();
        if ( nums == null || nums.size() == 0 )
            return nums;

        int maxStartI = -1;
        int maxEndI = -1;
        long maxSum = 0;
        int startI = -1;
        int endI = -1;
        long sum = 0;
        int len = nums.size();
        int i = 0;
        while ( i < len ) {
            int num = nums.get(i);
            if ( num < 0) {
                sum = 0;
                startI = -1;
                endI = -1;
                i++;
                continue;
            }
            if ( startI < 0) {
                startI = i;
                endI = i + 1;
            } else {
                endI = i + 1;
            }
            sum += num;
            if( sum > maxSum || (sum == maxSum && endI - startI > maxEndI - maxStartI)) {
                maxSum = sum;
                maxStartI = startI;
                maxEndI = endI;
            }
            i++;
        }
        for (int j = maxStartI; j < maxEndI; j++) {
            result.add(nums.get(j));
        }
        return result;
    }
}
