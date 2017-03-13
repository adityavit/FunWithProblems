package interviewbit.sqrt;

/**
 * Created by adib on 8/31/16.
 */
public class Solution {
    public int sqrt(int a) {
        long low = 0, high = a;
        long sqrt = 0;
        while(low <= high) {
            long mid = low + (high - low)/2;
            if ( mid * mid == a) {
                return (int) mid;
            }
            if ( mid * mid > a) {
                high = mid - 1;
            } else {
                sqrt = mid;
                low = mid + 1;
            }
        }
        return (int) sqrt;
    }
}

