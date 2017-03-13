package leetcode.maximumSubArray;

/**
 * Created by adib on 8/15/16.
 */
public class Solution {

    public int maxSubArray(int[] a){
        int sum =0 ;
        int max = Integer.MIN_VALUE;
        int i = 0, j= 0;
        while (i < a.length) {
            if (a[i] > max) {
                max = a[i];
            }
            i++;
        }
        if ( max < 0)
            return max;
        while(j < a.length) {
            sum += a[j];
            if(sum > 0) {
                j++;
                if (sum > max) {
                    max = sum;
                }
            }else {
                    if (sum - a[j] > max) {
                        max = sum - a[j];
                    }
                    j++;
                    sum = 0;
                }
            }
        return max;
    }

}
