package interviewbit.backtracking.subSetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/subsets-ii/
 * https://leetcode.com/problems/subsets-ii/
 * Created by adib on 10/16/16.
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if ( nums == null) {
            return result;
        }
        Arrays.sort(nums);
        subsetsWithDupRecursive(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void subsetsWithDupRecursive(int[] nums, List<List<Integer>> result, ArrayList<Integer> curResult, int startI) {
        result.add(new ArrayList<>(curResult));

        if ( startI >= nums.length)
            return;

        for ( int i = startI; i < nums.length; i++) {
            int num = nums[i];

            //check if the current element is the same as the previous one.
            // Also apply this condition only when we are iterating over the elements rather than at the start of the new recursive call.
            if (i > 0 && i != startI && num == nums[i -1])
                continue;
            curResult.add(num);
            subsetsWithDupRecursive(nums, result, curResult, i + 1);
            curResult.remove(curResult.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if ( nums == null) {
            return result;
        }
        Collections.sort(nums);
        subsetsWithDupRecursive(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void subsetsWithDupRecursive(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> curResult, int startI) {
        result.add(new ArrayList<>(curResult));

        if ( startI >= nums.size())
            return;

        for ( int i = startI; i < nums.size(); i++) {
            int num = nums.get(i);

            //check if the current element is the same as the previous one.
            // Also apply this condition only when we are iterating over the elements rather than at the start of the new recursive call.
            if (i > 0 && i != startI && num == nums.get(i -1))
                continue;
            curResult.add(num);
            subsetsWithDupRecursive(nums, result, curResult, i + 1);
            curResult.remove(curResult.size() - 1);
        }
    }
}
