package interviewbit.dynamicProgramming.minJumpGame;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/min-jumps-array/
 * https://leetcode.com/problems/jump-game-ii/
 * Created by adib on 11/1/16.
 */
public class Solution {

    /**
     * This solution passed in interviewbit but failed on leetcode as time limit exceeded.
     * time complexity: O(n^2)
     * space Complexity: O(1)
     * It takes O(n^2) complexity is the worst case as it looking for the left most index from where we can reach to the indexForJump.
     * So in the worst case it will scan all the left most values for each index.
     * There is a O(n) algorithm if you start from the left rather than the right.
     * @param nums
     * @return
     */
    public int jump(ArrayList<Integer> nums) {
        if (nums.size() == 0)
            return 0;

        int len = nums.size();
        int indexForJump = len - 1;
        int jumps = 0;
        while ( indexForJump > 0) {
            int lastJumpIndex = -1;
            for ( int i = 1; i <= indexForJump; i++ ) {
                int jumpSize = nums.get(indexForJump - i);
                if (jumpSize >= i) {
                    lastJumpIndex = indexForJump - i;
                }
            }
            if ( lastJumpIndex < 0) {
                return -1;
            }
            jumps++;
            indexForJump = lastJumpIndex;
        }
        return jumps;
    }
}
