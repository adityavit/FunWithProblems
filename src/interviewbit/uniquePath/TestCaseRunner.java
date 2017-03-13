package interviewbit.uniquePath;

/**
 * Created by adib on 8/28/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.uniquePaths(100, 1));
        stackOverFlow(21000);
    }

    private static void stackOverFlow(int n) {
        if ( n == 1) {
            return;
        }
        stackOverFlow(n-1);
    }
}
