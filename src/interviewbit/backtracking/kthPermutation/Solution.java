package interviewbit.backtracking.kthPermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/kth-permutation-sequence/
 * https://leetcode.com/problems/permutation-sequence/
 * Created by adib on 10/17/16.
 *
 * time : O(n^2) can't find a better way to do this.
 */
public class Solution {

    /**
     * This problem passed in leetcode but failed in interview bit in the complexity.
     * Some of the optimization. Factorial doesn't need to be generated all the time.
     *
     * Getting error when i use n as 50 and k as 200 on interview bit.
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while ( sb.length() != n) {
            int numIndex = getIndex(k - 1, nums.size() - 1);
            sb.append(nums.get(numIndex));
            k = numIndex == 0 ? k : k - numIndex * factorial(nums.size() - 1);
            nums.remove(numIndex);
        }
        return sb.toString();
    }

    public int getIndex(int value, int n) {
        while ( n > 0 && value > 0) {
            value = value/n;
            n--;
        }
        return value;
    }

    public int factorial(int value) {
        int result = 1;
        while ( value > 0) {
            result *= value;
            value--;
        }
        return result;
    }

    /**
     * This solution exceeded the time as it is iterating over all the solutions, to find the solution which we need.
     * Better would be to directly find the solution.
     * @param n
     * @param k
     * @return
     */
    public String getPermutationFailed(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for ( int i = 1; i <= n; i++) {
            nums.add(i);
        }
        Integer[] permutationNum = new Integer[1];
        permutationNum[0] = 0;
        List<String> result = new ArrayList<>();
        getPermutationRecursion(nums, result, new StringBuilder(), k, permutationNum);
        return result.get(0);
    }

    public void getPermutationRecursion(List<Integer> nums , List<String> result, StringBuilder sb, int k, Integer[] permutationNum) {
        if (sb.length() > nums.size())
            return;
        if (sb.length() == nums.size()) {
            permutationNum[0]++;
            if (permutationNum[0] == k) {
                result.add(sb.toString());
            }
            return;
        }

        for ( int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            if (num == null)
                continue;
            int startI = sb.length();
            sb.append(num);
            nums.set(i, null);
            getPermutationRecursion(nums, result, sb, k, permutationNum);
            if ( result.size() > 0) {
                return;
            }
            sb.delete(startI, sb.length());
            nums.set(i, num);
        }
    }
}
