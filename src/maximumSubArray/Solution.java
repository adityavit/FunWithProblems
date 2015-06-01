package maximumSubArray;

/**
 * Created by adib on 5/31/15.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = 0;
        int subArraySum = 0;
        int maxNegative = Integer.MIN_VALUE;
        for(int i=0; i< nums.length; i++) {
            if(nums[i] >= 0) { //Handling case when all are Negative numbers. Basically put a flag which turns to 0 if there is a non-negative number else keeps on tracking the maximum negative number.
                maxNegative = 0;
            } else if(nums[i] < 0 && maxNegative !=0) {
                maxNegative = Math.max(maxNegative, nums[i]);
            }
            subArraySum = subArraySum + nums[i];
            subArraySum = Math.max(subArraySum, 0);
            maxSum = Math.max(maxSum, subArraySum);
        }
        return (maxNegative != 0) ? maxNegative : maxSum; //if the negative flag is on(all numbers are negative) return maximum negative value else return maxSum.
    }


    public int bruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++ ) {
            for(int j=i; j< nums.length; j++ ) {
                int subArraySum = 0;
                for(int k =i; k<=j; k++) {
                    subArraySum = subArraySum + nums[k];
                }
                maxSum = Math.max(subArraySum, maxSum);
            }
        }
        return maxSum;
    }

    public int quadraticSolution(int[] nums) {
        int maxSum =Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++ ) {
            int subArraySum = 0;
            for(int j=i; j< nums.length; j++ ) {
                subArraySum = subArraySum + nums[j];
                maxSum = Math.max(subArraySum, maxSum);
            }
        }
        return maxSum;
    }
//TODO
//    public int divideAndConquerMethod(int[] nums) {
//
//    }
//
//    public int divideAndConquerHelper(int[] nums, int startIndex, int endIndex) {
//        if(startIndex > endIndex) {
//            return 0;
//        }
//        if(startIndex == endIndex) {
//            return nums[startIndex];
//        }
//
//        int midIndex = ( startIndex + endIndex )/2;
//
//    }
}
