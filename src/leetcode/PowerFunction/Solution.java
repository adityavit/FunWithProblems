package leetcode.PowerFunction;

/**
 * Created by adib on 9/3/16.
 */

/**
 * Use the algorithm over here https://en.wikipedia.org/wiki/Exponentiation_by_squaring
 * https://leetcode.com/problems/powx-n/
 */
public class Solution {
    public double myPow(double x, int n) {
        if ( n == 0)
            return 1;
        if ( n == 1)
            return x;
        return n < 0? 1/myPowRecursive(x, n): myPowRecursive(x, n);
    }

    private double myPowRecursive(double x, int n) {
        if (n == 0)
            return 1;
        double result = myPowRecursive(x, n/2);
        if (n % 2 == 0) {
            //number is even
            return result * result;
        } else {
            return result * result * x;
        }
    }

    /**
     * https://leetcode.com/problems/super-pow/
     * @param a
     * @param b
     * @return
     */
    public int superPow(int a, int[] b) {
        int remainder = divideByTwo(b);
        if (remainder == -1)
            return 1;
        int result = superPow(a, b);
        if (remainder == 0) {
            //number is even
            return ((result % 1337)  * (result % 1337)) % 1337;
        } else {
            return ((result % 1337) * (result % 1337) * (a % 1337)) % 1337;
        }
    }
    /**
     * Divides a number by two given as an array.
     * If the whole array is zero returns -1
     * [1,0] -> [0,5] returns 0
     * @param num
     * @return
     */
    public int divideByTwo(int[] num) {
        int i = 0;
        int len = num.length;
        while (i < len && num[i] == 0) {
            i++;
        }
        if ( i == len ) {
            return -1;
        }
        int carry = 0;
        while ( i < len ) {
            int numi = 10 * carry + num[i];
            num[i] = numi / 2;
            carry = numi % 2;
            i++;
        }
        return carry;
    }
}
