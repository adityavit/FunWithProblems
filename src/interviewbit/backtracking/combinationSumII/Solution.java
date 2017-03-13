package interviewbit.backtracking.combinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/combination-sum-ii/
 *
 * Created by adib on 10/16/16.
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (sum == 0) {
            return result;
        }
        Arrays.sort(nums);
        combinationSumRecursive(nums, sum, result, new ArrayList<>(), 0);
        return result;
    }

    public void combinationSumRecursive(int[] nums, int sum, List<List<Integer>> result, ArrayList<Integer> curResult, int startI) {
        if ( startI > nums.length || sum < 0 ) {
            return;
        }
        if ( sum == 0 ) {
            result.add(new ArrayList<>(curResult));
            return;
        }
        for (int i = startI; i < nums.length; i++) {
            int num = nums[i];
            if (i > 0 && i != startI && num == nums[i - 1])
                continue;
            curResult.add(num);
            combinationSumRecursive(nums, sum - num, result, curResult, i + 1);
            curResult.remove(curResult.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> nums, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum == 0) {
            return result;
        }
        Collections.sort(nums);
        combinationSumRecursive(nums, sum, result, new ArrayList<>(), 0);
        return result;
    }

    public void combinationSumRecursive(ArrayList<Integer> nums, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> curResult, int startI) {
        if ( startI > nums.size() || sum < 0 ) {
            return;
        }
        if ( sum == 0 ) {
            result.add(new ArrayList<>(curResult));
            return;
        }
        for (int i = startI; i < nums.size(); i++) {
            int num = nums.get(i);
            if (i > 0 && i != startI && num == nums.get(i - 1))
                continue;
            curResult.add(num);
            combinationSumRecursive(nums, sum - num, result, curResult, i + 1);
            curResult.remove(curResult.size() - 1);
        }
    }
}
