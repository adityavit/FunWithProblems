package interviewbit.arrays.repeatAndMissingNumber;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Created by adib on 10/18/16.
 */
public class Solution {

    /**
     * Here to reduce the memory i have used bitset rather than using set.
     * Memory calculation.
     * every number in nums in bitset will take 1 bit rather than 4 bytes in a Set.
     * 1,000,000 numbers will take 1,000,000 bits which is equivalent to lets say 2^20(1048576) / 2^3 (8) == 2^17 bytes (131072) == 131 kb
     * If we have used Set with integer in it, would have been 4 MB of space.
     *
     *
     * Another way of solving it without using set or any memory is using another equation of squares.
     * 1^2 + 2 ^ 2 .... n^2 = n * ( n + 1) * (2*n + 1) / 6
     * @param nums
     * @return
     */
    public ArrayList<Integer> repeatedNumber(final List<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>();
        if ( nums == null || nums.size() == 0) {
            return result;
        }
        long len = nums.size();
        BitSet seen = new BitSet((int)(len + 1));
        long sum = 0;
        long aNum = 0;
        for ( int i = 0; i < len; i++) {
            long num = nums.get(i);
            sum += num;
            if (seen.get((int)num)) {
                aNum = num;
            }
            seen.set((int)num);
        }
        long sumOfN = len * ( len + 1) / 2;
        long bNum = sumOfN + aNum - sum;
        result.add((int)aNum);
        result.add((int)bNum);
        return result;
    }
}
