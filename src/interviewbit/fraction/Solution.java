package interviewbit.fraction;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/fraction/
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 * Remainder calculation is not that hard to think off. Every time a remainder is there, you have to multiply it by 10 to form the numerator.
 * Although the hard thing was to think how to go back in the string once you you find the numerator has been seen before i.e how to store the value in the for numerator
 * First way i thought was to store the whole remainder in the value for the numerator ket that doesn't work.
 * Then i thought of using the linked list for storing the values of the numerator/denominator and map it with hash map, that makes it quite complicated though i think it will work.
 * With this i though string itself is like a linked list if i can store the index for the quotient in the value of the map for the numerator key.
 * This worked!! :)
 * Some edge cases remember that recurrent can be after some digits like 87/22 3.9(54)
 * Also negative values have some edge cases. like if the quotient is zero initially it doesn't add the sign or integer.MIN_VALUE cannot be converted to int positive so better use long.
 * So better add the sign if either numerator or denominator is < 0 and then make both of them positive.
 * Created by adib on 9/29/16.
 */
public class Solution {
    public String fractionToDecimal(int num, int denom) {
        if (denom == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        long numerator = num;
        long denominator = denom;
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            sb.append("-");
        }
        if (denominator < 0) {
            denominator = -1 * denominator;
        }
        if (numerator < 0) {
            numerator = -1 * numerator;
        }
        long quotient = numerator / denominator;
        sb.append(quotient);
        long remainder = numerator % denominator;
        if (remainder == 0) {
            return sb.toString();
        }
        StringBuilder remainStr = new StringBuilder();
        Map<Long, Integer> remainderMap = new HashMap<>();
        int index = 0;
        numerator = remainder * 10;
        while(remainder != 0 && !remainderMap.containsKey(numerator)) {
            remainderMap.put(numerator, index);
            remainStr.append(numerator/ denominator);
            remainder = numerator % denominator;
            numerator = remainder * 10;
            index++;
        }
        sb.append(".");
        if (remainder == 0) {
            sb.append(remainStr);
            return sb.toString();
        }

        int numIndex = remainderMap.get(numerator);
        if ( numIndex == 0) {
            //recurring start just after the .
            sb.append("(");
            sb.append(remainStr);
            sb.append(")");
            return sb.toString();
        }
        //recurring starts somewhere in between.
        sb.append(remainStr.substring(0,numIndex));
        sb.append("(");
        sb.append(remainStr.substring(numIndex, remainStr.length()));
        sb.append(")");
        return sb.toString();
    }
}


