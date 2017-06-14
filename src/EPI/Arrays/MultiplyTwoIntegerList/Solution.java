package EPI.Arrays.MultiplyTwoIntegerList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by adib on 4/30/17.
 */
public class Solution {
    public static List<Integer> multiply(List<Integer> x, List<Integer> y) {
        if ( x == null || y == null ) {
            return null;
        }
        List<Integer> result = new ArrayList<>();

        int neg = 1;
        if(x.get(0) < 0) {
            neg = neg * -1;
            x.set(0, x.get(0) * -1);
        }
        if ( y.get(0) < 0) {
            neg = neg * -1;
            y.set(0, y.get(0) * -1);
        }

        for ( int iy = y.size() - 1; iy >= 0; iy--) {
            int startIY = y.size() - iy - 1;
            int carry = 0;
            for ( int ix = x.size() - 1; ix >= 0; ix--) {
                int startIX = x.size() - ix - 1;
                int oldResult = result.size()-1 >= startIY + startIX ? result.get(startIY + startIX):0;
                int mulResult = x.get(ix) * y.get(iy);
                int newResult = (oldResult + mulResult + carry) % 10;
                carry = (oldResult + mulResult + carry) / 10;
                if (result.size()-1 >= startIY + startIX) {
                    result.set(startIY + startIX, newResult);
                } else {
                    result.add(newResult);
                }
            }
            if ( carry > 0 ) {
                result.add(carry);
            }
        }
        Collections.reverse(result);
        if ( neg < 0) {
            result.set(0, result.get(0) * neg);
        }
        return result;
    }
}
