package leetcode.maximumSubArray;

/**
 * Created by adib on 8/15/16.
 */
public class TestCaseRunner {

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] testCase1 = {-2, 1 , -3, 4, -1, 2, 1, -5, 4};
        int[] testCase2 = {-2, -1 , -3,- 4, -1, -2, -1, -5, -4};
        int[] testCase3 = {1, 2, 3};
        int[] testCase4 = {};
        int[] testCase5 = {1};
        System.out.println(sol.maxSubArray(testCase1));
        System.out.println(sol.maxSubArray(testCase2));
        System.out.println(sol.maxSubArray(testCase3));
        System.out.println(sol.maxSubArray(testCase4));
        System.out.println(sol.maxSubArray(testCase5));
    }
}
