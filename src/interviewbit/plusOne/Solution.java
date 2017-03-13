package interviewbit.plusOne;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/add-one-to-number/
 * Created by adib on 8/17/16.
 */
public class Solution {

    public ArrayList<Integer> plusOne(ArrayList<Integer> digits) {
        ArrayList<Integer> result = new ArrayList<>();
        if (digits == null || digits.size() == 0) {
            result.add(1);
            return result;
        }
        int len = digits.size();
        int mostSigDigit = 0;
        for ( int i = 0; i < len; i++) {
            if (digits.get(i) != 0) {
                break;
            }
            mostSigDigit++;
        }
        int add = 1;
        int carry = 0;
        for (int i = len - 1; i >= mostSigDigit; i--) {
            int sum = digits.get(i) + add;
            if (sum > 9) {
                sum = sum % 10;
                add = 1;
            } else {
                add = 0;
            }
            result.add(sum);
        }
        if (add == 1) {
            result.add(1);
        }
        Collections.reverse(result);
        return result;
    }

    public ArrayList<Integer> plusOneOld(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> out = new ArrayList<Integer>();
        if (a == null || a.size() == 0) {
            result.add(1);
            return result;
        }
        int carry = 1;
        int sum = 0;
        for (int i = a.size() - 1; i>-1; i--) {
            sum = a.get(i) + carry;
            carry = sum/10;
            result.add(sum%10);
        }
        if (carry == 1) {
            result.add(1);
        }
        boolean firstDigitFound = false;
        for (int i = result.size() - 1; i > -1; i--) {
            if (result.get(i) == 0 && !firstDigitFound) {
                continue;
            }
            firstDigitFound = true;
            out.add(result.get(i));
        }

        return out;
    }
}
