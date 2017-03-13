package interviewbit.arrays.maximumSubArray;

import java.util.List;

/**
 * Created by adib on 10/18/16.
 */
public class Solution {

    /**
     * Here is the same algorithm only thing is that i reassign the sum after assigning maxsum.
     * @param nums
     * @return
     * @accepted
     */
    public int maxSubArray(final List<Integer> nums) {
        if ( nums == null || nums.size() == 0)
            return 0;
        int len = nums.size();
        int maxSum = nums.get(0);
        int sum = 0;
        for (int i = 0; i < len; i++ ) {
            int num = nums.get(i);
            sum = sum + num;
            maxSum = Math.max(maxSum, sum);
            if ( sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    /**
     * This is the first code i wrote. Way to complicated.
     * Although it solves the problem code is way too long.
     * I am first checking when all the numbers are negative.
     * But can be done without specific checking for that if i assign the maxSum before reassigning the sum to 0;
     * @param nums
     * @return
     * @accepted
     */
    public int maxSubArrayTooComplicated(final List<Integer> nums) {
        if ( nums == null || nums.size() == 0)
            return 0;
        int len = nums.size();
        int maxSum = nums.get(0);
        int i = 1;
        for ( i = 1; i < len; i++ ) {
            // If all the numbers are negative return the maximum.
            int num = nums.get(i);
            if ( num >= 0)
                break;
            maxSum = Math.max(maxSum, num);
        }
        if ( i == len)
            return maxSum;

        maxSum = nums.get(0);
        int sum = nums.get(0) < 0? 0 : nums.get(0);
        for ( i = 1; i < len; i++ ) {
            int num = nums.get(i);
            sum = sum + num;
            if ( sum <= 0) {
                sum = 0;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
