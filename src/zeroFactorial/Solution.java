package zeroFactorial;

/**
 * Created by adib on 7/10/15.
 */
public class Solution {
    public int trailingZeroes(int n) {
        int trailingZeroes = 0;
        long startFactor = 5;
        int step = 1;
        while(startFactor <= n) {
            System.out.println("step" + step);
            trailingZeroes += n/startFactor;
            startFactor = startFactor * 5;
            System.out.println("startFactor = " + startFactor);
            step++;
        }
        return trailingZeroes;
    }
}
