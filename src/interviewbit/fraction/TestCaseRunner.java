package interviewbit.fraction;

/**
 * Created by adib on 9/29/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.fractionToDecimal(-1, 2));
        System.out.println(sol.fractionToDecimal(Integer.MIN_VALUE, -1));
        System.out.println(sol.fractionToDecimal(10, 7));
        System.out.println(sol.fractionToDecimal(87, 22));
    }
}
