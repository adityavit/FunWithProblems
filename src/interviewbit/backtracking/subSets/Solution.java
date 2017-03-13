package interviewbit.backtracking.subSets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by adib on 10/15/16.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null || nums.size() == 0) {
            return result;
        }
        Collections.sort(nums);
        subsetsRecursive(result, new ArrayList<>(), nums, 0, nums.size());
        return result;
    }

    public void subsetsRecursive(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentList, ArrayList<Integer> nums, int start, int end) {
        if (start == end) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = start; i < end; i++) {
            currentList.add(nums.get(i));
            int len = currentList.size();
            subsetsRecursive(result, currentList, nums, i , i);
            if (end - i > 1) {
                subsetsRecursive(result, currentList, nums, i + 1, end);
            }
            currentList.remove(len - 1);
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return result;
        }
//        Arrays.sort(nums);
        subsetsRecursive(result, new ArrayList<>(), nums, 0, nums.length);
        return result;
    }

    public void subsetsRecursive(List<List<Integer>> result, ArrayList<Integer> currentList, int[] nums, int start, int end) {
        if (start == end) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = start; i < end; i++) {
            currentList.add(nums[i]);
            int len = currentList.size();
            subsetsRecursive(result, currentList, nums, i , i);
            if (end - i > 1) {
                subsetsRecursive(result, currentList, nums, i + 1, end);
            }
            currentList.remove(len - 1);
        }
    }
}
