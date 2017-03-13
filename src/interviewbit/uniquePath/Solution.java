package interviewbit.uniquePath;

/**
 * Created by adib on 8/28/16.
 */
public class Solution {
    public int uniquePaths(int a, int b) {
        //solving equation (a + b - 2)!/ ((a -1)! * (b - 1)!)
//          return (int) factorial(5);
        int largerNumber = a > b ? a - 1 : b - 1;
        int smallerNumber = a < b ? a - 1 : b - 1;
        double numerator = factorial(a + b - 2, largerNumber);
        double factorialSmaller = factorial(smallerNumber , 1);
        return (int) (numerator/factorialSmaller);
    }

    private double factorial(int m, int n) {
        double factorial = 1L;
        while ( m>n) {
            factorial *= m;
            m--;
        }
        return factorial;
    }
}

