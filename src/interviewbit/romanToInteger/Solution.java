package interviewbit.romanToInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/roman-to-integer/
 * Created by adib on 9/5/16.
 */
public class Solution {
    private final static Map<Character,Integer> romanToIntegerMap = new HashMap<>();

    static {
        romanToIntegerMap.put('I', 1);
        romanToIntegerMap.put('V', 5);
        romanToIntegerMap.put('X', 10);
        romanToIntegerMap.put('L', 50);
        romanToIntegerMap.put('C', 100);
        romanToIntegerMap.put('D', 500);
        romanToIntegerMap.put('M', 1000);
    }

    public int romanToInt(String a) {
        if (a == null || a.length() == 0)
            return 0;
        int len = a.length();
        int i = 0;
        int result = 0;
        while (i < len) {
            char literal = a.charAt(i++);
            int literalValue = romanToIntegerMap.get(literal);
            if ( (literal == 'I' || literal == 'X' || literal == 'C') && i < len) {
                //check next literal to make sense of the value
                char nextLiteral = a.charAt(i);
                int nextLiteralValue = romanToIntegerMap.get(nextLiteral);
                if ( literalValue < nextLiteralValue) {
                    result += nextLiteralValue - literalValue;
                    i++;
                    continue;
                }
            }
            result += romanToIntegerMap.get(literal);
        }
        return result;
    }
}
