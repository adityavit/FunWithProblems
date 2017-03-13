package leetcode.findNumber;

/**
 * Created by adib on 8/14/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] testCase1 = {1, 2, 3, 2, 1, 5, 4, 5, 4};
        int singleNum = sol.singleNumber(testCase1);
        assert singleNum == 3;
        System.out.println(singleNum);
    }
}
