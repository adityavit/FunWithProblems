package interviewbit.backtracking.combinations;

import java.util.ArrayList;

/**
 *
 * https://leetcode.com/problems/combinations/
 * Created by adib on 10/15/16.
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (k == 0 || k > n) {
            return result;
        }
        combineRecursive(n, k , result, new ArrayList<>(), 1);
        return result;
    }

    public void combineRecursive(int n, int k, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> curResult, int start) {
        if (n - start + 1 < k) {
            return;
        }
        if (k == 0) {
            result.add(new ArrayList<>(curResult));
            return;
        }

        for (int i = start; i <= n; i++) {
            curResult.add(i);
            combineRecursive(n, k - 1, result, curResult, i + 1);
            curResult.remove(curResult.size() - 1);
        }
    }
}
