package interviewbit.dynamicProgramming.stairs;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * https://www.interviewbit.com/problems/stairs/
 *
 * So this problem is nothing but fibonacci series in disguise.
 * A person can go to the ith stair from i - 1 stair taking a 1 step
 * or go from i - 2 stair taking a 2 step.
 * The Decode ways is also the same problem, just that it has some solutions which shouldn't be considered.
 * Created by adib on 10/31/16.
 */
public class Solution {
    public int climbStairs(int stairs) {
        if (stairs == 0 || stairs == 1)
            return 1;
        int lastSolution = 1;
        int solution = 1;
        for ( int i = 2; i <= stairs; i++) {
            int temp = solution;
            solution = solution + lastSolution;
            lastSolution = temp;
        }
        return solution;
    }
}
