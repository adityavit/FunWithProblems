package interviewbit.backtracking.permutations;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/permutations/
 * https://leetcode.com/problems/permutations/
 * Created by adib on 10/16/16.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if ( nums == null || nums.size() == 0)
            return result;
        Collections.sort(nums);
        permuteRecursive(nums, result, new ArrayList<>());
        return result;
    }

    public void permuteRecursive(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentList) {
        if (currentList.size() > nums.size()) {
            return;
        }
        if (currentList.size() == nums.size()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for ( int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            if (num == null)
                continue;
            nums.set(i, null);
            currentList.add(num);
            permuteRecursive(nums, result, currentList);
            currentList.remove(currentList.size() - 1);
            nums.set(i, num);
        }
    }
}
