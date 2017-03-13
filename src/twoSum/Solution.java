package twoSum;

import java.util.*;

import java.util.HashMap;
public class Solution {
    /**
     * https://leetcode.com/problems/two-sum/
     * This is an easy type in the case of leetcode.
     * The same problem is in interviewbit, and doesn't have a the constraint that there is a unique solution.
     * Look at the interview bit problem too, although the logic is the same.
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> tempStore = new HashMap();
        for(int i = 0; i< nums.length; i++){
            tempStore.put(nums[i], i);
        }
        for(int i = 0; i < nums.length ; i++) {
            int diff = target - nums[i];
            Integer diffIndex = tempStore.get(diff);
            if(diffIndex != null && diffIndex > i) {
                 ret[0] = i;
                 ret[1] = diffIndex;

            }
        }
        return ret;
    }
}