package interviewbit.dynamicProgramming.jumpGameArray;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/jump-game/
 * https://www.interviewbit.com/problems/jump-game-array/
 * https://leetcode.com/articles/jump-game/
 * Created by adib on 11/1/16.
 */
public class Solution {
    public int canJump(ArrayList<Integer> nums) {
        if (nums.size() == 0)
            return 1;
        int len = nums.size();
        int i = len - 1;
        while ( i > 0 ) {
            int lastIndex = i - 1;
            while (nums.get(lastIndex) < i - lastIndex) {
                lastIndex--;
                if (lastIndex < 0)
                    return 0;
            }
            i = lastIndex;
        }
        return 1;
    }
}
