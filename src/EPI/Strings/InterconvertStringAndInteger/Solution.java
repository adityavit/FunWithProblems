package EPI.Strings.InterconvertStringAndInteger;

/**
 * Implement String/integer inter-conversion function.
 * Created by adib on 6/21/17.
 */
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IntegerOverFlowException{
        int val1 = stringToInteger("123");
        int val2 = stringToInteger("-123");
        int val3 = stringToInteger("0123");
        assert(val1 == 123);
        assert(val2 == -123);
        assert(val3 == 123);
        try {
            int val4 = stringToInteger("0123A");
            assert(false);
        } catch (NumberFormatException ex) {
            assert(true);
        }
        try {
            int val5 = stringToInteger("12345678912");
            assert(false);
        } catch (IntegerOverFlowException ex) {
            assert(true);
        }


        String str1 = integerToString(123);
        String str2 = integerToString(-123);
        String str3 = integerToString(100);
        String str4 = integerToString(0);
        String str5 = integerToString(Integer.MIN_VALUE);
        assert(str1.equals("123"));
        assert(str2.equals("-123"));
        assert(str3.equals("100"));
        // Edge cases 0 and INTEGER.MIN_VALUE as the INTEGER.MIN_VALUE there is no positive value in 32 bit integer.
        assert(str4.equals("0"));
        assert(str5.equals("-2147483648"));
        assert(Integer.MIN_VALUE == 0x80000000); // Integer.MIN_VALUE = 0x80000000 which is the 32nd bit set, there is no corresponding number for this value.
        assert(Integer.MAX_VALUE == 0x7FFFFFFF); // Integer.MAX_VALUE === 0x7FFFFFFF which is 31 bits set, the 32nd bit when set becomes negative value.
    }

    public static int stringToInteger(String number) throws NumberFormatException,IntegerOverFlowException {
        if (number.length() == 0) {
            return 0;
        }
        int neg = (number.charAt(0) == '-') ? -1 : 1;
        int startIndex = neg == -1 ? 1 : 0;
        int result = 0;
        for ( int i = startIndex; i < number.length(); i++) {
            if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                result = result * 10 + number.charAt(i) - '0';
                if (result < 0) {
                    throw new IntegerOverFlowException("Integer to big " + number);
                }
            } else {
                throw new NumberFormatException(number.charAt(i) + " is not a valid character");
            }
        }
        return result * neg;
    }

    private static class IntegerOverFlowException extends Exception {
        public IntegerOverFlowException(String message) {
            super(message);
        }
    }

    public static String integerToString(int number) {
        if (number == 0) {
            return "0";
        }
        //Important edge case.
        if (number == Integer.MIN_VALUE) {
            return "-2147483648";
        }
        StringBuilder sb = new StringBuilder();
        int neg = number < 0 ? -1 : 1;
        number = number * neg;
        while ( number > 0) {
            sb.append(number%10);
            number = number/10;
        }
        if (neg < 0) {
            sb.append('-');
        }
        sb.reverse();
        return sb.toString();
    }

}
