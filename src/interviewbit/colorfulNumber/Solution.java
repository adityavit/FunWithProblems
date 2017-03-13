package interviewbit.colorfulNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.interviewbit.com/problems/colorful-number/
 * Took more time because i was thinking whether this can be done in O(n) time. But O(n^2) is the best algorithm, as the number of sub sets will be O(n^2)
 * Also was thinking if we can do without splitting out the digits. Cannot be done without separating the digits.
 * Have used a double dimension array to store the products but this can be done without it.
 * If done in an improper way can go n^3, here the approach uses a similar approach to DP.
 * number 3245 will broken as array 5 4 2 3 which would be used to create a matrix.
 *   5   4  2  3
 * 5 5
 * 4 20  4
 * 2 40  8  2
 * 3 120 24 6  3
 * Created by adib on 9/24/16.
 */
public class Solution {
    public int colorful(int a) {
        if ( a >= 0 && a <= 9) {
            return 1;
        }
        int i = 10;
        Set<Integer> products = new HashSet<>();
        List<Integer> digits = new ArrayList<>();
        while(a > 0) {
            digits.add(a%i);
            a = a/i;
        }
        int len = digits.size();
        int[][] productSubSequence = new int[len][len];
        for (i = 0; i < len ; i++) {
            for ( int j = 0; j <= i; j++) {
                int product = 0;
                if ( j == i){
                    product = digits.get(i);
                    productSubSequence[i][j] = product;
                } else {
                    product = productSubSequence[i-1][j] * digits.get(i);
                    productSubSequence[i][j] = product;
                }
                if (products.contains(product)) {
                    return 0;
                }
                products.add(product);
            }
        }
        return 1;
    }
}
