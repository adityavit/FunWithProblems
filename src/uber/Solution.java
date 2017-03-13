package uber;

/**
 * Created by adib on 9/27/16.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        System.out.println(convertString2Int("01A", 16));
    }

    // This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.
//    "-123" >
//            "123"  > 123
//            "011" > 11
//            "a" >
//            "" > 0
//
//            "010" => 10
//            "0112" => 2
//            "010" => 16

    static int convertString2Int(String str, int base) throws Exception{
        if (str == null || str.length() == 0) {
            return 0;
        }
        //str = 0123
        long result = 0;
        int len = str.length(); //len = 4
        int i = 0;
        while ( i < len) {
            char c = str.charAt(i); // c = '0', c = '1' , c = '2', c = '3' // 010 --> '0', '1' , '0'
            int digit = isValidBaseDigit(c, base); // digit = 0 , d = 1 , d = 1
            result = result*base + digit; //result = 0, r = 1, r = 12, r = 123 // r = 0 , 2 , 3
            if ( result > Integer.MAX_VALUE) {
                throw new Exception(" String is greater than " + Integer.MAX_VALUE);
            }
            i++;
        }
        return (int)result;
    }

    static int isValidBaseDigit(char ch, int base) throws Exception {
        // 0 9 A Z
        int digit = -1;
        if (ch - '0' >= 0 && ch - '0' <= 9) {
            digit = ch - '0'; //d = 2
        }
        if ( digit >= 0 && digit < base)
            return digit;

        digit = 10;
        if (ch >= 'A' && ch <= 'Z') {
            digit = digit + (ch - 'A');
        }
        if (digit >= 10)
            return digit;
        throw new Exception("Invalid digit " + ch);
    }
}
