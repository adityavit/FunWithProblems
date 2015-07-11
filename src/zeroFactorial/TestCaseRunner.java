package zeroFactorial;


/**
 * Created by adib on 7/10/15.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int zeroes = sol.trailingZeroes(2147483647);
//        int zeroes = sol.trailingZeroes(100);
        System.out.println("sol = " + zeroes);
    }
}
