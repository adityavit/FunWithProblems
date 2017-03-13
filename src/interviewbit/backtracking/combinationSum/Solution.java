package interviewbit.backtracking.combinationSum;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/combination-sum/
 * https://leetcode.com/problems/combination-sum/
 * Time: exponential, as there will be exponential unique solutions.
 * Created by adib on 10/15/16.
 * @accepted
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> nums, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(nums);
        combinationSumRecursive(nums, sum, result, new ArrayList<>(), 0);
        return result;
    }

    public void combinationSumRecursive(ArrayList<Integer> nums, int sum, ArrayList<ArrayList<Integer>>result, ArrayList<Integer> curResult, int startI) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {
            result.add(new ArrayList<>(curResult));
            return;
        }
        for (int i = startI; i < nums.size(); i++) {
            int num = nums.get(i);
            if ( i > 0 && num == nums.get(i - 1)) {
                //skip the numbers which are same.
                continue;
            }
            curResult.add(num);
            combinationSumRecursive(nums, sum - num, result, curResult, i);
            curResult.remove(curResult.size() - 1);
        }
    }
}
