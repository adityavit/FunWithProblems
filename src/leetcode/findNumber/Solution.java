package leetcode.findNumber;

/**
 * Created by adib on 8/14/16.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int residual = 0;
        for(int i = 0; i < nums.length ; i++) {
            residual ^= nums[i];
        }
        return residual;
    }
}
