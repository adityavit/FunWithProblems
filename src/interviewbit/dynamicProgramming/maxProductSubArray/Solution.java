package interviewbit.dynamicProgramming.maxProductSubArray;

import java.util.List;

/**
 * https://www.interviewbit.com/problems/max-product-subarray/
 * Created by adib on 10/23/16.
 */
public class Solution {

    /**
     * Taken from this solution.
     * https://discuss.leetcode.com/topic/3607/sharing-my-solution-o-1-space-o-n-running-time
     * This problem is slightly tricky then i thought.
     * The idea is to maintain the maximum and the minimum product when you are going over the elements in the array.
     * Why we need to get the minimum and the maximum at an index i in the array.
     * So the idea is based on the maximum sub array problem, I approached the problem also in that manner, but didn't work because i was not maintaining the minimum.
     * So when a negative number comes in the array it doesn't effect the maximum product, but the product of it with the rest of the product is stored in the minimum.
     * So when again a negative number comes then the maxproduct is calculated using the minimum result.
     *  So for the case -2, -3 , -3 where my solution was failing.
     *  at i = 1 maxSoFar initial comes out to be 6 and the minimum comes out to be -3
     *  at i = 2 maxSofar comes out to be max of -18, 9 , -3 which is 9 which is the greatest maximum.
     *
     *  So the point is
     *  newMax = max(max*a[i], min*a[i], a[i])
     *  newMin = min(max*a[i], min*a[i], a[i])
     *
     * @param nums
     * @return
     * @accepted
     */
    public int maxProduct(final List<Integer> nums) {
        int maxEndingHere = nums.get(0);
        int minEndingHere = nums.get(0);
        int maxSoFar = nums.get(0);
        int i = 1;
        int len = nums.size();
        int maxEndingHereTemp, minEndingHereTemp;
        while (i < len) {
            int num = nums.get(i);
            //Get the maximum which ends here.
            // If the number is positive as previous maxEndingHere was positive then this will increase.
            // If the number is negative but the previous minEndingHere was negative then again it will increase.
            // If the number was positive but maxEndingHere is negative or number is positive minEndingHere is negative then take the number.
            maxEndingHereTemp = Math.max(Math.max(maxEndingHere * num, minEndingHere * num), num);
            minEndingHereTemp = Math.min(Math.min(maxEndingHere * num, minEndingHere * num), num);
            maxSoFar = Math.max(maxEndingHereTemp, maxSoFar);
            i++;
            maxEndingHere = maxEndingHereTemp;
            minEndingHere = minEndingHereTemp;
        }
        return maxSoFar;
    }

    /**
     * This solution to the problem is wrong.
     * @param nums
     * @return
     * @failed
     */
    public int maxProductWrong(final List<Integer> nums) {
        if ( nums.size() == 1 ) {
            return nums.get(0);
        }
        int maxProduct = nums.get(0);
        int len = nums.size();
        int product = maxProduct == 0? 1 : maxProduct;
        int i = 1;
        int lastNegativeProduct = product < 0? product: 1;
        while ( i < len) {
            int num = nums.get(i);
            product *= num;
            if ( product > 0 && lastNegativeProduct < 0) {
                //If the prodcut becomes positve again.
                lastNegativeProduct = 1;
            }
            maxProduct = Math.max(maxProduct, product/lastNegativeProduct);
            if (product < 0 && lastNegativeProduct > 0) {
                // If product becomes negative assign the last negative product.
                // If the lastNegativeProduct has not been assigned.
                lastNegativeProduct = product;
            }
            if ( product == 0 ) {
                product = 1;
                lastNegativeProduct = 1;
            }
            i++;
        }
        return maxProduct;
    }
}
